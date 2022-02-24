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

import tn.esprit.spring.entities.Post;
import tn.esprit.spring.entities.PostComment;
import tn.esprit.spring.service.IPostCommentService;

@RestController
@RequestMapping("/PostComment")
public class PostCommentController {

	@Autowired
	IPostCommentService pc;
	@PostMapping("/AjoutPost")
	public PostComment AjoutPostComment(@RequestBody List<PostComment> p) {
		return pc.AjoutPostComment((PostComment) p);
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
}
