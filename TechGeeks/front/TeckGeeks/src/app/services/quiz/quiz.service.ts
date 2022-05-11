import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class QuizService {
  readonly API_URL = 'http://localhost:8089';

  constructor(private httpClient: HttpClient) { }

  addQuiz( idTraining : any, quiz : any) {
    return this.httpClient.post(`${this.API_URL}/addQuizByTraining/${idTraining}`,quiz)
  }

  getQuizBytraining(training : any) {
    return this.httpClient.get(`${this.API_URL}/getQuizByTraining/${training}`)
  }

}
