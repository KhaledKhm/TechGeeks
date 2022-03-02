package tn.esprit.spring.repository;

import org.springframework.stereotype.Repository;
import tn.esprit.spring.entities.*;

import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface AdvertisingRepository extends JpaRepository<Advertising,Integer>{

}
