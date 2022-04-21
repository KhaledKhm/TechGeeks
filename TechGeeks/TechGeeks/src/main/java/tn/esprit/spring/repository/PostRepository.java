package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Post;
@Repository
public interface PostRepository extends JpaRepository<Post,Integer>{

	public List<Post> findByTitle(String titre);
	
	public List<Post> findAllByOrderByCreatedAtDesc(); 

	@Query(value ="SELECT * FROM post p JOIN post_like pl ON p.id_post = pl.post_likes_id_post GROUP BY p.id_post ORDER BY COUNT(pl.nb_like) DESC",nativeQuery = true)
	public List<Post> AfficherPostbynbLike();
 
}