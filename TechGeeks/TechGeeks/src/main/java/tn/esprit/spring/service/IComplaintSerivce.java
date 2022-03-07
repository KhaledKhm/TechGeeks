package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;

import tn.esprit.spring.entities.Complaint;
import tn.esprit.spring.entities.User;

import tn.esprit.spring.entities.Type;

public interface IComplaintSerivce {


	Complaint addComplaint(Complaint c);
	Complaint updateComplaint(Complaint c);
	Optional<Complaint> retrieveComplaint(Integer id);
	 List<Complaint> retrieveAllComplaints();
	 Page<Complaint> findComplaintwithPagination(int offset,int pagesize );
	List<Complaint> findComplaintBytype(Type type);
	void assignComplaintToUser(int idComplaint, int iduser);
	void deleteComplaint(Integer id);
	void traiterComplaint(int idComplaint, int iduser);
	int nbreCompParUser(@Param("offre") int iduser);
	void ajouterEtaffectercomplaints(Complaint c, int userid);
}
