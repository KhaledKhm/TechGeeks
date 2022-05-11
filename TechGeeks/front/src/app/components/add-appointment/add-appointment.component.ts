import { Component, OnInit } from '@angular/core';
import { Appointment } from 'src/app/model/appointment';
import { AppointmentService } from 'src/app/service/appointment.service';

@Component({
  selector: 'app-add-appointment',
  templateUrl: './add-appointment.component.html',
  styleUrls: ['./add-appointment.component.css']
})
export class AddAppointmentComponent implements OnInit {
  app:Appointment= new Appointment();
  iduser=1
  username:any
 
  constructor(private s:AppointmentService) { }

  ngOnInit(): void {
  }
  addapointment(app:any,username:any){
    console.log(app);
    //iduser=this.iduser;
    //this.idexpert=idexpert;
    console.log(app);
    console.log(username);
    this.s.addappointment(app,this.iduser,username).subscribe(() => {
   
    });
  }

}
