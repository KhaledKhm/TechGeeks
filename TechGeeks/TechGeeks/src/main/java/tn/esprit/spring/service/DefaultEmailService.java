package tn.esprit.spring.service;

import java.io.FileNotFoundException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

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
