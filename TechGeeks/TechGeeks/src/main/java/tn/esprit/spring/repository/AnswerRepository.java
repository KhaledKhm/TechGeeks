package tn.esprit.spring.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
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
}
