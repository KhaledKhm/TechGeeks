package tn.esprit.spring.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Answer;


@Repository
public interface AnswerRepository extends JpaRepository<Answer, Integer>
{
	Optional<Answer> findByAnswer(String answer);
	Answer deleteByAnswer(String answer);
	Optional<Answer> findByStatus(boolean status);
	
	@Query("SELECT a FROM Answer a WHERE a.question.idQuestion =:idQuestion and a.status=:status")
	public Answer getAnswerByQuestionAndStatus(@Param("idQuestion")int idQuestion, @Param("status")boolean status);
}
