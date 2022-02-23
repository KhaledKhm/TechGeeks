package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Training;

@Repository
public interface TrainingRepository extends JpaRepository<Training, Integer>{

/*	@Query("select idTraining from Training  where Training.idTraining=:idTrainning")
	public int getIdTraining(@Param("idTrainning") int idTrainning);*/
}
