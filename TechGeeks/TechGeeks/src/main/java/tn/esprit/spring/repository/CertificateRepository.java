package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Certificate;
import tn.esprit.spring.entities.Training;

@Repository
public interface CertificateRepository extends JpaRepository<Certificate, Integer>{
	
	@Query("Select c from Certificate c where c.user.id =:idUser")
	List<Certificate> FindCertficateByUser(@Param("idUser") int idUser);
	
}
