package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import tn.esprit.spring.entities.Sector;
import tn.esprit.spring.entities.Training;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.entities.Answer;
import tn.esprit.spring.entities.Local;
import tn.esprit.spring.entities.Question;
import tn.esprit.spring.entities.Quiz;
import tn.esprit.spring.repository.AnswerRepository;
import tn.esprit.spring.repository.CertificateRepository;
import tn.esprit.spring.repository.LocalRepository;
import tn.esprit.spring.repository.QuestionRepository;
import tn.esprit.spring.repository.QuizRepository;
import tn.esprit.spring.repository.TrainingRepository;
import tn.esprit.spring.repository.UserRepository;
import tn.esprit.spring.repository.SectorRepository;

@Service
public class TrainingServiceImp implements ITrainingService{
	@Autowired
	TrainingRepository trainingRepository ;
	@Autowired
	LocalRepository localRepository ;
	@Autowired
	SectorRepository sectorRepository ;
	@Autowired
	UserRepository userRepository ;
	@Autowired
	QuizRepository quizRepository ;
	@Autowired
	CertificateRepository certificateRepository ;
	@Autowired
	QuestionRepository questionRepository;
	@Autowired
	AnswerRepository answerRepository;
	@Override
	public void addTrainingByTrainer(Training training, int idUser, int idSector) {
		User u = userRepository.findById(idUser).orElse(null);
		if (u.getRole().getIdRole() == 1){
		Sector s = sectorRepository.findById(idSector).orElse(null);
		training.setUser(u);
		training.setSector(s);
		trainingRepository.save(training);	}
	}
	
	@Override
	public void addTrainingByAdmin(Training training, int idLocal) {
		Local l = localRepository.findById(idLocal).orElse(null);
		training.setLocal(l);
		trainingRepository.save(training);	
	}

	@Override
	public Training updateTraining(Training training) {
		Training t = trainingRepository.findById(training.getIdTraining()).orElse(null);
		t.setDescription(training.getDescription());
		t.setDateStart(training.getDateStart());
		t.setDateEnd(training.getDateEnd());
		t.setStatus(training.getStatus());
		t.setFeedback(training.getFeedback());
		return trainingRepository.save(t);
	}

	@Override
	public void deleteAllTrainings() {
		List<Training> trainings = trainingRepository.findAll();
		List<Quiz> quizs = quizRepository.findAll();
		List<Question> questions = questionRepository.findAll();
		List<Answer> answers = answerRepository.findAll();
		trainings.forEach(training->{
			quizs.forEach(quiz->{
				if(training.getIdTraining() == quiz.getTraining().getIdTraining()){
				questions.forEach(q->{
					if(quiz.getIdQuiz() == q.getQuiz().getIdQuiz()){
						answers.forEach(a->{
							if(q.getIdQuestion() == a.getQuestion().getIdQuestion()){
								answerRepository.delete(a);
							}
						});
						questionRepository.delete(q);
						}
					});
				}
				});
			trainingRepository.delete(training);
		});
	}

	@Override
	public void deleteTrainingById(int idTraining) {
		Training training = trainingRepository.findById(idTraining).get();
		List<Quiz> quizs = quizRepository.findAll();
		List<Question> questions = questionRepository.findAll();
		List<Answer> answers = answerRepository.findAll();
		quizs.forEach(quiz->{
			if(training.getIdTraining() == quiz.getTraining().getIdTraining()){
			questions.forEach(q->{
				if(quiz.getIdQuiz() == q.getQuiz().getIdQuiz()){
					answers.forEach(a->{
						if(q.getIdQuestion() == a.getQuestion().getIdQuestion()){
							answerRepository.delete(a);
						}
					});
					questionRepository.delete(q);
					}
				});
			}
			});
		trainingRepository.deleteById(idTraining);	
	}

	@Override
	public List<Training> getAllTrainings() {
		return trainingRepository.findAll();
	}

	@Override
	public Optional<Training> getTrainingById(int idTraining) {
		return trainingRepository.findById(idTraining);
	}

	@Override
	public List<Training> sortAllTrainingDESC( String attribut) {
		return (List<Training>) trainingRepository.findAll(Sort.by(Sort.Direction.DESC, attribut));
	}

	@Override
	public List<Training> sortAllTrainingASC(String attribut) {
		return (List<Training>) trainingRepository.findAll(Sort.by(Sort.Direction.ASC, attribut));
	}
	
	@Override
	public Page<Training> TrainingPagination(int offset, int pagesize ){
		   Page<Training> training= trainingRepository.findAll(PageRequest.of(offset, pagesize));
		   return training;
	}

	@Override
	public void addComment(int idTraining, String comment) {
		Training t = trainingRepository.findById(idTraining).orElse(null);
		t.setFeedback(comment);
		trainingRepository.save(t);		
	}
	
	@Override
	public Training updateComment(Training training) {
		Training t = trainingRepository.findById(training.getIdTraining()).orElse(null);
		t.setFeedback(training.getFeedback());
		return trainingRepository.save(t);
	}

	@Override
	public List<Training> getTrainingBySector(String nameSector) {
		return trainingRepository.FindTrainingBySector(nameSector);
	}
	

}
