package tn.esprit.spring.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import tn.esprit.spring.entities.*;
public interface PostLikeRepository extends JpaRepository <PostLike,Integer>{

	/*@Query("select count(*)a from postlike p where p.id_post := idpost ")
	public int nblike(PostLike pl,@Param("idpost") int idpost);*/
}
