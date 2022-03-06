package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entities.Certificate;

public interface IUserService {
	
	public void AffecterCertificat(int idUser, List<Certificate> certificates);

}
