package tn.esprit.spring.controller;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entities.Pot;
import tn.esprit.spring.service.EventServiceImpl;
import tn.esprit.spring.service.IPotService;

@RestController
@Slf4j
public class PotController {

	@Autowired
	IPotService potService;
	
	@PostMapping("/add-pot")
	Pot addPot(@RequestBody Pot p){
		return potService.addPot(p);
	}
	
	@GetMapping("/retrieve-allPots")
	List<Pot> retrieveAllPots(){	
		return potService.retrieveAllPots();
	}
	
	@GetMapping("/get-Pot/{idPot}")
	Pot getPotById(@PathVariable("idPot") int idPot){
		return potService.retrievePot(idPot);
	}
	
	@PutMapping("/modify-pot")
	Pot updatePot(@RequestBody Pot p){	
		return potService.updatePot(p);
	}
	
	@DeleteMapping("/delete-pot/{id}")
	void deletePot(@PathVariable("id") int idPot){
		potService.deletePot(idPot);
		
	}
	
	@PutMapping("take-money-pot/{idPot}/{money}")
	void takeMoneyFromPot(@PathVariable("idPot") int idPot, @PathVariable("money") float money){	

		potService.takeMoney(idPot,money);
	}
	

}
