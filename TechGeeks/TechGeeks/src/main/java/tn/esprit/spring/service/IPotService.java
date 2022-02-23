package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entities.Pot;

public interface IPotService {
	List<Pot> retrieveAllPots();
	Pot addPot(Pot p);
	Pot updatePot(Pot p);
	Pot retrievePot(int id);
	void deletePot(int id);
	void monthlyPotSum();
	void takeMoney(int idPot, float money);
}
