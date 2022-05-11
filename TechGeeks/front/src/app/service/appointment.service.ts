import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Appointment } from '../model/appointment';

@Injectable({
  providedIn: 'root'
})
export class AppointmentService {

  readonly API_URl ='http://localhost:8086/SpringPI'

  constructor( private httpClient:HttpClient) { }
  getAllappointments(): Observable<Appointment[]>{
    return this.httpClient.get<Appointment[]>(this.API_URl + '/retrieve-Appointments');

  }
  getappById(id:any): Observable<Appointment[]>{
    return this.httpClient.get<Appointment[]>(`${this.API_URl}/retrieve-Appointment/${id}`);

  }
  addappointment(appointment:Appointment,iduser:any,username:any){
    return this.httpClient.post(`${this.API_URl}/add-Appointment/${iduser}/${username}`,appointment);

  }
  editappointment(appointment:any,id:any){
    return this.httpClient.put(`${this.API_URl}/modify-Appointment/${id}`,appointment);

  }
  deleteappointment(idapp:any){ 
   return this.httpClient.delete(this.API_URl +'/delete-Appointment/'+idapp);
}

}
