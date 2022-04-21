package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entities.CommentLike;
import tn.esprit.spring.entities.Post;

public interface ICommentLikeService {
	public CommentLike AjoutCommentLike(CommentLike c);
	public void SupprimerCommentLike(int Id);
	public CommentLike CommentLikeById(int id);
	public List<CommentLike> CommentLikeGetAll();
	public void CommentLikeModifier(CommentLike a, int id);
	public Post affecterLikeCommentaire(CommentLike cl,int pl);
}
