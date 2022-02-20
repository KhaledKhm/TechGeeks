package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entities.Donation;
import tn.esprit.spring.repository.DonationRepository;

@Service
@Slf4j
public class DonationServiceImpl implements IDonationService{

	public DonationServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	DonationRepository donationRepository;

	@Override
	public List<Donation> retrieveAllDonations() {
		List<Donation> donationList = donationRepository.findAll();
		for (Donation donation : donationList){
			log.info(" Donation: " +donation);
		}
		return donationList;
		
	}

	@Override
	public Donation addDonation(Donation d) {
		donationRepository.save(d);
		return d;
	}

	@Override
	public Donation updateDonation(Donation d) {
		donationRepository.save(d);
		return d;
	}

	@Override
	public Donation retrieveDonation(int id) {
		return donationRepository.findById(id).orElse(null);
	}

	@Override
	public void deleteDonation(int id) {
		donationRepository.deleteById(id);
		
	}

}
