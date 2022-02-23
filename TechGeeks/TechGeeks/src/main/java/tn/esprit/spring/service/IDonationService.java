package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entities.Donation;
import tn.esprit.spring.entities.Pot;


public interface IDonationService {
	List<Donation> retrieveAllDonations();
	Donation addDonation(Donation d);
	Donation addDonationAndAssignPot(Donation d, int idPot);
	Donation updateDonation(Donation d);
	Donation retrieveDonation(int id);
	void deleteDonation(int id);
	Donation assignDonation(Donation d, int idPot);
	void addAndAssignPotAndUser(Donation donation, int idPot, int idUser);
	public void numberDonationsByUser();
}
