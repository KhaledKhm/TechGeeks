//package tn.esprit.spring.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import tn.esprit.spring.entities.CommentLike;
//import tn.esprit.spring.service.ICommentLikeService;
//@RestController
//@RequestMapping("/CommentLike")
//public class CommentLikeController {
//
//	@Autowired 
//	ICommentLikeService cs;
//	
//	@PostMapping("/AjoutCommentLike")
//	public CommentLike AjoutCommentLike(@RequestBody List<CommentLike> c) {
//		return cs.AjoutCommentLike((CommentLike) c);
//	}
//	
//	@DeleteMapping("/supprimer/{id}")
//	public void SupprimerCommentLike(@PathVariable int Id) {
//		cs.SupprimerCommentLike(Id);
//	}
//	
//	@GetMapping("/getById")
//	public CommentLike CommentLikeById(@PathVariable int id) {
//		return cs.CommentLikeById(id);
//	}
//	@GetMapping("/getAll")
//	public List<CommentLike> CommentLikeGetAll(){
//		return cs.CommentLikeGetAll();
//	}
//	@PutMapping("/modifier/{id}")
//	public void CommentLikeModifier(@RequestBody CommentLike a,@PathVariable int id) {
//		CommentLike cl=cs.CommentLikeById(id);
//		cl.setPostComment(a.getPostComment());
//		cs.CommentLikeModifier(cl, id);
//	}
//}
