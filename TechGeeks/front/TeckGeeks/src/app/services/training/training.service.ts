import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class TrainingService {

  readonly API_URL = 'http://localhost:8089';

  constructor(private httpClient: HttpClient) { }

  getAllTrainings() {
    return this.httpClient.get(`${this.API_URL}/getAllTrainings`)
  }
  getTrainingbyid(idTraining : any) {
    return this.httpClient.get(`${this.API_URL}/getTrainingById/${idTraining}`)
  }
  getTrainingByUser(id : any){
    return this.httpClient.get(`${this.API_URL}/getTrainingByUser/${id}`)
  }
  addTrainingTrainer(idUser : any, idSector : any, Training : any) {
    return this.httpClient.post(`${this.API_URL}/addTrainingByTrainer/${idUser}/${idSector}`,Training)
  }
  addTrainingWomen(idUser : any, idTraining : any ,training : any) {
    return this.httpClient.post(`${this.API_URL}/addTrainingByTrainer/${idUser}/${idTraining}`,training);

  }
  editTraining(training : any, idTraining : any){
    return this.httpClient.put(`${this.API_URL}/updateTraining/${idTraining}`,training)
  }
  deleteTraining(idTraining : any){
    return  this.httpClient.delete(`${this.API_URL}/deleteTrainingById/${idTraining}`)
  }

  getTrainingBySector(name : any){
    return this.httpClient.get(`${this.API_URL}/getTrainingBySector/${name}`)
  }
}
