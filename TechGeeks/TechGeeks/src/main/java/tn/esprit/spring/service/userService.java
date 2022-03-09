package tn.esprit.spring.service;

import java.util.List;
import java.util.Set;

import tn.esprit.spring.entities.Certificate;
import tn.esprit.spring.entities.User;

public interface userService {
	Set<User> retrieveAllUsers();
	User addUser(User user) ;
	User findUserByUserName(String userName);
	User retrieveUserById(Integer iduser);
	void AffecterCertificat(int idUser, List<Certificate> certificates);
		
}
