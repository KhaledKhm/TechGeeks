package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import tn.esprit.spring.entities.PostComment;
import tn.esprit.spring.repository.PostCommentRepository;
@Service
public class PostCommentService implements IPostCommentService{

	@Autowired 
	PostCommentRepository postCommentrep;
	
	@Override
	public PostComment AjoutPostComment(PostComment p) {
		// TODO Auto-generated method stub
		return postCommentrep.save(p);
	}

	@Override
	public void SupprimerPostComment(int Id) {
		// TODO Auto-generated method stub
		postCommentrep.deleteById(Id);
	}

	@Override
	public PostComment PostCommentById(int id) {
		// TODO Auto-generated method stub
		return postCommentrep.findById(id).orElse(null);
	}

	@Override
	public List<PostComment> PostCommentGetAll() {
		// TODO Auto-generated method stub
		return postCommentrep.findAll();
	}

	@Override
	public void PostCommentModifier(PostComment a, int id) {
		// TODO Auto-generated method stub
		postCommentrep.save(a);
	}

	

}
