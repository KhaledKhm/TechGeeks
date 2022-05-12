package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import tn.esprit.spring.entities.Question;

public interface IQuestionService {
	public void addQuestion(Question question);
	public Question addQuestionByQuiz(Question question,int idQuiz);
	public Question updateQuestion(Question question);
	public void deleteAllQuestions();
	public void deleteQuestionById(int idQuestion);
	public List<Question> getAllQuestions();
	public Optional<Question> getQuestionById(int idQuestion);
	//public void deleteQuestionWithAnswer(int idQuestion);
	public List <Question> getQuestionByQuiz(int idQuiz);
	public Question updateQuestionByid (  Question question, int idQuestion);
}
