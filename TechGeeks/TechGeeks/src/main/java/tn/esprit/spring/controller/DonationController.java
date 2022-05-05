package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
/*import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;*/

import tn.esprit.spring.entities.Donation;
import tn.esprit.spring.service.IDonationService;

@CrossOrigin(origins = "*")
@RestController
public class DonationController {

	@Autowired
	IDonationService donationService;

	
	@PostMapping("/add-donation")
	Donation addDonation(@RequestBody Donation d){
		return donationService.addDonation(d);
	}
	
	@PostMapping("/assign-pot-to-donation/{idPot}")
	Donation assignDonationtoPot(@RequestBody Donation d, @PathVariable("idPot") int idPot){
		return donationService.addDonationAndAssignPot(d,idPot);
	}
	
	@PostMapping("/add-and-assign-user-pot-to-donation/{idPot}/{idUser}")
	void addAndAssignPotAndUser(@RequestBody Donation d, @PathVariable("idPot") int idPot, @PathVariable("idUser") int idUser){
		donationService.addAndAssignPotAndUser(d,idPot,idUser);
	}
	
	
	
	@GetMapping("/retrieve-allDonations")
	List<Donation> retrieveAllDonations(){
		
		return donationService.retrieveAllDonations();
	}
	
	@GetMapping("/retrieve-myDonations/{idUser}")
	List<Donation> retrieveMyDonations(@PathVariable("idUser")int idUser){
		
		return donationService.retrieveMyDonations(idUser);
	}
	
	
	@GetMapping("/get-Donation/{idDonation}")
	Donation getDonationById(@PathVariable("idDonation") int idDonation){
		return donationService.retrieveDonation(idDonation);
		
	}
	
	@PutMapping("modify-donation")
	Donation updateDonation(@RequestBody Donation d){
		
		return donationService.updateDonation(d);
	}
	
	@DeleteMapping("delete-donation/{id}")
	void deleteDonation(@PathVariable("id") int idDonation){
		donationService.deleteDonation(idDonation);
		
	}
	
	@GetMapping("/retrieve-numberDonationsByUser")
	void numberDonationsByUser(){
		donationService.numberDonationsByUser();
	}
	
	
	@GetMapping("/retrieve-donatedMoneyByPerson/{idUser}")
	void donatedMoneyByPerson(@PathVariable("idUser") int idUser){
		donationService.donatedMoneyByPerson(idUser);
	
	}
	
	
}
