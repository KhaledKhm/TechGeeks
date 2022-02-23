package tn.esprit.spring.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import tn.esprit.spring.entities.Complaint;
import tn.esprit.spring.entities.Type;
@Repository
public interface ComplaintRepository extends 	JpaRepository<Complaint, Integer>{

	Optional<Complaint> findByType( Type type );


}
