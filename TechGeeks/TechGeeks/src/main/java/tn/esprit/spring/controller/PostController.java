package tn.esprit.spring.controller;

import java.util.List;

import javax.websocket.server.PathParam;

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
import tn.esprit.spring.service.IPostService;

@RestController
@RequestMapping("/Post")
public class PostController {

	@Autowired 
	IPostService iPostService;
	
	
	@PostMapping("/AjoutPost")
	public String AjoutPost(@RequestBody Post p) {
		iPostService.AjoutPost((Post) p);
		return "Post ajouter";
	}
	
	@DeleteMapping("/SupprimerPost/{id}")
	public void SupprimerPost(@PathVariable int Id) {
		iPostService.SupprimerPost(Id);
	}
	
	@GetMapping("/getByid/{id}")
	public Post PostById(@PathVariable int id) {
		return iPostService.PostById(id);
	}
	
	@GetMapping("/getAll")
	public List<Post> PostGetAll(){
		return iPostService.PostGetAll();
	}
	@PutMapping("/Modifier/{id}")
	public void PostModifier(@RequestBody Post p,@PathVariable int id) {
		Post post=iPostService.PostById(id);
		post.setBody(p.getBody());
		post.setCreatedAt(p.getCreatedAt());
		post.setPhoto(p.getPhoto());
		post.setTitle(p.getTitle());
		iPostService.PostModifier(post, id);;
	}
	@PostMapping("/AffecterCommentaire/{idpc}")
	public void affecterCommentairePost(@PathVariable int p,@RequestBody PostComment idpc) {
	//	iPostService.affecterCommentairePost(p, idpc);
	}
	
	@PostMapping("/AffecterLike/{idpl}")
	public void affecterLikePost(@RequestBody Post p,@PathVariable int idpl) {
		//iPostService..affecterLikePost(p, idpl);
	}
	@GetMapping("/getByTitle/{title}")
	public List<Post> PostGetTitle(@PathVariable String title){
		return iPostService.getByTitle(title);
	}
	
}