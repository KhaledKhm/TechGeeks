package tn.esprit.spring.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import tn.esprit.spring.entities.Certificate;
import tn.esprit.spring.entities.Punishment;

import tn.esprit.spring.repository.CertificateRepository;
import tn.esprit.spring.repository.UserRepository;

@Service
public class CertificateServiceImp implements ICertificateService{
	
	@Autowired
	UserRepository userRepository ;
	@Autowired
	CertificateRepository certificateRepository ;
	
	@Override
	public void addCertificate (Certificate certificat){
		certificateRepository.save(certificat);
	}
		
	@Override
	public Certificate updateCertificate(Certificate certificate) {
		Certificate c = certificateRepository.findById(certificate.getIdCertificate()).orElse(null);
		c.setDescription(certificate.getDescription());
		c.setTitle(certificate.getTitle());
		c.setPunishment(certificate.getPunishment());
		return certificateRepository.save(c);
	}

	@Override
	public void deleteAllCertificates() {
		certificateRepository.deleteAll();
	}

	@Override
	public void deleteCertificateById(int idCertificate) {
		certificateRepository.deleteById(idCertificate);
		
	}

	@Override
	public List<Certificate> getAllCertificates() {
		return certificateRepository.findAll();
	}

	@Override
	public Certificate getCertificateById(int idCertificate) {
		return certificateRepository.findById(idCertificate).orElse(null);
	}

	@Override
	public Certificate updatePunishment(Certificate certificate, int idCertificate) {
		Certificate c = certificateRepository.findById(idCertificate).get();
		c.setPunishment(certificate.getPunishment());
		Punishment p = Punishment.Fire;
		if (c.getPunishment() == p){
			certificateRepository.delete(c);
		}
		return certificateRepository.save(c);
	}

}



