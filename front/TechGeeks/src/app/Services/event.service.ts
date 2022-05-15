import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class EventService {
  readonly API_URL = 'http://localhost:8089';
  constructor(private httpClient: HttpClient) { }

	addEvent(event:any){
		return this.httpClient.post(`${this.API_URL}/add-event`,event)
	}
	

	retrieveAllEvents(){
		return this.httpClient.get(`${this.API_URL}/retrieve-allEvents`)
	}
	
	getLocalById(idEvent:any){
		return this.httpClient.get(`${this.API_URL}"/get-Event/${idEvent}`)
	}
	
	newestEvent(){
		return this.httpClient.get(`${this.API_URL}/newest-Event`)
		
	}
	

	updateEvent(event:any){
    return this.httpClient.put(`${this.API_URL}/modify-event`,event)
	}
	
  deleteEvent(idEvent:any){
    return this.httpClient.delete(`${this.API_URL}/delete-event/${idEvent}`)
		
	}
	

	assignLocalToEvent(event:any, idLocal:any){
		return this.httpClient.post(`${this.API_URL}/assign-local-to-event/${idLocal}`,event)
	}
	

	assignUserToEvent(idEvent:any, idUser:any){
		return this.httpClient.put(`${this.API_URL}/assign-local-to-event/${idEvent}/${idUser}`,event)
	}
	

	mostEarningEvent(){
		return this.httpClient.get(`${this.API_URL}/most-profitable-event`)	
	}
	

  mostParticipatingUser(){
		return this.httpClient.get(`${this.API_URL}/most-particpating-user-Event`)	
		
	}

	sortParticipatingUsers(){
		return this.httpClient.get(`${this.API_URL}/sort-most-particpating-users-Event`)		
	}
	

	addMoneyFromPotToEvent(idEvent:any, idPot:any, money:any){
		return this.httpClient.put(`${this.API_URL}/assign-local-to-event/${idEvent}/${idPot}`,money)
	}
}
