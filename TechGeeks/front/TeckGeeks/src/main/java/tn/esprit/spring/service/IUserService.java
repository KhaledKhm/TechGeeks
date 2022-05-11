package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entities.Certificate;

import tn.esprit.spring.entities.User;

public interface IUserService {
	public void AffecterCertificat(int idUser, List<Certificate> certificates);
   
  
}

