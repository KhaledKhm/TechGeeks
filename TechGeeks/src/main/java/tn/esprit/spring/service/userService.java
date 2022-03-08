package tn.esprit.spring.service;

import java.util.Set;

import tn.esprit.spring.entities.User;

public interface userService {
	Set<User> retrieveAllUsers();
	User addUser(User user) ;
	User findUserByUserName(String userName);
}
