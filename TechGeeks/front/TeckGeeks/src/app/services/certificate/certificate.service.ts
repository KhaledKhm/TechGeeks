import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CertificateService {
  readonly API_URL = 'http://localhost:8089';

  constructor(private httpClient: HttpClient) { }

  getCertificateByUser(id : any){
    return this.httpClient.get(`${this.API_URL}/getCertificateByUser/${id}`)
  }
}
