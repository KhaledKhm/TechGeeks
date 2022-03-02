package tn.esprit.spring.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.query.Param;

import tn.esprit.spring.entities.Appointment;
import tn.esprit.spring.entities.Complaint;

public interface IAppointmentService {

	Appointment addAppointement(Appointment a);
	Appointment updateAppointment (Appointment a);
	Optional<Appointment> retrieveAppointment(Integer id);
	void assignAppointmentToUser(int idAppointment, int idexpert ,int iduser);
	 List<Appointment> retrieveAllAppointments();
	 List<Appointment> retrieveAllAppointmentwithsorting(String field);
	 List <Appointment> findAppointmentByUser(@Param("id") int iduser);
	void deleteAppointment(Integer id);
}
