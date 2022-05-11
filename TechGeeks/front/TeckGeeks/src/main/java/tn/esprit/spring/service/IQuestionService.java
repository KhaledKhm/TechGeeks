package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;

import tn.esprit.spring.entities.Question;

public interface IQuestionService {
	public void addQuestion(Question question);
	public void addQuestionByQuiz(Question question,int idQuiz);
	public Question updateQuestion(Question question);
	public void deleteAllQuestions();
	public void deleteQuestionById(int idQuestion);
	public List<Question> getAllQuestions();
	public Optional<Question> getQuestionById(int idQuestion);
	//public void deleteQuestionWithAnswer(int idQuestion);
	public Question getQuestionByQuiz(int idQuiz);
}
