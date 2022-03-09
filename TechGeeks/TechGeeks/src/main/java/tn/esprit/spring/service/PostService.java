//package tn.esprit.spring.service;
//
//import java.util.List;
//import java.util.Set;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import tn.esprit.spring.entities.Post;
//import tn.esprit.spring.entities.PostComment;
//import tn.esprit.spring.entities.PostLike;
//import tn.esprit.spring.repository.PostCommentRepository;
//import tn.esprit.spring.repository.PostLikeRepository;
//import tn.esprit.spring.repository.PostRepository;
//@Service
//public class PostService implements IPostService{
//
//	@Autowired 
//	PostRepository postrepo;
//	@Autowired
//	PostCommentRepository pr;
//	@Autowired
//	PostLikeRepository postlike;
//	
//	@Override
//	public Post AjoutPost(Post p) {
//		// TODO Auto-generated method stub
//		return postrepo.save(p);
//	}
//
//	@Override
//	public void SupprimerPost(int id) {
//		// TODO Auto-generated method stub
//		postrepo.deleteById(id);
//	}
//
//	@Override
//	public Post PostById(int id) {
//		// TODO Auto-generated method stub
//		return postrepo.findById(id).orElse(null);
//	}
//
//	@Override
//	public List<Post> PostGetAll() {
//		// TODO Auto-generated method stub
//		return postrepo.findAll();
//	}
//
//	@Override
//	public void PostModifier(Post a, int id) {
//		// TODO Auto-generated method stub
//		postrepo.save(a);
//	}
//
///*	@Override
//	public Post affecterCommentairePost(int p, PostComment idco) {
//		// TODO Auto-generated method stub
//		Post pc =postrepo.findById(p).orElse(null);
//		pc.setPostComments((Set<PostComment>) idco);
//		postrepo.save(pc);
//		return pc;
//	}
//*/
//	/*@Override
//	public Post affecterLikePost(Post p, int plike) {
//		// TODO Auto-generated method stub
//		PostLike pl= postlike.findById(plike).orElse(null);
//		p.setPostLikes((Set<PostLike>) pl);
//		postrepo.save(p);
//		return p;
//	}*/
//
//}
