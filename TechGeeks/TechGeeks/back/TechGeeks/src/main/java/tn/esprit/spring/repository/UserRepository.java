package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Complaint;
import tn.esprit.spring.entities.Type;
import tn.esprit.spring.entities.User;

@Repository
public interface UserRepository extends 	CrudRepository<User, Integer> {
	User findByfirstName( String username );

}
