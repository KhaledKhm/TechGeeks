package tn.esprit.spring.service;

import tn.esprit.spring.entities.UserAnswer;

public interface IUserAnswerService {
	public void distributeMark (UserAnswer Uanswer,int idQuestion, int idAnswer,int idCertificate );
	public void QuizMark(int idQuiz, int idCertificate);

}
