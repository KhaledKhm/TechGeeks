package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entities.PostLike;


public interface IPostLikeService {

	public PostLike AjoutPostLike(PostLike p);
	public void SupprimerPostLike(int Id);
	public PostLike PostLikeById(int id);
	public List<PostLike> PostLikeGetAll();
	public void PostLikeModifier(PostLike a, int id);
	
	public String AjoutLikeinpost(PostLike po, int idpost);

}
