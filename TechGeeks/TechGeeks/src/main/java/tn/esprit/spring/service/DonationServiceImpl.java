package tn.esprit.spring.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entities.Donation;
import tn.esprit.spring.entities.Pot;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.repository.DonationRepository;
import tn.esprit.spring.repository.PotRepository;
import tn.esprit.spring.repository.UserRepository;

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
	@Autowired
	UserRepository userRepository;


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
	@Transactional
	public void addAndAssignPotAndUser(Donation donation, int idPot, int idUser) {
		Pot p = potRepository.findById(idPot).orElse(null);	
		User u = userRepository.findById(idUser).orElse(null);	
		
		p.setSum(p.getSum()+donation.getSum());
		donation.setPot(p);
		donation.setDonationUser(u);
				
		donationRepository.save(donation);
		
	}

	@Override
	@Scheduled(cron = "* * * 1 * *")
	public void numberDonationsByUser() {
	//	for(Donation donation:retrieveAllDonations()){	
			for(User user:userRepository.findAll()){
				log.info("--- User: "
						+ " First Name: "
						+ user.getFirstName()
						+ " Last Name: " 
						+ user.getLastName()
						+ " has made a total of "
						+ donationRepository.nbreByUser(user.getId())
						+ " donations ---" );
			}
	//		return;
	//	}
		
	}
	
	
	@Override
	@Transactional
	public Donation addDonationAndAssignPot(Donation d, int idPot) {
		Pot p=potRepository.findById(idPot).orElse(null);
		d.setPot(p);
		donationRepository.save(d);
		return d;
		
	}

	@Override
	public void donatedMoneyByPerson(int idUser) {
		float sum=donationRepository.sumDonations(idUser);
//		List<User> users = userService.retrieveAllUsers();
	/*	List<Donation> donations = donationRepository.findByUserDonations(idUser);
		for (int i = 0; i<donations.size();i++){
			sum+=donations.get(i).getSum();	*/
		User user= userRepository.findById(idUser).orElse(null);
			log.info(user.getId()+"-"+user.getUsername()+" "+user.getFirstName()+" "+user.getLastName()+" has donated a sum of "+sum );
	
		//System.out.println("test");
		//System.out.println(sum+=donationRepository.sumDonations(idUser));
	
	}

	

}
