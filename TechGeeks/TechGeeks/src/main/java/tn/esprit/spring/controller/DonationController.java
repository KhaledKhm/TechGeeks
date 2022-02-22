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
