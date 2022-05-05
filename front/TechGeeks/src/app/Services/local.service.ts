import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LocalService {
  readonly API_URL = 'http://localhost:8089';
  constructor(private httpClient: HttpClient) { }

	addLocal(local:any){
		return this.httpClient.post(`${this.API_URL}/add-local`,local)
	}
	
  retrieveAllLocals(){
		return this.httpClient.get(`${this.API_URL}/retrieve-allLocals`)
	}
	
	 getLocalById(idLocal:any){
		return this.httpClient.get(`${this.API_URL}"/get-Event/${idLocal}`)
		
	}
	
	updateLocal(local:any){
		return this.httpClient.put(`${this.API_URL}/modify-local`,local)
	}
	
	deleteLocal(idLocal:any){
		return this.httpClient.delete(`${this.API_URL}/delete-local/${idLocal}`)
		
	}
	
	assignEventToLocal(idLocal:any,idEvent:any){
		return this.httpClient.put(`${this.API_URL}/assign-event-to-local/${idLocal}/${idEvent}`,event)
	}

}
