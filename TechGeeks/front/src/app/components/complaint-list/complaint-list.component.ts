import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Complaint } from 'src/app/model/complaint';
import { ComplaintService } from 'src/app/service/complaint.service';
import { Type } from 'src/app/model/type';
@Component({
  selector: 'app-complaint-list',
  templateUrl: './complaint-list.component.html',
  styleUrls: ['./complaint-list.component.css']
})
export class ComplaintListComponent implements OnInit {

  constructor(  private s:ComplaintService,private router:Router,private route:ActivatedRoute) { }
  ListComplaint:any;
  id:any;
  complaints:any;
  type:any=Type;
   keys:string[]=[];
   selected!:Type;
   cmplt:Complaint= new Complaint();
   form: boolean = false;
   closeResult!: string;
  ngOnInit(): void {
    this.getALLComplaints();
    this.getById();
  }
  getALLComplaints(){
    this.s.getAllComplaints().subscribe(
      (d)=>{
        //this.Complaint=d;
        console.log(d);
        this.ListComplaint=d;
      }
    ); 
  }

  delete(id : any){
   // idComplaint = this.idComplaint
  // this.id=this.route.snapshot.params['id'];
   console.log(this.id)
   this.s.deleteComplaint(id).subscribe(
     (d)=>{
       this.complaints=d;
     }
   );
    
  }
  getById(){
       this.id=this.route.snapshot.params['id'];
    console.log(this.id)
    this.s.getComplaintById(this.id).subscribe(
      (d)=>{
        this.complaints=d;
        console.log( this.complaints)
      }
    );
  }
  save(cmplt:any){
    //cmplt.Type=this.selected;
   // this.complaints.toUser.id= this.touser;
  // this.id=this.route.snapshot.params['id'];
  this.s.editComplaint(this.id,cmplt).subscribe(
    ()=>{
      this.router.navigate([
        `updatecomplaint/${this.id}`]);   }
  );
  }

  
  

  
}