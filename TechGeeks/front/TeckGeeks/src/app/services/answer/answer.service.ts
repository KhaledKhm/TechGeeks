import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AnswerService {

  readonly API_URL = 'http://localhost:8089';

  constructor(private httpClient: HttpClient) { }

  addAnswer(Answer : any) {
    return this.httpClient.post(`${this.API_URL}/addAnswer`,Answer)
  }

  getAllAnswers() {
    return this.httpClient.get(`${this.API_URL}/getAllAnswers`)
  }

  editAnswer(answer : any, idAnswer : any){
    return this.httpClient.put(`${this.API_URL}/updateTraining/${idAnswer}`,answer)
  }

  deleteAnswer(idAnswer : any){
    return  this.httpClient.delete(`${this.API_URL}/deleteAnswerById/${idAnswer}`)
  }

  getById(idAnswer : any , Answer : any) {
    return this.httpClient.get(`${this.API_URL}/getAnswerById/${idAnswer}`,Answer)
  }

  addAnswerByQuestion(question : any , Answer : any) {
    return this.httpClient.post(`${this.API_URL}/addAnswerByQuestion/${question}`,Answer)
  }  


  getAnswerByQuestion(idQuestion : any) {
    return this.httpClient.get(`${this.API_URL}/getAnswerByQuestion/${idQuestion}`)
  }

}
