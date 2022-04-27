import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class DonationService {
  readonly API_URL = 'http://localhost:8089';
  constructor(private httpClient: HttpClient) { }
  
	addDonation(donation:any){
    return this.httpClient.post(`${this.API_URL}/add-donation`,donation)
	}
	

	assignDonationtoPot(donation:any,  idPot:any){
		return this.httpClient.post(`${this.API_URL}/assign-pot-to-donation/${idPot}`,donation)
	}
	
	addAndAssignPotAndUser(donation:any,idPot:any, idUser:any){
		return this.httpClient.post(`${this.API_URL}/add-and-assign-user-pot-to-donation/${idPot}/${idUser}`,donation)
	}
	
	
	retrieveAllDonations(){
		return this.httpClient.get(`${this.API_URL}/retrieve-allDonations`)
	}
	
	getDonationById(idDonation:any){
		return this.httpClient.get(`${this.API_URL}/get-Donation/${idDonation}`)
		
	}
	
updateDonation(donation:any){		
  return this.httpClient.put(`${this.API_URL}/modify-donation`,donation)
	}
	
	deleteDonation(idDonation:any){
		return this.httpClient.delete(`${this.API_URL}/delete-donation/${idDonation}`)
  }

}