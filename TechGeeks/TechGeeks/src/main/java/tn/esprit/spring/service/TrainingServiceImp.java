package tn.esprit.spring.service;

import java.util.Calendar;
import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.hibernate.type.descriptor.java.CalendarDateTypeDescriptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import tn.esprit.spring.entities.Sector;
import tn.esprit.spring.entities.Status;
import tn.esprit.spring.entities.Training;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.entities.Answer;
import tn.esprit.spring.entities.Certificate;
import tn.esprit.spring.entities.Local;
import tn.esprit.spring.entities.Question;
import tn.esprit.spring.entities.Quiz;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.repository.AnswerRepository;
import tn.esprit.spring.repository.CertificateRepository;
import tn.esprit.spring.repository.LocalRepository;
import tn.esprit.spring.repository.QuestionRepository;
import tn.esprit.spring.repository.QuizRepository;
import tn.esprit.spring.repository.TrainingRepository;
import tn.esprit.spring.repository.UserRepository;
import tn.esprit.spring.repository.SectorRepository;

@Service
public class TrainingServiceImp implements ITrainingService {
	@Autowired
	TrainingRepository trainingRepository;
	@Autowired
	LocalRepository localRepository;
	@Autowired
	SectorRepository sectorRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	QuizRepository quizRepository;
	@Autowired
	CertificateRepository certificateRepository;
	@Autowired
	QuestionRepository questionRepository;
	@Autowired
	AnswerRepository answerRepository;
	@Autowired
	EmailService emailService; 
	

	@Override
	public void addTrainingByTrainer(Training training, int idUser, int idSector) {
		/*User u = userRepository.findById(idUser).orElse(null);
		if (u.getRole().getRole() == "Trainer") {
			Sector s = sectorRepository.findById(idSector).orElse(null);
			training.setUser(u);
			training.setSector(s);
			training.setStatus(Status.Waiting);
			trainingRepository.save(training);
		}*/
	}

