package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import tn.esprit.spring.entities.Offre;
import tn.esprit.spring.entities.Postulant;
import tn.esprit.spring.repository.OffreRepository;
import tn.esprit.spring.repository.PostulationRepository;
import tn.esprit.spring.repository.UserRepository;

public class PostulationServiceImpl implements IPostulationService {
	@Autowired
	PostulationRepository postulationRepository; 
	@Autowired
	UserRepository userRepository; 
	@Autowired
	OffreRepository offreRepository;
	
	@Override
	public List<Offre> retrieveAllOffresPostulant() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Offre addOffrePostulant(int idOffre, int idPostulant) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Offre updateOffrePostulant(Postulant postulant) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Offre retrieveOffrePostulant(int idOffre) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void deleteOffrePostulant(int idPostulant) {
		// TODO Auto-generated method stub
		
	}
	


}
