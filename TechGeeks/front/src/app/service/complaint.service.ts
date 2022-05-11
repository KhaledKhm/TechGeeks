import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Complaint } from '../model/complaint';

@Injectable({
  providedIn: 'root'
})
export class ComplaintService {
  readonly API_URl ='http://localhost:8086/SpringPI'

  constructor( private httpClient:HttpClient) { }
  getAllComplaints(): Observable<Complaint[]>{
    return this.httpClient.get<Complaint[]>(this.API_URl + '/retrieve-Complaints');

  }
      //return this.httpClient.get(`${this.API_URl}/retrieve-Complaints`);
      getComplaintById(id:any): Observable<Complaint[]>{
        return this.httpClient.get<Complaint[]>(`${this.API_URl}/retrieve-Complaint/${id}`);
    
      }
  
  addComplaint(complaint:Complaint,iduser:any,username:any){
    return this.httpClient.post(`${this.API_URl}/addassign-complaint/${iduser}/${username}`,Complaint);

  }
  editComplaint(complaint:any,id:any){
    return this.httpClient.put(`${this.API_URl}/modify-Complaint/${id}`,complaint);

  }
  deleteComplaint(idComplaint:any){ 
   return this.httpClient.delete(this.API_URl +'/delete-Complaint/'+idComplaint);
}

}
