package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Answer;
import tn.esprit.spring.entities.UserAnswer;

@Repository
public interface UserAnswerRepository extends JpaRepository<UserAnswer, Integer>{
	
	@Query("Select ua from UserAnswer ua where ua.idQuiz=:idQuiz and ua.certificate.idCertificate=:idCertificate")
	public List<UserAnswer> getUserAnswerByQuizAndCertificate(@Param("idQuiz")int idQuiz, @Param("idCertificate")int idCertificate);
	
	@Query("SELECT count(*) FROM UserAnswer ua where ua.idQuiz=:idQuiz and ua.certificate.idCertificate=:idCertificate")
    public int CountUserAnswerByQuizAndCertificate(@Param("idQuiz")int idQuiz, @Param("idCertificate")int idCertificate);

}
