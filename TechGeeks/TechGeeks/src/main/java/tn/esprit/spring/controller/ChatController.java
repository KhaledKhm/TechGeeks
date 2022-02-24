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

import tn.esprit.spring.entities.Chat;
import tn.esprit.spring.service.IChatService;

@RestController
@RequestMapping("/Chat")
public class ChatController {

	@Autowired
	IChatService chatservice;
	
	@PostMapping("/AjoutChat")
	public String AjoutChat(@RequestBody List<Chat> c) {
		chatservice.AjoutChat((Chat) c);
		return "chat Ajouter";
	}
	@DeleteMapping("/SupprimerChat/{id}")
	public void SupprimerChat(@PathVariable int id) {
		chatservice.SupprimerChat(id);
	}
	@GetMapping("/getByid/{id}")
	public Chat ChatById(@PathVariable int id) {
		return chatservice.ChatById(id);
	}
	@GetMapping("/getAll")
	public List<Chat> ChatGetAll(){
		return chatservice.ChatGetAll();
	}
	@PutMapping("/ModifierChat/{id}")
	public void ChatModifier(@RequestBody Chat a,@PathVariable int id) {
		Chat chat=chatservice.ChatById(id);
		chat.setReceivers(a.getReceivers());
		chat.setSender(a.getSender());
		chat.setText(a.getText());
		chatservice.ChatModifier(chat, id);
	}
}
