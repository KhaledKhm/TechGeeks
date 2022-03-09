package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Local;

@Repository
public interface LocalRepository extends JpaRepository<Local,Integer>{

}
