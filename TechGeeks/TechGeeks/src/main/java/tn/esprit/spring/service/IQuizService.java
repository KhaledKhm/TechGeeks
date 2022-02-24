package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;

import tn.esprit.spring.entities.Quiz;

public interface IQuizService {
	public void addQuiz(Quiz quiz);
	public void addQuizByCertificate(Quiz quiz,int idCertificate);
	public Quiz updateQuiz(Quiz quiz);
	public void deleteAllQuizs();
	public void deleteQuizById(int idQuiz);
	public List<Quiz> getAllQuizs();
	public Optional<Quiz> getQuizById(int idQuiz);
}