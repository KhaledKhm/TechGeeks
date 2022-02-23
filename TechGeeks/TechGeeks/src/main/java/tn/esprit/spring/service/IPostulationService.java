package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entities.Offre;
import tn.esprit.spring.entities.Postulant;

public interface IPostulationService {
	
	List<Offre> retrieveAllOffresPostulant();
	Postulant addOffrePostulant(Postulant p);
	Offre updateOffrePostulant(Postulant postulant);
	Offre retrieveOffrePostulant(int idPostulant);
	void deleteOffrePostulant(int idPostulant);
}
