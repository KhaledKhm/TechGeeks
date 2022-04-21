package tn.esprit.spring.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Post;
import tn.esprit.spring.repository.PostCommentRepository;
import tn.esprit.spring.repository.PostLikeRepository;
import tn.esprit.spring.repository.PostRepository;
@Service
public class PostService implements IPostService{

	@Autowired 
	PostRepository postrepo;
	@Autowired
	PostCommentRepository pr;
	@Autowired 
	PostLikeRepository replike;
	
	@Override
	public Post AjoutPost(Post p) {
		// TODO Auto-generated method stub
		return postrepo.save(p);
	}

	@Override
	public void SupprimerPost(int id) {
		// TODO Auto-generated method stub
		postrepo.deleteById(id);
	}

	@Override
	public Post PostById(int id) {
		// TODO Auto-generated method stub
		return postrepo.findById(id).orElse(null);
	}

	@Override
	public List<Post> PostGetAll() {
		// TODO Auto-generated method stub
		return postrepo.findAll();
	}

	@Override
	public void PostModifier(Post a, int id) {
		// TODO Auto-generated method stub
		postrepo.save(a);
	}

	
	
	@Override
	public List<Post> getByTitle(String title) {
		// TODO Auto-generated method stub
		return (List<Post>)postrepo.findByTitle(title);
	}

	@Override
	public List<Post> getOrderByDate() {
		// TODO Auto-generated method stub
		return postrepo.findAllByOrderByCreatedAtDesc();
	}

	@Override
	public List<Post> getByordernbLike() {
		// TODO Auto-generated method stub
		//return postrepo.AfficherPostorderbynbLike();
		
		/*List<Post>  listpost=postrepo.findAll();
		for(int i=0;i<listpost.size();i++) {
			int nblike=replike.nbTotalelike(listpost.get(i).getIdPost());
			if(nblike > replike.nbTotalelike(listpost.get(i).getIdPost())) {
				
			}
		}*/
		
			
		
		//int nblike=replike.nbTotalelike();
		return postrepo.AfficherPostbynbLike();
	}

	
	/*@Override
	public Post savefile(MultipartFile file) {
		// TODO Auto-generated method stub
		String filename=file.getOriginalFilename();
		
		try {
			Post post=new Post(0, filename,file.getContentType(),file.getBytes(), null, null, null, null);
			return postrepo.save(post);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}*/

/*	@Override
	public Post affecterCommentairePost(int p, PostComment idco) {
		// TODO Auto-generated method stub
		Post pc =postrepo.findById(p).orElse(null);
		pc.setPostComments((Set<PostComment>) idco);
		postrepo.save(pc);
		return pc;
	}
*/
	/*@Override
	public Post affecterLikePost(Post p, int plike) {
		// TODO Auto-generated method stub
		PostLike pl= postlike.findById(plike).orElse(null);
		p.setPostLikes((Set<PostLike>) pl);
		postrepo.save(p);
		return p;
	}*/

}
