import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class QuestionService {

  readonly API_URL = 'http://localhost:8089';

  constructor(private httpClient: HttpClient) { }

  addQuestionByquiz( idQuiz : any, question : any) {
    return this.httpClient.post(`${this.API_URL}/addQuestionByQuiz/${idQuiz}`,question)
  }

  getQuestionByQuiz(idQuiz : any) {
    return this.httpClient.get(`${this.API_URL}/getQuestionByQuiz/${idQuiz}`)
  }

  addQuestion(Question : any) {
    return this.httpClient.post(`${this.API_URL}/addQuestion`,Question)
  }

}
