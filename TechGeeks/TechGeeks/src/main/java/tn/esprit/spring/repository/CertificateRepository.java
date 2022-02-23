package tn.esprit.spring.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Certificate;
import tn.esprit.spring.entities.User;

@Repository
public interface CertificateRepository extends JpaRepository<Certificate, Integer>{
	
}
