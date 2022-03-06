package tn.esprit.spring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Certificate;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.service.ICertificateService;

@RestController
public class CertificateController {
	@Autowired
	ICertificateService certificateService;
	
	/*@PostMapping("/AffecterUser/{idCertificate}/{users}")
	@ResponseBody
	public void AffecterUser(@RequestBody Certificate certificate,@PathVariable("idCertificate") int idCertificate,@PathVariable("users") List<User> user) {
		certificateService.AffecterUser(idCertificate,user);
	}*/
	
	@PostMapping("/addCertificate")
	@ResponseBody
	public void addCertificate(@RequestBody Certificate certificate) {
		certificateService.addCertificate(certificate);
	}
	
	@PutMapping("/updateCertificate")
	@ResponseBody
	public void updateCertificate(@RequestBody Certificate certificate) {
		certificateService.updateCertificate(certificate);
	}
	
	@DeleteMapping("/deleteAllCertificates")
	@ResponseBody
	public void deleteAllCertificates() {
		certificateService.deleteAllCertificates();
	}
	
	@DeleteMapping("/deleteCertificateById/{idCertificate}")
	@ResponseBody
	public void deleteCertificateById(@PathVariable("idCertificate") int idCertificate) {
		certificateService.deleteCertificateById(idCertificate);
	}
	
	@GetMapping("/getAllCertificates")
	@ResponseBody
	public List <Certificate> getAllCertificates() {
		return certificateService.getAllCertificates();
	}
	
	
	@GetMapping("/getCertificateById/{idCertificate}")
	@ResponseBody
	public Optional <Certificate> getCertificateById(@PathVariable("idCertificate") int idCertificate) {
		return certificateService.getCertificateById(idCertificate);
	}

}
