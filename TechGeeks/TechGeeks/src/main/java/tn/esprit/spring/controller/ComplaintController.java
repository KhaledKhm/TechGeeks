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

import tn.esprit.spring.entities.Type;
import tn.esprit.spring.entities.Complaint;
import tn.esprit.spring.service.IComplaintSerivce;

@RestController
public class ComplaintController {
	@Autowired
	IComplaintSerivce cs;
	@PostMapping("/add-Complaint")
	@ResponseBody
	Complaint addComplaint(@RequestBody Complaint c){//@request taayet lel les attributs
	return cs.addComplaint(c);
	}

	@GetMapping("/retrieve-Complaint")
	@ResponseBody
	public Optional<Complaint> retrieveComplaint(Integer id) {
	return cs.retrieveComplaint(id);
	}
	@GetMapping("/find-Complaint")
	@ResponseBody
	public Optional<Complaint> findComplaintbytype(Type type) {
	return cs.findComplaintBytype(type);
	}
	
	@PutMapping("/modify-Complaint")
	@ResponseBody
	Complaint updateComplaint(@RequestBody Complaint c){
		return cs.updateComplaint(c);
	}
	
	@DeleteMapping("/delete-Complaint/{id}")
	void deleteComplaint(@PathVariable(name="id")Integer id){
		cs.deleteComplaint(id);
	}
	@PostMapping("/assign-Complaint/{idcomplaint}/{iduser}")
	@ResponseBody
	public void assignComplaintToUser(@PathVariable("idcomplaint") int  idComplaint ,@PathVariable("iduser")int id){
		cs.assignComplaintToUser(idComplaint, id);
	}
}
