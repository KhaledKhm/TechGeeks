package tn.esprit.spring.repository;
import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.*;
@Repository
public interface PostLikeRepository extends JpaRepository <PostLike,Integer>{

	
	@Query("SELECT count(*) FROM PostLike ua where ua.postLikes.idPost=:idPost ")
	public int nbTotalelike(@Param("idPost") int idPost);
	
	
}
