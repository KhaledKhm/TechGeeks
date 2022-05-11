package tn.esprit.spring.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Answer;
import tn.esprit.spring.entities.Quiz;
import tn.esprit.spring.entities.Training;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Integer>
{

	@Query("SELECT q FROM Quiz q WHERE q.training.idTraining =:idTraining")
	public Quiz getQuizByTraining(@Param("idTraining")int idTraining);
}
