package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Answer;
import tn.esprit.spring.entities.Question;
import tn.esprit.spring.repository.AnswerRepository;
import tn.esprit.spring.repository.QuestionRepository;

@Service
public class AnswerServiceImp implements IAnswerService{
	
	@Autowired
	AnswerRepository answerRepository ;
	@Autowired
	QuestionRepository questionRepository ;
	
	@Override
	public void addAnswer(Answer answer) {
		answerRepository.save(answer);	
	}

	@Override
	public Answer updateAnswer(Answer answer) {
		Answer a = answerRepository.findById(answer.getIdAnswer()).orElse(null);
		a.setAnswer(answer.getAnswer());
		return answerRepository.save(a);
	}

	@Override
	public void deleteAllAnswers() {
		answerRepository.deleteAll();
	}

	@Override
	public Answer deleteAnswerByAnswer(String answer) {
		return answerRepository.deleteByAnswer(answer);
	}

	@Override
	public void deleteAnswerById(int idAnswer) {
		answerRepository.deleteById(idAnswer);
		
	}

	@Override
	public List<Answer> getAllAnswers() {
		return answerRepository.findAll();
	}

	@Override
	public Optional<Answer> getAnswerById(int idAnswer) {
		return answerRepository.findById(idAnswer);
	}

	@Override
	public Optional<Answer> getAnswerByAnswer(String answer) {
		return answerRepository.findByAnswer(answer);
	}

	@Override
	public void addAnswerByQuestion(Answer answer, Question question) {
		List <Question> qs = questionRepository.findAll();
		for(Question q : qs){
			if(q == question){
				answer.setQuestion(question);
				answerRepository.save(answer);	
			}
		}
		
	}

	@Override
	public void addAnswersByQuestion(Set<Answer> answers, Question question) {
		Question q = questionRepository.save(question);
		for(Answer a : answers){
			a.setQuestion(q);
			q.setAnswers(answers);
		}
		

		
	}


}
