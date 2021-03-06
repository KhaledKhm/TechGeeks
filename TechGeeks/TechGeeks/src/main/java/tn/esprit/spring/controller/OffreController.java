package tn.esprit.spring.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Offre;
import tn.esprit.spring.entities.OffreCategory;
import tn.esprit.spring.repository.OffreRepository;
import tn.esprit.spring.repository.UserRepository;
import tn.esprit.spring.service.IOffreCategoryService;
import tn.esprit.spring.service.IOffreService;
import tn.esprit.spring.service.OffreServiceImpl;


@RestController
public class OffreController {

	@Autowired
	IOffreService offreService;
	@Autowired
	IOffreCategoryService offreCategoryService;
	@Autowired
	UserRepository userRepository;
	
	public OffreController() {
		// TODO Auto-generated constructor stub
	}
	
	@PostMapping("/add-offre/{id_user}/{idOffreCat}")
	@ResponseBody
	Offre addOffre(@RequestBody Offre o , @PathVariable("id_user")Integer id,@PathVariable("idOffreCat")Integer idOffreCat ){
		o.setOffreCategory(offreCategoryService.retrieveOffreCategory(idOffreCat));
		return offreService.addOffre(o, id);
	}
	
	@GetMapping("/retrieve-allOffres")
	@ResponseBody
	List<Offre> retrieveAllOffres(){
		
		return offreService.retrieveAllOffres();
	}
	
	@GetMapping("/get-offre/{idOffre}")
	@ResponseBody
	Offre getOffreById(@PathVariable("idOffre") int idOffre){
		return offreService.retrieveOffre(idOffre);
		
	}
	
	@PutMapping("/modify-offre")
	@ResponseBody
	Offre updateOffre(@RequestBody Offre o){
		
		return offreService.updateOffre(o);
	}
	
	@DeleteMapping("/delete-offre/{id}")
	void deleteEvent(@PathVariable("id") int idOffre){
		offreService.deleteOffre(idOffre);
		
	}

}