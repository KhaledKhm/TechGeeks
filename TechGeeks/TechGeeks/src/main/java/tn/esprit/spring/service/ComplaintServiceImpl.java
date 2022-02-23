package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.Entity.Produit;
import tn.esprit.spring.Entity.Stock;
import tn.esprit.spring.entities.Complaint;
import tn.esprit.spring.entities.Type;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.repository.ComplaintRepository;
import tn.esprit.spring.repository.UserRepository;

@Service
public class ComplaintServiceImpl  implements IComplaintSerivce{
	@Autowired
	ComplaintRepository comprepo;
	@Autowired
	UserRepository urepo;
	@Override
	public Complaint addComplaint(Complaint c) {
		// TODO Auto-generated method stub
		return comprepo.save(c);
	}

	@Override
	public Complaint updateComplaint(Complaint c) {
		// TODO Auto-generated method stub
		//Complaint com=comprepo.findById(c.getIdComplaint()).orElse(null);
		///com.setTitle(com.getTitle());
		//comprepo.save(c);
		return comprepo.save(c);

	}

	@Override
	public Optional<Complaint> retrieveComplaint(Integer id) {
		// TODO Auto-generated method stub
		return comprepo.findById(id);
	}
	

	@Override
	public void deleteComplaint(Integer id) {
		// TODO Auto-generated method stub
		comprepo.deleteById(id);
	}
	public Optional<Complaint> findComplaintBytype(Type type){
		return comprepo.findByType(type);
		
	}

	@Override
	public void assignComplaintToUser(int idComplaint, int iduser) {
		// TODO Auto-generated method stub
			User u = urepo.findById(iduser).orElse(null);
			Complaint C= comprepo.findById(idComplaint).orElse(null);
			C.setUserComplaint(u);
			comprepo.save(C);
	}
	


}
