package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;

import tn.esprit.spring.entities.Complaint;

public interface IComplaintSerivce {


	Complaint addComplaint(Complaint c);
	Complaint updateComplaint(Complaint c);
	Optional<Complaint> retrieveComplaint(Integer id);
	void deleteComplaint(Integer id);



}
