package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entities.OffreCategory;

public interface IOffreCategoryService {
	List<OffreCategory> retrieveAllOffresCategory();
	OffreCategory addOffreCategory(OffreCategory o);
	OffreCategory updateOffreCategory(OffreCategory o);
	OffreCategory retrieveOffreCategory(int id);
	void deleteOffreCategory(int id);
}
