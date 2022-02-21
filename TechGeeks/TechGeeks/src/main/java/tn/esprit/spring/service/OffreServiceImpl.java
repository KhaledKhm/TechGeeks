package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Offre;
import tn.esprit.spring.repository.OffreRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class OffreServiceImpl implements IOffreService  {
	
	@Autowired
	OffreRepository offreRepository; 
	@Override
	public List<Offre> retrieveAllOffres() {
		List<Offre> offreList =  offreRepository.findAll();
		for (Offre offre : offreList){
			log.info(" Offre : " +offre);
		}
		return offreList;
	}

	@Override
	public Offre addOffre(Offre o) {
		offreRepository.save(o);
		return o;
	}

	@Override
	public Offre updateOffre(Offre o) {
		offreRepository.save(o);
		return o;
	}

	@Override
	public Offre retrieveOffre(int id) {
		return offreRepository.findById(id).orElse(null);
	}

	@Override
	public void deleteOffre(int id) {
		offreRepository.deleteById(id);
	}

}
