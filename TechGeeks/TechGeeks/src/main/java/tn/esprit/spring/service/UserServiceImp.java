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

}
