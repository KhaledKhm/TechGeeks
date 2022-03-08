package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.BadWordFilter;
import tn.esprit.spring.entities.PostComment;
import tn.esprit.spring.repository.BadWordRepository;
import tn.esprit.spring.repository.PostCommentRepository;
import tn.esprit.spring.service.IPostCommentService;
import tn.esprit.spring.service.IPostLikeService;
import tn.esprit.spring.service.IPostService;

@RestController
@RequestMapping("/PostComment")
public class PostCommentController {

	@Autowired
	IPostCommentService postcommentservice;
	@Autowired 
	IPostService postservice;
	@Autowired 
	IPostLikeService pl;
	
	@Autowired
	BadWordRepository BadWord;
	
	
	
	@DeleteMapping("/Supprimer/{id}")
	public void SupprimerPostComment(@PathVariable int Id) {
		postcommentservice.SupprimerPostComment(Id);
	}
	
	@GetMapping("/getById/{id}")
	public PostComment PostCommentById(@PathVariable int id) {
		return postcommentservice.PostCommentById(id);
	}
	
	@GetMapping("/getAll")
	public List<PostComment> PostCommentGetAll(){
		return postcommentservice.PostCommentGetAll();
	}
	
	@PutMapping("/Modifier/{id}")
	public void PostCommentModifier(@RequestBody PostComment p,@PathVariable int id) {
		PostComment c=postcommentservice.PostCommentById(id);
		c.setComment(p.getComment());
		c.setCommentLikes(p.getCommentLikes());
		postcommentservice.PostCommentModifier(c, id);
	}
	
	/*@PostMapping("/AffecterLike/{idpl}")
	public void affecterLikePost(@RequestBody Post p,@PathVariable int idpl) {
		iPostService.affecterLikePost(p, idpl);
	}*/
	
	@PostMapping("/AjoutCommentairePost/{idPost}")
	public void AssignCommentairePost(@PathVariable("idPost") int idPost ,@RequestBody PostComment po ) {
		
		//postcommentservice.AjoutCommentinpost(po, idPost);
	}
	
	
	
	
	
	
	@PostMapping("/AjoutCommentinterdit/{idPost}")
	public void AjoutComment(@RequestBody PostComment comment,@PathVariable("idPost") int idPost) {
		comment.setComment(BadWordFilter.getCensoredText(comment.getComment()));
		postcommentservice.AjoutCommentinpost(comment, idPost);
	}

}
