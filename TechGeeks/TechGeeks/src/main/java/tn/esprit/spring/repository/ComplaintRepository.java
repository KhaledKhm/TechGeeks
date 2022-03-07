package tn.esprit.spring.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import tn.esprit.spring.entities.Complaint;
import tn.esprit.spring.entities.Type;
@Repository
public interface ComplaintRepository extends 	JpaRepository<Complaint, Integer>{

	List<Complaint> findByType( Type type );
	@Query("Select COUNT(c) FROM Complaint c where c.userComplaint.idUser=:id")
	int nbreCompParUser(@Param("id") int iduser);

}
