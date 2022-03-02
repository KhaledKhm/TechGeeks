package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
/*import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;*/

import tn.esprit.spring.entities.Donation;
import tn.esprit.spring.service.IDonationService;

@RestController
public class DonationController {

	@Autowired
	IDonationService donationService;
	
	@PostMapping("/add-donation")
	@ResponseBody
	Donation addDonation(@RequestBody Donation d){
		return donationService.addDonation(d);
	}
	
	@PostMapping("/assign-pot-to-donation/{idPot}")
	@ResponseBody
	Donation assignDonationtoPot(@RequestBody Donation d, @PathVariable("idPot") int idPot){
		return donationService.addDonationAndAssignPot(d,idPot);
	}
	
	@PostMapping("/assign-user-pot-to-donation/{idPot}/{idUser}")
	@ResponseBody
	void addAndAssignPotAndUser(@RequestBody Donation d, @PathVariable("idPot") int idPot, @PathVariable("idUser") int idUser){
		donationService.addAndAssignPotAndUser(d,idPot,idUser);
	}
	
	
	
	@GetMapping("/retrieve-allDonations")
	@ResponseBody
	List<Donation> retrieveAllDonations(){
		
		return donationService.retrieveAllDonations();
	}
	
	@GetMapping("/get-Donation/{idDonation}")
	@ResponseBody
	Donation getDonationById(@PathVariable("idDonation") int idDonation){
		return donationService.retrieveDonation(idDonation);
		
	}
	
	@PutMapping("modify-donation")
	@ResponseBody
	Donation updateDonation(@RequestBody Donation d){
		
		return donationService.updateDonation(d);
	}
	
	@DeleteMapping("delete-donation/{id}")
	void deleteDonation(@PathVariable("id") int idDonation){
		donationService.deleteDonation(idDonation);
		
	}
	
	@GetMapping("/retrieve-numberDonationsByUser")
	@ResponseBody
	void numberDonationsByUser(){
		donationService.numberDonationsByUser();
	}
	/*
	  @Autowired
	    public JavaMailSender emailSender;

	    @ResponseBody
	    @RequestMapping("/sendSimpleEmail")
	    public String sendSimpleEmail() {

	        // Create a Simple MailMessage.
	        SimpleMailMessage message = new SimpleMailMessage();
	        
	        message.setTo("khmthe@gmail.com");
	        message.setSubject("Test Simple Email");
	        message.setText("Hello, Im testing Simple Email");

	        // Send Message!
	        this.emailSender.send(message);

	        return "Email Sent!";
	    }*/
}
