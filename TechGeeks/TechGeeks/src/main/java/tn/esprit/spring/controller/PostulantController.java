package tn.esprit.spring.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Offre;
import tn.esprit.spring.entities.Postulant;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.repository.OffreRepository;
import tn.esprit.spring.repository.PostulationRepository;
import tn.esprit.spring.repository.UserRepository;
import tn.esprit.spring.service.IOffreService;
import tn.esprit.spring.service.IPostulationService;

@RestController
public class PostulantController {
	
	@Autowired
	IPostulationService postulationService;
	@Autowired
	PostulationRepository postulationRepository;
	@Autowired
	IOffreService offreService;
	@Autowired
	UserRepository userRepository;	
	public PostulantController() {
		// TODO Auto-generated constructor stub
	}
	
	@PostMapping("/add-postulant/{id_user}/{id_offre}")
	@ResponseBody
	Postulant addPostulant(@RequestBody Postulant p , @PathVariable("id_user")Integer id_user, @PathVariable("id_offre")Integer id_offre ){
		p.setUsers(userRepository.findById(id_user).get());
		p.setOffres(offreService.retrieveOffre(id_offre));
		postulationRepository.save(p);
		return p;
	}
	
	@GetMapping("/retrieve-allPostulant")
	@ResponseBody
	List<Postulant> retrieveAllOffres(){
		return postulationService.retrieveAllOffresPostulant();
	}
	
	@GetMapping("/get-Postulant/{id_Postulant}")
	@ResponseBody
	Postulant getPostulantById(@PathVariable("id_Postulant") int idPostulant){
		return postulationService.retrieveOffrePostulant(idPostulant);
		
	}
	
	@PutMapping("/modify-postulant")
	@ResponseBody
	Postulant updatePostulant(@RequestBody Postulant postulant){
		
		return postulationService.updateOffrePostulant(postulant);
	}
	
	@DeleteMapping("/delete-postulant/{idPostulant}")
	void deleteEvent(@PathVariable("idPostulant") int idPostulant){
		postulationService.deleteOffrePostulant(idPostulant);
		
	}
	@GetMapping("/get-UserByPostulant/{id_offre}")
	@ResponseBody
	List<User> getUserByPostulant(@PathVariable("id_offre") int id_offre){
		List<User> postulants = postulationRepository.findPostulantByOffres(id_offre);
		return postulants;
	}
	
	@GetMapping("/get-OffreByPostulant/{id_user}")
	@ResponseBody
	List<Offre> getOffreByPostulant(@PathVariable("id_user") int id_user){
		List<Offre> offres = postulationRepository.findOffresByPostulant(id_user);
		return offres;
	}
	@GetMapping("/get-statistiqueOffre/{id_offre}")
	@ResponseBody
	int nbrPosParOffre(@PathVariable("id_offre") int id_offre){
		int stats = postulationRepository.nbrePosParOffre(id_offre);
		return stats;
	}
	
	@GetMapping("/get-statistiqueOffreAll")
	@ResponseBody
	HashMap<Integer, Integer> nbrPosParOffreAll(){
        HashMap<Integer, Integer> map1 = new HashMap<Integer, Integer>();
		List<Offre> offres = offreService.retrieveAllOffres();
		offres.forEach(o->{
			System.out.println(o.getIdOffer()+" : ");
			System.out.println(postulationRepository.nbrePosParOffre(o.getIdOffer())+"/n");
			map1.put(o.getIdOffer()  , postulationRepository.nbrePosParOffre(o.getIdOffer()));
		});
		return map1;
	}

}
