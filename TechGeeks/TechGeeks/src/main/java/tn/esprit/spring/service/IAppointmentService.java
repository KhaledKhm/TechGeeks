package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;

import tn.esprit.spring.entities.Appointment;

public interface IAppointmentService {

	Appointment addAppointement(Appointment a);
	Appointment updateAppointment (Appointment a);
	Optional<Appointment> retrieveAppointment(Integer id);
	void assignAppointmentToUser(int idAppointment, int idexpert ,int iduser);

	void deleteAppointment(Integer id);
}
