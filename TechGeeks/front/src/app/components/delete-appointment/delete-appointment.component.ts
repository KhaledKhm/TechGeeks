import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { AppointmentService } from 'src/app/service/appointment.service';

@Component({
  selector: 'app-delete-appointment',
  templateUrl: './delete-appointment.component.html',
  styleUrls: ['./delete-appointment.component.css']
})
export class DeleteAppointmentComponent implements OnInit {

  constructor(private activatedroute:ActivatedRoute,private s:AppointmentService) { }
  idappointment:any;

  ngOnInit(): void {
    this.idappointment=this.activatedroute.snapshot.params['idappointment'],
    this.s.deleteappointment(this.idappointment).subscribe();
  }

}
