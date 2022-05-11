package tn.esprit.spring.service;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

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
import tn.esprit.spring.entities.RoleName;
import tn.esprit.spring.repository.AnswerRepository;
import tn.esprit.spring.repository.CertificateRepository;
import tn.esprit.spring.repository.LocalRepository;
import tn.esprit.spring.repository.QuestionRepository;
import tn.esprit.spring.repository.QuizRepository;
import tn.esprit.spring.repository.RoleRepository;
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
	@Autowired
	RoleRepository roleRepository;

	@Override
	public void addTrainingByTrainer(Training training, int idUser, int idSector) {
		User u = userRepository.findById(idUser).orElse(null);
		Role role = roleRepository.findByRole(RoleName.ROLE_FORMER);
		Set<Role> roles = u.getRoles();
		for (Role r : roles) {
			if (r.getId() == role.getId()) {
				Sector s = sectorRepository.findById(idSector).orElse(null);
				training.setUser(u);
				training.setSector(s);
				training.setStatus(Status.Waiting);
				trainingRepository.save(training);
			}
		}
	}

	@Override
	public void addTrainingByAdmin(Training training, int idLocal, int idTarining) {
		training = trainingRepository.findById(idTarining).get();
		Local l = localRepository.findById(idLocal).orElse(null);
		training.setLocal(l);
		training.setStatus(Status.Accepted);
		trainingRepository.save(training);
	}

	@Override
	public Training updateTraining(Training training, int idTraining) {
		Training t = trainingRepository.findById(idTraining).orElse(null);
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
		if (training.getQuiz() != null) {
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
					quizRepository.delete(quiz);
				}
			});
			trainingRepository.delete(training);
		} else {
			trainingRepository.delete(training);
		}

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
	public List<Training> getTrainingByUser(int idUser) {
		return trainingRepository.FindTrainingByUser(idUser);
	}
	
	@Override
	public List<Training> getTrainingByUserStatus(int idUser) {
		List<Training> ts = trainingRepository.FindTrainingByUser(idUser);
		Status s = null ;
		for (Training t : ts){
			if (t.getStatus() == s.Waiting || t.getStatus() == s.Refused ){
				return ts;
			}
		}
		return null;
	}
	
	@Override
	public String addTrainingByTrainer2(Training training, int idUser, int idSector, Date dateStart, Date dateEnd) {
		List<Training> trainings = trainingRepository.findAll();
		User u = userRepository.findById(idUser).orElse(null);
		Role role = roleRepository.findByRole(RoleName.ROLE_FORMER);
		Sector s = sectorRepository.findById(idSector).orElse(null);
		System.out.println("1");
		System.out.println(dateEnd);
		System.out.println(dateStart);
		Set<Role> roles = u.getRoles();
		for (Role r : roles) {
			if (r.getId() == role.getId()) {
				System.out.println("2");
				int nb = 0;
				for (Training t : trainings) {
					System.out.println("3");
					System.out.println(t.getDateStart());
					System.out.println(t.getDateEnd());
					if (t.getUser().getId() == idUser) {
						System.out.println("4");
						if (dateStart.before(t.getDateStart()) && dateEnd.after(t.getDateStart())
								&& dateEnd.before(t.getDateEnd())) {
							System.out.println("5");
							nb = nb + 1;
							System.out.println("6");
						}
						if (dateStart.before(t.getDateStart()) && dateEnd.equals(t.getDateEnd())) {
							System.out.println("7");
							nb = nb + 1;
							System.out.println("8");
						}
						if (dateStart.before(t.getDateStart()) && dateEnd.after(t.getDateEnd())) {
							System.out.println("9");
							nb = nb + 1;
							System.out.println("10");
						}
						if (dateStart.equals(t.getDateStart()) && dateEnd.before(t.getDateEnd())
								&& dateEnd.before(t.getDateStart())) {
							System.out.println("11");
							nb = nb + 1;
							System.out.println("12");
						}
						if (dateStart.equals(t.getDateStart()) && dateEnd.equals(t.getDateEnd())) {
							System.out.println("13");
							nb = nb + 1;
							System.out.println("14");
						}
						if (dateStart.equals(t.getDateStart()) && dateEnd.after(t.getDateEnd())) {
							System.out.println("15");
							nb = nb + 1;
							System.out.println("16");
						}
						if (dateStart.after(t.getDateStart()) && dateStart.before(t.getDateEnd())
								&& dateEnd.equals(t.getDateEnd())) {
							System.out.println("17");
							nb = nb + 1;
							System.out.println("18");
						}
						if (dateStart.after(t.getDateStart()) && dateStart.before(t.getDateEnd())
								&& dateEnd.after(t.getDateEnd())) {
							System.out.println("19");
							nb = nb + 1;
							System.out.println("20");
						}
						if (dateStart.after(t.getDateStart()) && dateStart.before(t.getDateEnd())
								&& dateEnd.before(t.getDateEnd())) {
							System.out.println("21");
							nb = nb + 1;
							System.out.println("22");
						}
						System.out.println("25");
						if (1 < nb) {
							System.out.println("26");
							return "Former Can't have more than 2 courses in the same period";
						} else {
							training.setDateStart(dateStart);
							training.setDateEnd(dateEnd);
							training.setUser(u);
							training.setSector(s);
							trainingRepository.save(training);
							training.setStatus(Status.Waiting);
							System.out.println("27");
							return "done";
						}
					}
				}
			}
		}
		System.out.println("28");
		return "you are not a trainer";
	}

	@Override
	public String addTrainingByWomen( Certificate c ,int idTraining, int idUser) {
		User u = userRepository.findById(idUser).orElse(null);
		List<Certificate> certificates = certificateRepository.findAll();
		c = new Certificate();
		Role role = roleRepository.findByRole(RoleName.ROLE_WOMEN);
		Training training = trainingRepository.findById(idTraining).get();
		Set<Role> roles = u.getRoles();
		for (Role r : roles) {
			if (r.getId() == role.getId()) {
				for (Certificate certif : certificates)
					if (u.getId() != certif.getUser().getId() || certif == null) {
						if (training.getNbrParticipant() < training.getTotalParticipant()) {
							training.setNbrParticipant(training.getNbrParticipant() + 1);
							c.setUser(u);
							c.setTraining(training);
							certificateRepository.save(c);
							emailService.sendSimpleEmail(u.getEmail(), "Courses Her Way ",
									"Thank you for assisting 5 days before the date of the course and for paying and confirming your registration. ");
							return "done";
						} else {
							return "full place";
						}
					} else {
						return "Already participated ";
					}
			} else {
				return "you can not be a participant";
			}
		}
		return null;
	}

	@Override
	public Training updateStatus(Training training, int idtraining) {
		Training t = trainingRepository.findById(idtraining).get();
		t.setStatus(training.getStatus());
		return trainingRepository.save(t);
	}

	@Override
	public List<Local> getAllLocal(Date dateStart, Date dateEnd) {
		List<Local> locals = localRepository.findAll();
		System.out.println(dateStart.toString());
		for (Local l : locals) {
			if(dateEnd.before(l.getDateStart())||(dateStart.after(l.getDateEnd()))){
				System.out.println("1loca"+l.getDateStart());
				System.out.println("############### starter"+dateStart);
			}
			else{
				System.out.println("else");
			}
		
		}
		
		return null;
	}
	
}
