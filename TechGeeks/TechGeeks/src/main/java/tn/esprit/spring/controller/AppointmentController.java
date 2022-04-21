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

import tn.esprit.spring.entities.Appointment;
import tn.esprit.spring.entities.Complaint;
import tn.esprit.spring.repository.AppointmentRepository;
import tn.esprit.spring.service.IAppointmentService;
import tn.esprit.spring.service.IComplaintSerivce;

@RestController
public class AppointmentController {
	@Autowired
	IAppointmentService as;
	@Autowired 
	AppointmentRepository ap;
	@PostMapping("/add-Appointment")
	@ResponseBody
	Appointment addAppointment(@RequestBody Appointment a){//@request taayet lel les attributs
	return as.addAppointement(a);
	}

	@GetMapping("/retrieve-Appointment")
	@ResponseBody
	Optional<Appointment> retrieveAppointment(Integer id){
	return as.retrieveAppointment(id);
	}
	@GetMapping("/retrieve-Appointments")
	@ResponseBody
	 public List<Appointment> retrieveAppointments() {
	return as.retrieveAllAppointments();
	}
	@GetMapping("/retrieve-Appointmentswithsorting/{field}")
	@ResponseBody
	public List<Appointment> retrieveAllAppointmentwithsorting(@PathVariable("field")String field) {
		return as.retrieveAllAppointmentwithsorting(field);
	}
	
	@GetMapping("/retrieve-verif")
	@ResponseBody
	public List<Appointment> verifuser() {
		return ap.verifuser();
	}
	
	@PutMapping("/modify-Appointment")
	@ResponseBody
	Appointment updateAppointment(@RequestBody Appointment a){
		return as.updateAppointment(a);
	}
	
	@DeleteMapping("/delete-Appointment/{id}")
	void deleteAppointment(@PathVariable(name="id")Integer id){
		as.deleteAppointment(id);
	}
	@PostMapping("/assign-Appointment/{idAppointment}/{idexpert}/{iduser}")
	@ResponseBody
	public void assignAppointmentTouser(@PathVariable("idAppointment") int  idAppointment ,@PathVariable("idexpert")int idexpert,@PathVariable("iduser")int iduser){
		as.assignAppointmentToUser(idAppointment, idexpert,iduser);
	}
	@GetMapping("/get-AppointmentByuser/{iduser}")
	@ResponseBody
	List<Appointment>  AppointementByuser(@PathVariable("iduser") int iduser) {
	return as.findAppointmentByUser(iduser);
	}
}
