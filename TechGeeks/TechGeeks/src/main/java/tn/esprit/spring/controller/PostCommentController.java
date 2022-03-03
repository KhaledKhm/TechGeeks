package tn.esprit.spring.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Post;
import tn.esprit.spring.entities.PostComment;
import tn.esprit.spring.entities.PostLike;
import tn.esprit.spring.repository.PostCommentRepository;
import tn.esprit.spring.service.IPostCommentService;
import tn.esprit.spring.service.IPostLikeService;
import tn.esprit.spring.service.IPostService;

@RestController
@RequestMapping("/PostComment")
public class PostCommentController {

	@Autowired
	IPostCommentService pc;
	@Autowired 
	IPostService postservice;
	@Autowired 
	IPostLikeService pl;
	
	@PostMapping("/AjoutComment")
	public PostComment AjoutPostComment(@RequestBody PostComment p) {
		return pc.AjoutPostComment(p);
	}
	
	@DeleteMapping("/Supprimer/{id}")
	public void SupprimerPostComment(@PathVariable int Id) {
		pc.SupprimerPostComment(Id);
	}
	
	@GetMapping("/getById/{id}")
	public PostComment PostCommentById(@PathVariable int id) {
		return pc.PostCommentById(id);
	}
	
	@GetMapping("/getAll")
	public List<PostComment> PostCommentGetAll(){
		return pc.PostCommentGetAll();
	}
	
	@PutMapping("/Modifier/{id}")
	public void PostCommentModifier(@RequestBody PostComment p,@PathVariable int id) {
		PostComment c=pc.PostCommentById(id);
		c.setComment(p.getComment());
		c.setCommentLikes(p.getCommentLikes());
		pc.PostCommentModifier(c, id);
	}
	
	/*@PostMapping("/AffecterLike/{idpl}")
	public void affecterLikePost(@RequestBody Post p,@PathVariable int idpl) {
		iPostService.affecterLikePost(p, idpl);
	}*/
	
	@PostMapping("/AjoutCommentairePost/{idPost}")
	@ResponseBody
	public void AjoutCommentairePost(@PathVariable("idPost") int idPost ,@RequestBody PostComment po ) {
		
		pc.AjoutCommentinpost(po, idPost);
	}
	
	
	@Autowired 
	PostCommentRepository pr;
	
	@Scheduled(cron="*/60 * * * * *")
	@GetMapping("/interdit")
	@ResponseBody
	public void motinterdit() throws Exception {
		//List<PostComment> p= pc.PostCommentGetAll();
		
		//pc.SupprimerMotInterdit(p);
		pc.getDictionaire();
		System.out.print("chaque 60 seconde verifier");
		 
		
	}
	
	

}
