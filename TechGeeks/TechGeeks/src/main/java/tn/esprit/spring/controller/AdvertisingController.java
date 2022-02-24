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
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.service.IAdvertisingService;
import tn.esprit.spring.entities.Advertising;

@RestController
@RequestMapping("/Advertising")
public class AdvertisingController {

	@Autowired 
	IAdvertisingService iAdvertisingService;
	
	@PostMapping("/AjoutPublicite")
	public String AjoutAdvertising(@RequestBody Advertising a) {
		iAdvertisingService.AjoutAdvertising((Advertising) a);
		return "Advertising ajouter ";
	}
	
	@GetMapping("/getAll")
	public List<Advertising> getAllAdvertising(){
		return iAdvertisingService.AdvertisingGetAll();
	}
	
	@GetMapping("/getById/{id}")
	public Advertising getIdAdvertising(@PathVariable int id){
		return iAdvertisingService.AdvertisingById(id);
	}
	
	@PutMapping("/AdvertisingUpdate/{id}")
	public void AdvertisingUpdate(@RequestBody Advertising a ,@PathVariable(value="id") int id) {
		Advertising add=iAdvertisingService.AdvertisingById(id);
		add.setNompublicite(a.getNompublicite());
		add.setDatedebut(a.getDatedebut());
		add.setDatefin(a.getDatefin());
		add.setNombreinitialevus(a.getNombreinitialevus());
		add.setNombrefinalvus(a.getNombrefinalvus());
		add.setTypepub(a.getTypepub());
		//iAdvertisingService.AjoutAdvertising(add);
		iAdvertisingService.AdvertisingModifier(add, id);
		System.out.print("valider ");
	}
	
	@DeleteMapping("/AdvertisingDelete/{id}")
	public void AdvertisingDelete(@PathVariable int id) {
		iAdvertisingService.SupprimerAdvertising(id);
	}
}
