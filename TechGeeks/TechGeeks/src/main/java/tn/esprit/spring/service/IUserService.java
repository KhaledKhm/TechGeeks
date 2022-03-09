package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entities.Certificate;

import tn.esprit.spring.entities.User;

public interface IUserService {
	List<User> retrieveAllUsers();

	public User saveUser(User user);
//	public void AffecterCertificat(int idUser, List<Certificate> certificates);
    void deleteUser(int id);
    User retrieveUser(int id);
    void updateUser(User U);
    User findUserByUserName(String userName);
  
}

