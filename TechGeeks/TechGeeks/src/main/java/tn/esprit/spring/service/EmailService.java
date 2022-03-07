package tn.esprit.spring.service;

import java.io.FileNotFoundException;

import javax.mail.MessagingException;

public interface EmailService {
	public void sendSimpleEmail(String toAddress, String subject, String message);

}
