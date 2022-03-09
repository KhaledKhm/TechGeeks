package tn.esprit.spring.service;

import java.util.List;


import tn.esprit.spring.entities.Postulant;



public interface IPostulationService {
	
	List<Postulant> retrieveAllOffresPostulant();
	Postulant addOffrePostulant(Postulant p,int user , int offre);
	Postulant updateOffrePostulant(Postulant postulant);
	Postulant retrieveOffrePostulant(int idPostulant);
	void deleteOffrePostulant(int idPostulant);
}
