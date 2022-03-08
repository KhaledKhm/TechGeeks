package tn.esprit.spring.service;

import java.util.List;
import java.util.Set;


import tn.esprit.spring.entities.Post;


public interface IPostService {
	public Post AjoutPost(Post p);
	public void SupprimerPost(int Id);
	public Post PostById(int id);
	public List<Post> PostGetAll();
	public void PostModifier(Post a, int id);
//	public Post affecterCommentairePost(int p,PostComment pc);
//	public Post affecterLikePost(int p,PostComment pl);
	
	public List<Post> getByTitle(String title);
	
	//public Post savefile(MultipartFile file);
	public List<Post> getOrderByDate();
	
public List<Post> getByOrdernbLike();

}
