package tn.esprit.spring.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Document;
import tn.esprit.spring.entities.Sector;
import tn.esprit.spring.entities.Training;


@Repository
public interface DocumentRepository extends JpaRepository<Document, Integer>
{
	
}



