package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Certificate;
import tn.esprit.spring.entities.Question;
import tn.esprit.spring.entities.Quiz;
import tn.esprit.spring.repository.CertificateRepository;
import tn.esprit.spring.repository.QuestionRepository;
import tn.esprit.spring.repository.QuizRepository;

@Service
public class QuizServiceImp implements IQuizService{
	@Autowired
	QuizRepository quizRepository ;
	@Autowired
	CertificateRepository certificateRepository ;
	
	@Override
	public void addQuiz(Quiz quiz) {
		quizRepository.save(quiz);	
	}

	@Override
	public Quiz updateQuiz(Quiz quiz) {
		Quiz q = quizRepository.findById(quiz.getIdQuiz()).orElse(null);
		q.setMark(quiz.getMark());
		q.setTitle(quiz.getTitle());
		return quizRepository.save(q);
	}

	@Override
	public void deleteAllQuizs() {
		quizRepository.deleteAll();
	}

	@Override
	public void deleteQuizById(int idQuiz) {
		quizRepository.deleteById(idQuiz);
		
	}

	@Override
	public List<Quiz> getAllQuizs() {
		return quizRepository.findAll();
	}

	@Override
	public Optional<Quiz> getQuizById(int idQuiz) {
		return quizRepository.findById(idQuiz);
	}

	@Override
	public void addQuizByCertificate(Quiz quiz, int idCertificate) {
		Certificate c = certificateRepository.findById(idCertificate).orElse(null);
		quiz.setCertificate(c);
		quizRepository.save(quiz);	
	}


}
