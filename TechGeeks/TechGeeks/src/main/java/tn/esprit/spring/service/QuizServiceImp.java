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
	
	@Override
	public List<Certificate> AffecterCertificate (int idQuiz, int idtraining) {
		Quiz q =quizRepository.findById(idQuiz).orElse(null);
		List <Certificate> certificates = certificateRepository.findAll();
		for (Certificate certificate : certificates) {
			if(q.getTraining().getIdTraining() == certificate.getTraining().getIdTraining()){
			certificate.setQuiz(q);
			}
		}
		return certificateRepository.saveAll(certificates);
	}
	
	@Override
	public void addQuizByTraining(Quiz quiz, int idTraining) {
		Training t = trainingRepository.findById(idTraining).orElse(null);
		quiz.setTraining(t);
		quizRepository.save(quiz);	
	}

}
