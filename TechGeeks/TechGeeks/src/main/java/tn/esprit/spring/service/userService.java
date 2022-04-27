package tn.esprit.spring.service;

import java.util.List;
import java.util.Set;

import javax.mail.MessagingException;

import tn.esprit.spring.entities.Certificate;
import tn.esprit.spring.entities.User;

public interface userService {
	Set<User> retrieveAllUsers();
	List<User> retrieveAllUsersKhaled();
	User addUser(User user) /*throws MessagingException*/ ;
	User findUserByUserName(String userName);
	User retrieveUserById(Integer iduser);
	void AffecterCertificat(int idUser, List<Certificate> certificates);
	boolean VerifUser(String user, String Vcode);
		
}
