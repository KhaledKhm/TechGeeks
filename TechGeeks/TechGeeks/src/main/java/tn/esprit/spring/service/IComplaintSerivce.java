package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;

import tn.esprit.spring.entities.Complaint;
import tn.esprit.spring.entities.Type;

public interface IComplaintSerivce {


	Complaint addComplaint(Complaint c);
	Complaint updateComplaint(Complaint c);
	Optional<Complaint> retrieveComplaint(Integer id);
	Optional<Complaint> findComplaintBytype(Type type);
	void assignComplaintToUser(int idComplaint, int iduser);

	void deleteComplaint(Integer id);



}
