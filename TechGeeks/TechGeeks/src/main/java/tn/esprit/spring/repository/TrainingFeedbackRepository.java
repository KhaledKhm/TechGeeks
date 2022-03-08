package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.esprit.spring.entities.TrainingFeedback;

public interface TrainingFeedbackRepository extends JpaRepository<TrainingFeedback, Integer>{

}
