package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entities.Donation;


public interface IDonationService {
	List<Donation> retrieveAllDonations();
	Donation addDonation(Donation d);
	Donation updateDonation(Donation d);
	Donation retrieveDonation(int id);
	void deleteDonation(int id);
	Donation assignDonation(Donation d, int idPot);
	void addAndAssignPotAndUser(Donation donation, int idPot, int idUser);
}
