package tn.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.CommentLike;

@Repository
public interface CommentLikeRepository extends JpaRepository<CommentLike,Integer>{

}
