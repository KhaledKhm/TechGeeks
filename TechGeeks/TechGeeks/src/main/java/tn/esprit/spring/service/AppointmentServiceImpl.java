package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Appointment;
import tn.esprit.spring.entities.Complaint;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.repository.AppointmentRepository;
import tn.esprit.spring.repository.UserRepository;
@Service
public class AppointmentServiceImpl implements IAppointmentService {
@Autowired 
AppointmentRepository apprepo;
@Autowired 
UserRepository urepo;
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

	@Override
	public void assignAppointmentToUser(int idAppointment,int idexpert, int iduser) {
		// TODO Auto-generated method stub
		User u = urepo.findById(iduser).orElse(null);
		Appointment a= apprepo.findById(idAppointment).orElse(null);
		a.setExpert(u);
		a.setWomen(u);
		apprepo.save(a);
		
	}

}
