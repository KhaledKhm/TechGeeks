package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Certificate;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.repository.CertificateRepository;
import tn.esprit.spring.repository.UserRepository;

@Service
public class UserServiceImp implements IUserService {
	
	@Autowired
	UserRepository userRepository;
	@Autowired
	CertificateRepository certificateRepository;
	
	@Override
	public void AffecterCertificat(int idUser, List<Certificate> certificates) {
		certificateRepository.saveAll(certificates);
		User u =userRepository.findById(idUser).orElse(null);
		for (Certificate certificate : certificates) {
			certificate.setUser(u);
		}
		certificateRepository.saveAll(certificates);
	}

	@Override
	public List<User> retrieveAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUser(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User retrieveUser(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateUser(User U) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User findUserByUserName(String userName) {
		// TODO Auto-generated method stub
		return null;
	}
}
