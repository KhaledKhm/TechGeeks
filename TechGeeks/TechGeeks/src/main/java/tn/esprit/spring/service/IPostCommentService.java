package tn.esprit.spring.service;
import java.io.IOException;
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
	
	
	
	//public void SupprimerMotInterdit(List<PostComment> p) throws Exception;
	

}
