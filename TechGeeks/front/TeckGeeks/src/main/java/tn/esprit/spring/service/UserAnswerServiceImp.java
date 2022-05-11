package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Answer;
import tn.esprit.spring.entities.Certificate;
import tn.esprit.spring.entities.Question;
import tn.esprit.spring.entities.Quiz;
import tn.esprit.spring.entities.UserAnswer;
import tn.esprit.spring.repository.AnswerRepository;
import tn.esprit.spring.repository.CertificateRepository;
import tn.esprit.spring.repository.QuestionRepository;
import tn.esprit.spring.repository.QuizRepository;
import tn.esprit.spring.repository.UserAnswerRepository;

@Service
public class UserAnswerServiceImp implements IUserAnswerService {

	@Autowired
	UserAnswerRepository userAnswerRepository;
	@Autowired
	QuestionRepository questionRepository;
	@Autowired
	AnswerRepository answerRepository;
	@Autowired
	QuizRepository quizRepository;
	@Autowired
	CertificateRepository certificateRepository;
	
	@Override
	public void distributeMark(UserAnswer Uanswer, int idQuestion, int idAnswer, int idCertificate) {
		Question q = questionRepository.findById(idQuestion).get();
		Certificate c = certificateRepository.findById(idCertificate).orElse(null);
		Answer a = answerRepository.getAnswerByQuestionAndStatus(idQuestion, true);
		if (c.getTraining().getIdTraining() ==q.getQuiz().getTraining().getIdTraining()){
		Uanswer.setCertificate(c);
		Uanswer.setQuestion(q);
		Uanswer.setAnswer(a);
		Uanswer.setUserAnswer(idAnswer);
		Uanswer.setIdQuiz(q.getQuiz().getIdQuiz());
		if( Uanswer.getUserAnswer() == Uanswer.getAnswer().getIdAnswer()){
			Uanswer.setMark(q.getMark());
		}else{
			Uanswer.setMark(0.0);
		}
		userAnswerRepository.save(Uanswer);	
		}
	}


	@Override
	public void QuizMark(int idQuiz, int idCertificate ) {
		List <UserAnswer> uas = userAnswerRepository.getUserAnswerByQuizAndCertificate(idQuiz, idCertificate);
		Quiz q = quizRepository.getById(idQuiz);
			double note = 0;
			Certificate c = certificateRepository.getById(idCertificate);
			for(UserAnswer ua : uas){
					note = note + ua.getMark();
					c.setMark(note);
			}
			if (c.getMark() < (q.getMark() * 0.5))
			{
				c.setComment("Training not validated!! Thank you for your presence, we invite you to participate in other trainings");
				c.setTitle("Presence certificate in "+ c.getTraining().getSector().getName()+ " training");
				c.setDescription("HER WAY has the honor ti give a certificate of success in "
				+c.getTraining().getSector().getName()+ " training to Mr/MM " 
						+c.getUser().getFirstName()+" "+c.getUser().getLastName()+ 
						" with the participation code "+c.getIdCertificate()+ 
						" and which was guided by the trainer "+c.getTraining().getUser().getFirstName()+
						" "+c.getTraining().getUser().getLastName());
			}
			else if ((q.getMark() * 0.5) == c.getMark() && c.getMark() < (q.getMark() * 0.6))
			{
				c.setComment("Training validated with quite well");
				c.setTitle("Certificate in "+ c.getTraining().getSector().getName());
				c.setDescription("HER WAY has the honor ti give a certificate of success in "
						+c.getTraining().getSector().getName()+ " training to Mr/MM " 
								+c.getUser().getFirstName()+" "+c.getUser().getLastName()+ 
								" with the participation code "+c.getIdCertificate()+ 
								" and which was guided by the trainer "+c.getTraining().getUser().getFirstName()+
								" "+c.getTraining().getUser().getLastName());
			}
			else if ((q.getMark() * 0.6) == c.getMark() && c.getMark() < (q.getMark() * 0.7))
			{
				c.setComment("Training validated with well");
				c.setTitle("Certificate in "+ c.getTraining().getSector().getName());
				c.setDescription("HER WAY has the honor ti give a certificate of success in "
						+c.getTraining().getSector().getName()+ " training to Mr/MM " 
								+c.getUser().getFirstName()+" "+c.getUser().getLastName()+ 
								" with the participation code "+c.getIdCertificate()+ 
								" and which was guided by the trainer "+c.getTraining().getUser().getFirstName()+
								" "+c.getTraining().getUser().getLastName());
			}
			else if ((q.getMark() * 0.7) == c.getMark() && c.getMark() < (q.getMark() * 0.8))
			{
				c.setComment("Training validated with very well");
				c.setTitle("Certificate in "+ c.getTraining().getSector().getName());
				c.setDescription("HER WAY has the honor ti give a certificate of success in "
						+c.getTraining().getSector().getName()+ " training to Mr/MM " 
								+c.getUser().getFirstName()+" "+c.getUser().getLastName()+ 
								" with the participation code "+c.getIdCertificate()+ 
								" and which was guided by the trainer "+c.getTraining().getUser().getFirstName()+
								" "+c.getTraining().getUser().getLastName());
			}
			else
			{
				c.setComment("Training validated with excelent");
				c.setTitle("Certificate in "+ c.getTraining().getSector().getName());
				c.setDescription("HER WAY has the honor ti give a certificate of success in "
						+c.getTraining().getSector().getName()+ " training to Mr/MM " 
								+c.getUser().getFirstName()+" "+c.getUser().getLastName()+ 
								" with the participation code "+c.getIdCertificate()+ 
								" and which was guided by the trainer "+c.getTraining().getUser().getFirstName()+
								" "+c.getTraining().getUser().getLastName());
			}
			certificateRepository.save(c);
	}
}
