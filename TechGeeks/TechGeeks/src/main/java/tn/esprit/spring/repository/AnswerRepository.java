package tn.esprit.spring.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Answer;
import tn.esprit.spring.entities.Question;


@Repository
public interface AnswerRepository extends JpaRepository<Answer, Integer>
{
	Optional<Answer> findByAnswer(String answer);
	Answer deleteByAnswer(String answer);
	Optional<Answer> findByStatus(boolean status);
	
	@Query("SELECT a FROM Answer a WHERE a.question.idQuestion =:idQuestion")
	public List <Answer> getAnswerByQuestion(@Param("idQuestion")int idQuestion);
	
	@Query("SELECT a FROM Answer a WHERE a.question.idQuestion =:idQuestion and a.status=:status")
	public Answer getAnswerByQuestionAndStatus(@Param("idQuestion")int idQuestion, @Param("status")boolean status);
}
