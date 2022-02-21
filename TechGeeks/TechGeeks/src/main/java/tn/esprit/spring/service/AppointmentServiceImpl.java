package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Appointment;
import tn.esprit.spring.entities.Complaint;
import tn.esprit.spring.repository.AppointmentRepository;
@Service
public class AppointmentServiceImpl implements IAppointmentService {
@Autowired 
AppointmentRepository apprepo;
	@Override
	public Appointment addAppointement(Appointment a) {
		// TODO Auto-generated method stub
		return apprepo.save(a);
	}

	@Override
	public Appointment updateAppointment(Appointment a) {
		// TODO Auto-generated method stub
		return apprepo.save(a);
	}
	@Override
	public Optional<Appointment> retrieveAppointment(Integer id) {
		// TODO Auto-generated method stub
		return apprepo.findById(id);
	}

	@Override
	public void deleteAppointment(Integer id) {
		// TODO Auto-generated method stub
		apprepo.deleteById(id);

	}

}
