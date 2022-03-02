package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import tn.esprit.spring.entities.Donation;

public interface DonationRepository extends JpaRepository<Donation,Integer>{

	@Query("Select COUNT(*) FROM User u where u.username = :username")
	int nbreByUser(@Param("username") String username);
}
