import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Appointment } from 'src/app/model/appointment';
import { AppointmentService } from 'src/app/service/appointment.service';

@Component({
  selector: 'app-update-appointment',
  templateUrl: './update-appointment.component.html',
  styleUrls: ['./update-appointment.component.css']
})
export class UpdateAppointmentComponent implements OnInit {

  constructor(private s:AppointmentService,private router:Router,private route:ActivatedRoute) { }
  app:Appointment= new Appointment();

  appoits:any;

  ngOnInit(): void {
    this.getById();
  }
  id!:number;

  getById(){
    
    this.id=this.route.snapshot.params['id'];
    console.log(this.id)
    this.s.getappById(this.id).subscribe(
      (d)=>{
        this.appoits=d;
        console.log(this.appoits)
      }
    );
  }
  save(app:any){
    //cmplt.type=this.selected;
   // cmplt.id=this.id;
  this.s.editappointment(app,this.id).subscribe(
    ()=>{
      this.router.navigate([
        `updateappointment/${this.id}`]);    }
  );
  console.log(this.app);
  }
}
