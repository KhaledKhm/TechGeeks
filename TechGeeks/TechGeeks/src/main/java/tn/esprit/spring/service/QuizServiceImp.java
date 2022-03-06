package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Certificate;
import tn.esprit.spring.entities.Question;
import tn.esprit.spring.entities.Quiz;
import tn.esprit.spring.entities.Training;
import tn.esprit.spring.repository.CertificateRepository;
import tn.esprit.spring.repository.QuestionRepository;
import tn.esprit.spring.repository.QuizRepository;
import tn.esprit.spring.repository.TrainingRepository;

@Service
public class QuizServiceImp implements IQuizService{
	@Autowired
	QuizRepository quizRepository ;
	@Autowired
	CertificateRepository certificateRepository ;
	@Autowired
	TrainingRepository trainingRepository;
	
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

/*	@Override
	public void addQuizByCertificate(Quiz quiz, int idCertificate) {
		Certificate c = certificateRepository.findById(idCertificate).orElse(null);
		quiz.setCertificate(c);
		quizRepository.save(quiz);	
	}*/
	
	@Override
	public void AffecterCertificate(int idQuiz, List<Certificate> certificates) {
		certificateRepository.saveAll(certificates);
		Quiz q =quizRepository.findById(idQuiz).orElse(null);
		for (Certificate certificate : certificates) {
			certificate.setQuiz(q);
		}
		certificateRepository.saveAll(certificates);
	}
	
	@Override
	public void AffecterAllCertificates(int idQuiz, List<Certificate> certificates) {
		//certificateRepository.saveAll(certificates);
		certificates = certificateRepository.findAll();
		Quiz q =quizRepository.findById(idQuiz).orElse(null);
		certificates.forEach(c->{
			if(c.getTraining().getIdTraining() == q.getTraining().getIdTraining()){
			c.setQuiz(q);
			}
		}); 
		/*for (Certificate certificate : certificates) {
			certificate.setQuiz(q);
		}*/
		certificateRepository.saveAll(certificates);
	}
	
	@Override
	public void addQuizByTraining(Quiz quiz, int idTraining) {
		Training t = trainingRepository.findById(idTraining).orElse(null);
		quiz.setTraining(t);
		quizRepository.save(quiz);	
	}



}
