//package tn.esprit.spring.service;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import tn.esprit.spring.entities.CommentLike;
//import tn.esprit.spring.entities.Post;
//import tn.esprit.spring.repository.CommentLikeRepository;
//
//@Service
//public class CommentLikeService implements ICommentLikeService{
//
//	@Autowired
//	CommentLikeRepository commentlike;
//	@Override
//	public CommentLike AjoutCommentLike(CommentLike c) {
//		// TODO Auto-generated method stub
//		return commentlike.save(c);
//	}
//
//	@Override
//	public void SupprimerCommentLike(int Id) {
//		// TODO Auto-generated method stub
//		commentlike.deleteById(Id);
//	}
//
//	@Override
//	public CommentLike CommentLikeById(int id) {
//		// TODO Auto-generated method stub
//		return commentlike.findById(id).orElse(null);
//	}
//
//	@Override
//	public List<CommentLike> CommentLikeGetAll() {
//		// TODO Auto-generated method stub
//		return commentlike.findAll();
//	}
//
//	@Override
//	public void CommentLikeModifier(CommentLike a, int id) {
//		// TODO Auto-generated method stub
//		commentlike.save(a);
//	}
//
//	@Override
//	public Post affecterLikeCommentaire(CommentLike cl, int pl) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//}
