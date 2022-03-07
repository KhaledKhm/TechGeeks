package tn.esprit.spring.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
@Service
public class DefaultEmailService implements EmailService {

	 @Autowired
	 public JavaMailSender emailSender;

	 @Override
	 public void sendSimpleEmail(String toAddress, String subject, String message) {

	  SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
	  simpleMailMessage.setTo(toAddress);
	  simpleMailMessage.setSubject(subject);
	  simpleMailMessage.setText(message);
	  emailSender.send(simpleMailMessage);
	 }

	

}
