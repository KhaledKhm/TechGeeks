package tn.esprit.spring.service;

import java.util.Set;

import tn.esprit.spring.entities.Donation;


public interface IDonationService {
	Set<Donation> retrieveAllDonations();
	Donation addDonation(Donation d);
	Donation updateDonation(Donation d);
	Donation retrieveDonation(int id);
	void deleteDonation(int id);
}
