package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Offre;
import tn.esprit.spring.entities.Postulant;
import tn.esprit.spring.entities.User;

@Repository
public interface PostulationRepository extends JpaRepository<Postulant,Integer>{

	@Query("Select distinct u FROM User u,Postulant p where   p.offres.idOffer=:offre and p.users=u ")
	List<User> findPostulantByOffres(@Param("offre") int offre);
	
	@Query("Select distinct o FROM Offre o,Postulant p where  p.users.id=:userId and p.offres=o")
	List<Offre> findOffresByPostulant(@Param("userId") int userId);
	
	@Query("Select COUNT(u) FROM User u,Postulant p where   p.offres.idOffer=:offre and p.users=u ")
	int nbrePosParOffre(@Param("offre") int offre);
}
