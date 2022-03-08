package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.esprit.spring.entities.Donation;

public interface DonationRepository extends JpaRepository<Donation,Integer>{

}
