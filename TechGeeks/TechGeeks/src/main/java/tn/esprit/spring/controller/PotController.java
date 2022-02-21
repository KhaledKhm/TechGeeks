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

import tn.esprit.spring.entities.Local;
import tn.esprit.spring.entities.Pot;
import tn.esprit.spring.service.IPotService;

@RestController
public class PotController {

	@Autowired
	IPotService potService;
	
	@PostMapping("/add-pot")
	@ResponseBody
	Pot addPot(@RequestBody Pot p){
		return potService.addPot(p);
	}
	
	@GetMapping("/retrieve-allPots")
	@ResponseBody
	List<Pot> retrieveAllPots(){
		
		return potService.retrieveAllPots();
	}
	
	@GetMapping("/get-Pot/{idPot}")
	@ResponseBody
	Pot getPotById(@PathVariable("idPot") int idPot){
		return potService.retrievePot(idPot);
		
	}
	
	@PutMapping("modify-pot")
	@ResponseBody
	Pot updatePot(@RequestBody Pot p){
		
		return potService.updatePot(p);
	}
	
	@DeleteMapping("delete-pot/{id}")
	void deletePot(@PathVariable("id") int idPot){
		potService.deletePot(idPot);
		
	}

}
