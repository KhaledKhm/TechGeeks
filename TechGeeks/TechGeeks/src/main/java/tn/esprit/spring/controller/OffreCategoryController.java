package tn.esprit.spring.controller;

import java.util.List;

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
public class OffreCategoryController {

	@Autowired
	IOffreCategoryService offreCategoryService;

	public OffreCategoryController() {
		// TODO Auto-generated constructor stub
	}
	
	@PostMapping("/add-offreCategory")
	@ResponseBody
	OffreCategory addOffre(@RequestBody OffreCategory cat  ){
		return offreCategoryService.addOffreCategory(cat);
	}
	
	@GetMapping("/retrieve-allOffresCategory")
	@ResponseBody
	List<OffreCategory> retrieveAllOffres(){
		return offreCategoryService.retrieveAllOffresCategory();
	}
	
	@GetMapping("/get-offreCategory/{idCategory}")
	@ResponseBody
	OffreCategory getOffreById(@PathVariable("idCategory") int idCategory){
		return offreCategoryService.retrieveOffreCategory(idCategory);
		
	}
	
	@PutMapping("/modify-offreCategory")
	@ResponseBody
	OffreCategory updateOffreCategory(@RequestBody OffreCategory cat){
		return offreCategoryService.updateOffreCategory(cat);
	}
	
	@DeleteMapping("/delete-offreCategory/{id}")
	void deleteOffreCategory(@PathVariable("id") int idCatOffre){
		offreCategoryService.deleteOffreCategory(idCatOffre);
	}

}