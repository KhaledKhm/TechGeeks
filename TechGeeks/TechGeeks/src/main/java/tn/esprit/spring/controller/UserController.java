package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Certificate;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.service.IUserService;

@RestController
public class UserController {
	@Autowired
	IUserService userservice;
	
	@PostMapping("/AffecterCertificate/{idUser}/{certficates}")
	@ResponseBody
	public void AffecterCertificate(@RequestBody User user,@PathVariable("idUser") int idUser,@PathVariable("certficates") List<Certificate> certficates) {
		userservice.AffecterCertificat(idUser,certficates);
	}
}
