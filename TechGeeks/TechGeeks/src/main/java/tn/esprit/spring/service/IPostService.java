package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entities.Post;
import tn.esprit.spring.entities.PostComment;
import tn.esprit.spring.entities.PostLike;


public interface IPostService {
	public Post AjoutPost(Post p);
	public void SupprimerPost(int Id);
	public Post PostById(int id);
	public List<Post> PostGetAll();
	public void PostModifier(Post a, int id);
//	public Post affecterCommentairePost(int p,PostComment pc);
//	public Post affecterLikePost(int p,PostComment pl);

}
