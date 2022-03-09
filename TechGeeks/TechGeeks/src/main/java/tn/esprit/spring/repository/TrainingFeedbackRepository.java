package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.TrainingFeedback;

@Repository
public interface TrainingFeedbackRepository extends JpaRepository<TrainingFeedback, Integer>{

}
