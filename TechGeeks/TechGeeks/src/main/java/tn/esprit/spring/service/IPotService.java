package tn.esprit.spring.service;

import java.util.Set;

import tn.esprit.spring.entities.Pot;

public interface IPotService {
	Set<Pot> retrieveAllPots();
	Pot addPot(Pot p);
	Pot updatePot(Pot p);
	Pot retrievePot(int id);
	void deletePot(int id);
}
