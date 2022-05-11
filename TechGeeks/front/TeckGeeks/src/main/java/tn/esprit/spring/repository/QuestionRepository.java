package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Question;


@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer>{
	@Query("SELECT q FROM Question q WHERE q.quiz.idQuiz =:idQuiz")
	public Question getQuestionByQuiz(@Param("idQuiz")int idQuiz);

}
