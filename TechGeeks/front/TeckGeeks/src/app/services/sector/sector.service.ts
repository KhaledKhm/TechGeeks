import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class SectorService {
  readonly API_URL = 'http://localhost:8089/SpringMVC';

  constructor(private httpClient: HttpClient) { }

  getAllSectors() {
    return this.httpClient.get(`${this.API_URL}/getAllSectors`)
  }

  getSectorById(idSector : any) {
    return this.httpClient.get(`${this.API_URL}/getSectorById/${idSector}`)
  }

}
