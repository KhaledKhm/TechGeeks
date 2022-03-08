package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.PostLike;
import tn.esprit.spring.repository.PostLikeRepository;

@Service
public class PostLikeService implements IPostLikeService{

	@Autowired
	PostLikeRepository postLikeRep;
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

}
