package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


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
	@Autowired
	 EmailService emailService;
	@Override
	public Complaint addComplaint(Complaint c) {
		// TODO Auto-generated method stub
		return comprepo.save(c);
	}
	public void ajouterEtaffectercomplaints(Complaint c, int userid) {
	User user = urepo.findById(userid).orElse(null);
	c.setExper(user);
	comprepo.save(c);
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
	public List<Complaint> findComplaintBytype(Type type){
		return (List<Complaint>)  comprepo.findByType(type);
		
	}
	public Page<Complaint> findComplaintwithPagination(int offset,int pagesize ){ 
		Page<Complaint> cpl=	comprepo.findAll(PageRequest.of(offset, pagesize));
		return cpl;
	}
	public List<Complaint> retrieveAllComplaints() {
		// TODO Auto-generated method stub
		return(List<Complaint>) comprepo.findAll();
	}

	//@Override
	//public void assignComplaintToUser(Complaint c, int iduser) {
		// TODO Auto-generated method stub
		//	User u = urepo.findById(iduser).orElse(null);
		//	c.setExper(iduser).;
		//	comprepo.save(c);
//	}//

	@Override
   public int nbreCompParUser(int iduser) {
		// TODO Auto-generated method stub
		return comprepo.nbreCompParUser(iduser);
	}

	@Override
	public void traiterComplaint(int idComplaint, int iduser) {
		// TODO Auto-generated method stub
		User u = urepo.findById(iduser).orElse(null);
		Complaint C= comprepo.findById(idComplaint).orElse(null);
		C.setResponse("response of complaint");
		comprepo.save(C);
	
	emailService.sendSimpleEmail(u.getEmail(), "Reponse reclamation ", "Votre Reclamation est en cours de traitement ");
	
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
