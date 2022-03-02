package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Post;
import tn.esprit.spring.entities.PostLike;
import tn.esprit.spring.repository.PostLikeRepository;

@Service
public class PostLikeService implements IPostLikeService{

	@Autowired
	PostLikeRepository postLikeRep;
	
	@Autowired 
	IPostService ipostservice;
	@Override
	public PostLike AjoutPostLike(PostLike p) {
		// TODO Auto-generated method stub
		return postLikeRep.save(p);
	}

	@Override
	public void SupprimerPostLike(int Id) {
		// TODO Auto-generated method stub
		postLikeRep.deleteById(Id);
	}

	@Override
	public PostLike PostLikeById(int id) {
		// TODO Auto-generated method stub
		return postLikeRep.findById(id).orElse(null);
	}

	@Override
	public List<PostLike> PostLikeGetAll() {
		// TODO Auto-generated method stub
		return postLikeRep.findAll();
	}

	@Override
	public void PostLikeModifier(PostLike a, int id) {
		// TODO Auto-generated method stub
		postLikeRep.save(a);
	}

	@Override
	public String AjoutLikeinpost(PostLike po, int idpost) {
		// TODO Auto-generated method stub
		Post p=ipostservice.PostById(idpost);
		po.setPost(p);
		if (p.getIdPost()==idpost) {
			int nb=0;
			po.setNbLike(nb+1);
		
		
		postLikeRep.save(po);
		}
		return "like dans post ajouter";

	}

}
