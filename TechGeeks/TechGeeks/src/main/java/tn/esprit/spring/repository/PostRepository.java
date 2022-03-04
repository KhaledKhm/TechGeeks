package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.esprit.spring.entities.Post;

public interface PostRepository extends JpaRepository<Post,Integer>{

	public List<Post> findByTitle(String titre);
}
