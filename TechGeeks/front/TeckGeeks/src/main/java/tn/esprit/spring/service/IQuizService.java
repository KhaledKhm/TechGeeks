package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;

import tn.esprit.spring.entities.Certificate;
import tn.esprit.spring.entities.Quiz;
import tn.esprit.spring.entities.Training;

public interface IQuizService {
	public void addQuiz(Quiz quiz);
	public Quiz updateQuiz(Quiz quiz);
	public void deleteAllQuizs();
	public void deleteQuizById(int idQuiz);
	public List<Quiz> getAllQuizs();
	public Optional<Quiz> getQuizById(int idQuiz);
	public void addQuizByTraining(Quiz quiz, int idTraining);
	public List<Certificate> AffecterCertificate(int idQuiz, int idtraining);
	public Quiz getQuizByTraining(int idTaining);

}
