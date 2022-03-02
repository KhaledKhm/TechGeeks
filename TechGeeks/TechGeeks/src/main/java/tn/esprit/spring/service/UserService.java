package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.User;
import tn.esprit.spring.repository.UserRepository;
@Service
public class UserService implements IUserService {
@Autowired
private UserRepository userRepository;
BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

public User findUserByUserName(String userName) {
return userRepository.findByUsername(userName);
}
public User saveUser(User user) {
user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
user.setActive(true);
return userRepository.save(user); }

public User retrieveUser(Integer id) {
	// TODO Auto-generated method stub
	return userRepository.findById(id).orElse(null);
}


@Override
public void deleteUser(int id) {
	// TODO Auto-generated method stub
	userRepository.deleteById(id);
}

@Override
public User retrieveUser(int id) {
	// TODO Auto-generated method stub
	return userRepository.findById(id).orElse(null);
}

@Override
public void updateUser(User U) {
	// TODO Auto-generated method stub
	userRepository.save(U);

}
@Override
public List<User> retrieveAllUsers() {
	// TODO Auto-generated method stub
	return (List<User>)userRepository.findAll();
}
}
