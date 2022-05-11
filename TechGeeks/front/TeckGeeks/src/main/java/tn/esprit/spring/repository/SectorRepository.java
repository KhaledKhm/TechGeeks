package tn.esprit.spring.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tn.esprit.spring.entities.Sector;

@Repository
public interface SectorRepository extends JpaRepository<Sector,Integer>
{
	Optional<Sector> findByName(String name);
	Sector deleteByName(String name);
}
