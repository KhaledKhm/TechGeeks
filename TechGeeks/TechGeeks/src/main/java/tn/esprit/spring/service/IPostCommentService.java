package tn.esprit.spring.service;
import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import tn.esprit.spring.entities.PostComment;



public interface IPostCommentService{
	public PostComment AjoutPostComment(PostComment p);
	public void SupprimerPostComment(int Id);
	public PostComment PostCommentById(int id);
	public List<PostComment> PostCommentGetAll();
	public void PostCommentModifier(PostComment a, int id);

	public String AjoutCommentinpost(PostComment po, int idpost);
	
	/*@Modifying
	@Query(value="insert into PostComment (comment) values (:comment) where idpost = :id ")
	public void ajoutcommentaire(@Param("comment") String comment, @Param("id") int id);*/

}
