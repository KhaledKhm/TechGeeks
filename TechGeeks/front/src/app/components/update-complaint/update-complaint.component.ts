import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Complaint } from 'src/app/model/complaint';
import { Type } from 'src/app/model/type';
import { ComplaintService } from 'src/app/service/complaint.service';

@Component({
  selector: 'app-update-complaint',
  templateUrl: './update-complaint.component.html',
  styleUrls: ['./update-complaint.component.css']
})
export class UpdateComplaintComponent implements OnInit {
  complaints:any;
  type:any=Type;
  keys:string[]=[];
  selected!:Type;
  constructor(private s:ComplaintService,private router:Router,private route:ActivatedRoute) {
  }
  cmplt:Complaint= new Complaint();

 
 

  ngOnInit(): void {
    this.getById();
    this.keys=Object.keys(this.type);
  }
  id!:number;
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
    cmplt.type=this.selected;
   // cmplt.id=this.id;
  this.s.editComplaint(cmplt,this.id).subscribe(
    ()=>{
      this.router.navigate([
        `updatecomplaint/${this.id}`]);    }
  );
  console.log(this.cmplt);
  }

}
