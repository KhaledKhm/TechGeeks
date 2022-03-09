package tn.esprit.spring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
	@PostMapping("/addassign-complaint/{userid}")
	void ajouterEtaffectercomplaints(@RequestBody Complaint c, @PathVariable("userid")int userid){
	 cs.ajouterEtaffectercomplaints(c, userid);
	}

	@GetMapping("/retrieve-Complaint")
	public Optional<Complaint> retrieveComplaint(Integer id) {
	return cs.retrieveComplaint(id);
	}
	@GetMapping("/retrieve-Complaints")
	public List<Complaint> retrieveAllComplaints() {
		return cs.retrieveAllComplaints();
	}
	@GetMapping("/find-Complaint")
	public List<Complaint> findComplaintbytype(Type type) {
	return cs.findComplaintBytype(type);
	}
	
	@PutMapping("/modify-Complaint")
	Complaint updateComplaint(@RequestBody Complaint c){
		return cs.updateComplaint(c);
	}
	
	@DeleteMapping("/delete-Complaint/{id}")
	void deleteComplaint(@PathVariable(name="id")Integer id){
		cs.deleteComplaint(id);
	}
	@GetMapping("/find-Complaintwithpagination/{offset}/{pagesize}")
	@ResponseBody
	public Page<Complaint> findComplaintwithPagination(@PathVariable ("offset")int offset,@PathVariable("pagesize")int pagesize ){
		return cs.findComplaintwithPagination(offset, pagesize);
		
	}
	@PostMapping("/assign-Complaint/{idcomplaint}/{iduser}")
	@ResponseBody
	public void assignComplaintToUser(@PathVariable("idcomplaint") int  idComplaint ,@PathVariable("iduser")int id){
		cs.assignComplaintToUser(idComplaint, id);
	}
	@GetMapping("/get-ComplaintByuser/{iduser}")
	@ResponseBody
	int  nbrcompparUser(@PathVariable("iduser") int iduser) {
	return cs.nbreCompParUser(iduser);
	}
	@PutMapping("/assign-Complaint/{idcomplaint}/{iduser}")
	@ResponseBody
	public void traiterComplaint(@PathVariable("idcomplaint") int  idComplaint ,@PathVariable("iduser")int iduser){
		cs.traiterComplaint(idComplaint, iduser);
	}
	
}
