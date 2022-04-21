package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Chat;
import tn.esprit.spring.repository.ChatRepository;

@Service
public class ChatService implements IChatService{

	@Autowired
	ChatRepository chatRepository;
	@Override
	public Chat AjoutChat(Chat c) {
		// TODO Auto-generated method stub
		return chatRepository.save(c);
	}

	@Override
	public void SupprimerChat(int Id) {
		// TODO Auto-generated method stub
		chatRepository.deleteById(Id);
	}

	@Override
	public Chat ChatById(int id) {
		// TODO Auto-generated method stub
		return chatRepository.findById(id).orElse(null);
	}

	@Override
	public List<Chat> ChatGetAll() {
		// TODO Auto-generated method stub
		return chatRepository.findAll();
	}

	@Override
	public void ChatModifier(Chat c, int id) {
		// TODO Auto-generated method stub
		chatRepository.save(c);
	}

}
