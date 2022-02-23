package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.esprit.spring.entities.Offre;
import tn.esprit.spring.entities.Postulant;

public interface PostulationRepository extends JpaRepository<Postulant,Integer>{

}