	@Override
	public void addTrainingByAdmin(Training training,int idLocal, int idTarining) {
		training = trainingRepository.findById(idTarining).get();
		Local l = localRepository.findById(idLocal).orElse(null);
		training.setLocal(l);
		training.setStatus(Status.Accepted);
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
		trainings.forEach(training -> {
			quizs.forEach(quiz -> {
				if (training.getIdTraining() == quiz.getTraining().getIdTraining()) {
					questions.forEach(q -> {
						if (quiz.getIdQuiz() == q.getQuiz().getIdQuiz()) {
							answers.forEach(a -> {
								if (q.getIdQuestion() == a.getQuestion().getIdQuestion()) {
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
		quizs.forEach(quiz -> {
			if (training.getIdTraining() == quiz.getTraining().getIdTraining()) {
				questions.forEach(q -> {
					if (quiz.getIdQuiz() == q.getQuiz().getIdQuiz()) {
						answers.forEach(a -> {
							if (q.getIdQuestion() == a.getQuestion().getIdQuestion()) {
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
	public List<Training> sortAllTrainingDESC(String attribut) {
		return (List<Training>) trainingRepository.findAll(Sort.by(Sort.Direction.DESC, attribut));
	}

	@Override
	public List<Training> sortAllTrainingASC(String attribut) {
		return (List<Training>) trainingRepository.findAll(Sort.by(Sort.Direction.ASC, attribut));
	}

	@Override
	public Page<Training> TrainingPagination(int offset, int pagesize) {
		Page<Training> training = trainingRepository.findAll(PageRequest.of(offset, pagesize));
		return training;
	}

	@Override
	public List<Training> getTrainingBySector(String nameSector) {
		return trainingRepository.FindTrainingBySector(nameSector);
	}

	@Override
	public String addTrainingByTrainer2(Training training, int idUser, int idSector, Date dateStart, Date dateEnd) {
		List<Training> trainings = trainingRepository.findAll();
		User u = userRepository.findById(idUser).orElse(null);
		Sector s = sectorRepository.findById(idSector).orElse(null);
		System.out.println("1");
		System.out.println(dateEnd);
		System.out.println(dateStart);

	/*	if (u.getRole().getRole() == "trainer") {
			System.out.println("2");
			int nb = 0;
			for (Training t : trainings) {
				System.out.println("3");
				System.out.println(t.getDateStart());
				System.out.println(t.getDateEnd());
				if (t.getUser().getIdUser() == idUser) {
					System.out.println("4");
					if (dateStart.before(t.getDateStart()) && dateEnd.after(t.getDateStart())
							&& dateEnd.before(t.getDateEnd())) {
						System.out.println("5");
						nb = nb + 1;
						System.out.println("6");
					} else if (dateStart.before(t.getDateStart()) && dateEnd.equals(t.getDateEnd())) {
						System.out.println("7");
						nb = nb + 1;
						System.out.println("8");
					} else if (dateStart.before(t.getDateStart()) && dateEnd.after(t.getDateEnd())) {
						System.out.println("9");
						nb = nb + 1;
						System.out.println("10");
					} else if (dateStart.equals(t.getDateStart()) && dateEnd.before(t.getDateEnd())
							&& dateEnd.before(t.getDateStart())) {
						System.out.println("11");
						nb = nb + 1;
						System.out.println("12");
					} else if (dateStart.equals(t.getDateStart()) && dateEnd.equals(t.getDateEnd())) {
						System.out.println("13");
						nb = nb + 1;
						System.out.println("14");
					} else if (dateStart.equals(t.getDateStart()) && dateEnd.after(t.getDateEnd())) {
						System.out.println("15");
						nb = nb + 1;
						System.out.println("16");
					} else if (dateStart.after(t.getDateStart()) && dateStart.before(t.getDateEnd())
							&& dateEnd.equals(t.getDateEnd())) {
						System.out.println("17");
						nb = nb + 1;
						System.out.println("18");
					} else if (dateStart.after(t.getDateStart()) && dateStart.before(t.getDateEnd())
							&& dateEnd.after(t.getDateEnd())) {
						System.out.println("19");
						nb = nb + 1;
						System.out.println("20");
					} else if (dateStart.after(t.getDateStart()) && dateStart.before(t.getDateEnd())
							&& dateEnd.before(t.getDateEnd())) {
						System.out.println("21");
						nb = nb + 1;
						System.out.println("22");
					}
					System.out.println("25");
					if (1 < nb) {
						System.out.println("26");
						return "Former Cant have more than 2 courses in the same period";
					} else {
						training.setDateStart(dateStart);
						training.setDateEnd(dateEnd);
						training.setUser(u);
						training.setSector(s);
						trainingRepository.save(training);
						System.out.println("27");
						return "done";
					}
				}
			}
		}*/
		System.out.println("28");
		return "you are not a trainer";
	}

	@Override
	public String addTrainingByWomen(Training training,int idTraining, int idUser) {
		User u = userRepository.findById(idUser).orElse(null);
		Certificate c = new Certificate() ;
		training = trainingRepository.findById(idTraining).get();
	/*	if (u.getRole().getRole() == "women" ) {
				if (training.getNbrParticipant() < training.getTotalParticipant()) {
					training.setNbrParticipant(training.getNbrParticipant() + 1);
					c.setUser(u);
					c.setTraining(training);
					certificateRepository.save(c);
					emailService.sendSimpleEmail(u.getEmail(), "Courses Her Way ", "Thank you for assisting 5 days before the date of the course and for paying and confirming your registration. ");
					return "done";
				}else{
					return "full place";
				}
			}else{
				return "you can not be a participant";
			}*/
		return null;
	}

	@Override
	public Training updateStatus(Training training,int idtraining) {
		Training t = trainingRepository.findById(idtraining).get();
		t.setStatus(training.getStatus());
		return trainingRepository.save(t);
	}

		
	

}
