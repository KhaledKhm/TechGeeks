package tn.esprit.spring.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entities.Donation;
import tn.esprit.spring.entities.Pot;
import tn.esprit.spring.repository.DonationRepository;
import tn.esprit.spring.repository.PotRepository;

@Service
@Slf4j
public class DonationServiceImpl implements IDonationService{

	public DonationServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	DonationRepository donationRepository;
	@Autowired
	PotRepository potRepository;
//	@Autowired
//	UserRepository userRepository;

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

	@Override
	public Donation assignDonation(Donation d, int idPot) {
		Pot p = potRepository.findById(idPot).orElse(null);	
		d.setPot(p);
		
		donationRepository.save(d);
		return d;
	}

	@Override
	@Transactional
	public void addAndAssignPotAndUser(Donation donation, int idPot, int idUser) {
		Pot p = potRepository.findById(idPot).orElse(null);	
//		User u = userRepository.findById(idUser).orElse(null);	
		
		donation.setPot(p);
//		donation.setUser(u);
				
		donationRepository.save(donation);
		
	}

	@Override
	@Scheduled(cron = "* * * 1 * *")
	public void numberDonationsByUser() {
		for(Donation donation:retrieveAllDonations()){		
		log.info("--- User: "
				+ donation.getUser().getFirstName()
				+ " " 
				+ donation.getUser().getLastName()
				+ "has made a total of "
				+ donationRepository.nbreByUser(donation.getUser().getLogin())
				+ " donations ---" );
		}
		
	}
	
	@Override
	@Transactional
	public Donation addDonationAndAssignPot(Donation d, int idPot) {
		Pot p=potRepository.findById(idPot).orElse(null);
		d.setPot(p);
		donationRepository.save(d);
		return d;
		
	}

	

}
