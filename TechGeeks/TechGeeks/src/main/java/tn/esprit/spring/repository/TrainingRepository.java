package tn.esprit.spring.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Training;

@Repository
public interface TrainingRepository extends JpaRepository<Training, Integer>{
	@Query("Select t from Training t where t.sector.name =:name")
	List<Training> FindTrainingBySector(@Param("name") String name);
}
