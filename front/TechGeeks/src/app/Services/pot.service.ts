import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class PotService {
  readonly API_URL = 'http://localhost:8089';
  constructor(private httpClient: HttpClient) { }

  addPot(pot:any){
		return this.httpClient.post(`${this.API_URL}/add-pot`,pot)
	}
	
	retrieveAllPots(){	
		return this.httpClient.get(`${this.API_URL}/retrieve-allPots`)
	}
	
	getPotById(idPot:any){
		return this.httpClient.get(`${this.API_URL}"/get-Event/${idPot}`)
	}
	
	
	updatePot(pot:any){	
		return this.httpClient.put(`${this.API_URL}/modify-pot`,pot)
	}
	
	deletePot(idPot:any){
		return this.httpClient.delete(`${this.API_URL}/delete-pot/${idPot}`)
		
	}
	
  takeMoneyFromPot(idPot:any, money:any){	
    return this.httpClient.put(`${this.API_URL}/take-money-pot/{idPot}/{money}`,event)
	}

	putMoney(idPot:any,idEvent:any, money:any){	
		return this.httpClient.put(`${this.API_URL}/put-money-pot/${idPot}/${idEvent}/${money}`,event)
		}
}
