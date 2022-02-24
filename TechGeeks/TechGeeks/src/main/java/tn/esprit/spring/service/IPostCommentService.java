package tn.esprit.spring.service;
import java.util.List;

import tn.esprit.spring.entities.CommentLike;
import tn.esprit.spring.entities.Post;
import tn.esprit.spring.entities.PostComment;



public interface IPostCommentService{
	public PostComment AjoutPostComment(PostComment p);
	public void SupprimerPostComment(int Id);
	public PostComment PostCommentById(int id);
	public List<PostComment> PostCommentGetAll();
	public void PostCommentModifier(PostComment a, int id);
	

}
