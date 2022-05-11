import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Appointment } from 'src/app/model/appointment';
import { AppointmentService } from 'src/app/service/appointment.service';

@Component({
  selector: 'app-appointment-list',
  templateUrl: './appointment-list.component.html',
  styleUrls: ['./appointment-list.component.css']
})
export class AppointmentListComponent implements OnInit {

  constructor(private s:AppointmentService,private router:Router,private route:ActivatedRoute) { }
    listappointment:any;
    idapp:any;
    aapp:Appointment= new Appointment();

  ngOnInit(): void {
    this.getALLappointments();
    this.getById();

  }
  id!:number;
  getALLappointments(){
    this.s.getAllappointments().subscribe(
      (d)=>{
        console.log(d);
        this.listappointment=d;
      }
  );   
  }
  delete(idapp : any){
    // idComplaint = this.idComplaint
    console.log(idapp);
     this.s.deleteappointment(idapp).subscribe();
     
   }
   getById(){
    this.id=this.route.snapshot.params['id'];
 console.log(this.id)
 this.s.getappById(this.id).subscribe(
   (d)=>{
     //this.app=d;
     ///console.log( this.app)
   }
 );
}
   save(app:any){
    //cmplt.Type=this.selected;
   // this.complaints.toUser.id= this.touser;
  // this.id=this.route.snapshot.params['id'];
  this.s.editappointment(this.idapp,app).subscribe(
    ()=>{
      this.router.navigate([
        `updateappointment/${this.idapp}`]);    }
  );
  }
}
