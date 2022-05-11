import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Complaint } from 'src/app/model/complaint';
import { Type } from 'src/app/model/type';
import { User } from 'src/app/model/user';
import { ComplaintService } from 'src/app/service/complaint.service';

@Component({
  selector: 'app-add-complaint',
  templateUrl: './add-complaint.component.html',
  styleUrls: ['./add-complaint.component.css']
})
export class AddComplaintComponent implements OnInit {
  cmplt:Complaint= new Complaint();
  User:User = new User();
  mplts:Complaint
  iduser=1
  username:any
  type:any=Type;
   keys:string[]=[];
   selected!:Type;
  constructor(private s:ComplaintService,private activatedroute:ActivatedRoute) { }
  Complaint:Complaint[];
  ngOnInit(): void {
    this.keys=Object.keys(this.type)

  }

  addComplaint(cmplt: any,username:any){
    //userid=this.userid;
    //cmplt.username=username;
  //cmplt.type=this.selected;
 console.log(username);
    this.s.addComplaint(cmplt,this.iduser,username).subscribe(() => {
   console.log(cmplt);
    });
  }

}
