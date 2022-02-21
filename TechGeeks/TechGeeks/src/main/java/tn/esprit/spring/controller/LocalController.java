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
import tn.esprit.spring.service.ILocalService;



@RestController
public class LocalController {

	@Autowired
	ILocalService localService;
	
	@PostMapping("/add-local")
	@ResponseBody
	Local addLocal(@RequestBody Local l){
		return localService.addLocal(l);
	}
	
	@GetMapping("/retrieve-allLocals")
	@ResponseBody
	List<Local> retrieveAllLocals(){
		
		return localService.retrieveAllLocals();
	}
	
	@PutMapping("modify-local")
	@ResponseBody
	Local updateLocal(@RequestBody Local l){
		
		return localService.updateLocal(l);
	}
	
	@DeleteMapping("delete-local/{id}")
	void deleteLocal(@PathVariable("id") int idLocal){
		localService.deleteLocal(idLocal);
		
	}

}
