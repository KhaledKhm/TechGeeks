package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entities.Donation;


public interface IDonationService {
	List<Donation> retrieveAllDonations();
	List<Donation> retrieveMyDonations(int idUser);
	Donation addDonation(Donation d);
	Donation updateDonation(Donation d);
	Donation retrieveDonation(int id);
	void deleteDonation(int id);
	Donation addDonationAndAssignPot(Donation d, int idPot);
	void addAndAssignPotAndUser(Donation donation, int idPot, int idUser);
	public void numberDonationsByUser();
	public void donatedMoneyByPerson(int idUser);
}