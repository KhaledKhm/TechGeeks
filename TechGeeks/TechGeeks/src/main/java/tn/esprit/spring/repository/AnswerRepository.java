package tn.esprit.spring.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Answer;


@Repository
public interface AnswerRepository extends JpaRepository<Answer, Integer>
{
	Optional<Answer> findByAnswer(String answer);
	Answer deleteByAnswer(String answer);
	/*@Query("Select "
			+ "DISTINCT answer from Answer answer "
			+ "join answer.Question question "
			+ "where question=:Question")
    public List<Answer> getAllAnswerByQuestion(@Param("question") Question question);*/
	
//	@Modifying
//	@Query("Delete  From Answer a  where Answer.question.idQuestion =Question.idQuestion and Question.idQuestion =: idQues")
//	void deleteByIdQuestion(@Param("idQues") int idQues);
	
}
