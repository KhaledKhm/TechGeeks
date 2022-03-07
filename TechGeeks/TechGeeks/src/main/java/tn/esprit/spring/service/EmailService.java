package tn.esprit.spring.service;

public interface EmailService {

	  void sendSimpleEmail(String toAddress, String subject, String message);
}
