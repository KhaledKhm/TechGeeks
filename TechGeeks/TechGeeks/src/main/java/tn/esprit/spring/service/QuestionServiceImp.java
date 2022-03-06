package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Question;
import tn.esprit.spring.entities.Quiz;
import tn.esprit.spring.repository.QuizRepository;
import tn.esprit.spring.repository.AnswerRepository;
import tn.esprit.spring.repository.QuestionRepository;

@Service
public class QuestionServiceImp implements IQuestionService{

	@Autowired
	QuizRepository quizRepository ;
	@Autowired
	AnswerRepository answerRepository ;
	@Autowired
	QuestionRepository questionRepository ;
	
	@Override
	public void addQuestion(Question question) {
		questionRepository.save(question);	
	}

	@Override
	public Question updateQuestion(Question question) {
		Question q = questionRepository.findById(question.getIdQuestion()).orElse(null);
		q.setQuestion(question.getQuestion());
		return questionRepository.save(q);
	}

	@Override
	public void deleteAllQuestions() {
		questionRepository.deleteAll();
	}

	@Override
	public void deleteQuestionById(int idQuestion) {
		questionRepository.deleteById(idQuestion);
	}
	/*@Override
	public void deleteQuestionWithAnswer(int idQuestion) {
		questionRepository.deleteById(idQuestion);
		answerRepository.deleteByIdQuestion(idQuestion);
	}*/

	@Override
	public List<Question> getAllQuestions() {
		return questionRepository.findAll();
	}

	@Override
	public Optional<Question> getQuestionById(int idQuestion) {
		return questionRepository.findById(idQuestion);
	}

	@Override
	public void addQuestionByQuiz(Question question, int idQuiz) {
		Quiz q = quizRepository.findById(idQuiz).orElse(null);
		question.setQuiz(q);
		questionRepository.save(question);	
	}

}
