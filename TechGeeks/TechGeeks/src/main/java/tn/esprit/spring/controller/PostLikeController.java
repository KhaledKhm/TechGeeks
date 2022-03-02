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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.PostLike;
import tn.esprit.spring.service.IPostLikeService;

@RestController
@RequestMapping("/PostLike")
public class PostLikeController {
	@Autowired 
	IPostLikeService iPostLikeService;
	@Autowired 
	IPostLikeService pl;
	@PostMapping("/AjoueLike")
	public PostLike AjoutPostLike(@RequestBody PostLike p) {
		return iPostLikeService.AjoutPostLike( p);
	}
	@DeleteMapping("/SupprimerLike/{id}")
	public void SupprimerPostLike(@PathVariable int Id) {
		iPostLikeService.SupprimerPostLike(Id);
	}
	@GetMapping("/getById/{id}")
	public PostLike PostLikeById(@PathVariable int id) {
		return iPostLikeService.PostLikeById(id);
	}
	@GetMapping("/getAll")
	public List<PostLike> PostLikeGetAll(){
		return iPostLikeService.PostLikeGetAll();
	}
	@PutMapping("/Modifier/{id}")
	public void PostLikeModifier(@RequestBody PostLike a,@PathVariable int id) {
		PostLike pl=iPostLikeService.PostLikeById(id);
		a.setPost(pl.getPost());
		iPostLikeService.PostLikeModifier(pl, id);;
	}
	
	/*@PostMapping("/AjoutlikePost/{idPost}")
	@ResponseBody
	public void AjoutlikePost(@PathVariable("idPost") int idPost ,@RequestBody PostLike po ) {
		pl.AjoutLikeinpost(po, idPost);
	}*/
}
