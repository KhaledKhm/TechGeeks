package tn.esprit.spring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Type;
import tn.esprit.spring.entities.Complaint;
import tn.esprit.spring.service.IComplaintSerivce;
@CrossOrigin(origins="*")
@RestController
public class ComplaintController {
	@Autowired
	IComplaintSerivce cs;
	@PostMapping("/add-Complaint")
	@ResponseBody
	Complaint addComplaint(@RequestBody Complaint c){//@request taayet lel les attributs
	return cs.addComplaint(c);
	}
	@PostMapping("/addassign-complaint/{iduser}/{username}")
	@ResponseBody
	void ajouterEtaffectercomplaints(@RequestBody Complaint c,@PathVariable("iduser")int iduser, @PathVariable("username")String username){
	 cs.ajouterEtaffectercomplaints(c, iduser, username);
	}

	@GetMapping("/retrieve-Complaint/{id}")
	@ResponseBody
	public Optional<Complaint> retrieveComplaint(@PathVariable(name="id")Integer id) {
	return cs.retrieveComplaint(id);
	}
	@GetMapping("/retrieve-Complaints")
	@ResponseBody
	public List<Complaint> retrieveAllComplaints() {
		return cs.retrieveAllComplaints();
	}
	@GetMapping("/find-Complaint/{type}")
	@ResponseBody
	public List<Complaint> findComplaintbytype(@PathVariable ("type")Type type) {
	return cs.findComplaintBytype(type);
	}
	
	@PutMapping("/modify-Complaint/{id}")
	@ResponseBody
	Complaint updateComplaint(@RequestBody Complaint c,@PathVariable ("id")int id){
		return cs.updateComplaint(c,id);
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
	public void assignComplaintToUser(@PathVariable("idcomplaint") int  idComplaint ,@PathVariable("idcomplaint") int  iduser){
		cs.assignComplaintToUser(idComplaint, iduser);
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
