package tn.esprit.spring.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import tn.esprit.spring.entities.Appointment;
import tn.esprit.spring.entities.Complaint;

public interface IAppointmentService {

	Appointment addAppointement(Appointment a);
	Appointment updateAppointment (Appointment a);
	Optional<Appointment> retrieveAppointment(Integer id);
	void assignAppointmentToUser(int idAppointment, int idexpert ,int iduser);
	 List<Appointment> retrieveAllAppointments();
	 List<Appointment> retrieveAllAppointmentwithsorting(String field);

	void deleteAppointment(Integer id);
}
