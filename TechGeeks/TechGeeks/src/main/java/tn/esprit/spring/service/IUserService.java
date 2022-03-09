package tn.esprit.spring.service;
import java.util.List;

import tn.esprit.spring.entities.*;
public interface IUserService {
	
    
    public void AffecterCertificat(int idUser, List<Certificate> certificates);
}
