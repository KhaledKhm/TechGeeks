package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entities.Offre;
import tn.esprit.spring.entities.Postulant;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.repository.OffreRepository;
import tn.esprit.spring.repository.PostulationRepository;
import tn.esprit.spring.repository.UserRepository;


@Service
@Slf4j
public class PostulationServiceImpl implements IPostulationService {
	
	@Autowired
	PostulationRepository postulationRepository; 
	@Autowired
	UserRepository userRepository; 
	@Autowired
	OffreRepository offreRepository;
	
	@Override
	public List<Postulant> retrieveAllOffresPostulant() {
		List<Postulant> postulantList =  postulationRepository.findAll();
		for (Postulant postulant : postulantList){
			log.info(" Postulant : " +postulant);
		}
		return postulantList;
	}
	
	@Override
	public Postulant addOffrePostulant(Postulant p ,int idUser , int idOffre) {
		User user = userRepository.findById(idUser).get();
		Offre offre = offreRepository.findById(idOffre).get();
		p.setUsers(user);
		p.setOffres(offre);
		postulationRepository.save(p);
		return p;
	}
	@Override
	public Postulant updateOffrePostulant(Postulant postulant) {
		postulationRepository.save(postulant);
		return postulant;
	}
	@Override
	public Postulant retrieveOffrePostulant(int idPostulant) {
		return postulationRepository.findById(idPostulant).get();
	}
	@Override
	public void deleteOffrePostulant(int idPostulant) {
		postulationRepository.deleteById(idPostulant);
	}

	
	


}
