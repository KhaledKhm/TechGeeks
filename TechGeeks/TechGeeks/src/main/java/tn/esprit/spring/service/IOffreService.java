package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entities.Offre;

public interface IOffreService {
	List<Offre> retrieveAllOffres();
	Offre addOffre(Offre o, int id);
	Offre updateOffre(Offre o);
	Offre retrieveOffre(int id);
	void deleteOffre(int id);
}
