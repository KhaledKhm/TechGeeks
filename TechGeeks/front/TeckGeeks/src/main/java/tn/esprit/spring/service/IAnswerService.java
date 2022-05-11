package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import tn.esprit.spring.entities.Answer;
import tn.esprit.spring.entities.Question;

public interface IAnswerService {
	public void addAnswer(Answer answer);
	public void addAnswerByQuestion(Answer answer, Question question);
	public Answer updateAnswer(Answer answer);
	public void deleteAllAnswers();
	public Answer deleteAnswerByAnswer(String answer);
	public void deleteAnswerById(int idAnswer);
	public List<Answer> getAllAnswers();
	public Optional<Answer> getAnswerById(int idAnswer);
	public Optional <Answer> getAnswerByAnswer(String answer);
	public void addAnswersByQuestion(Set<Answer> answers, Question question);

	
}
