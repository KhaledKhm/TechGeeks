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

	/*@Query(value ="Select Post from Post ",nativeQuery = true)
	public List<Post> AfficherPostbynbLike();*/
 
}