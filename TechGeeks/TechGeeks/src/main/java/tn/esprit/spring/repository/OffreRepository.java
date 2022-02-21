package tn.esprit.spring.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import tn.esprit.spring.entities.Offre;


public interface OffreRepository extends JpaRepository<Offre,Integer> {

}
