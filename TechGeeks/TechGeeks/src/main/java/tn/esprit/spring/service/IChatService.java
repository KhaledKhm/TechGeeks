package tn.esprit.spring.service;

import java.util.List;

import tn.esprit.spring.entities.Chat;

public interface IChatService {
	public Chat AjoutChat(Chat c);
	public void SupprimerChat(int Id);
	public Chat ChatById(int id);
	public List<Chat> ChatGetAll();
	public void ChatModifier(Chat a, int id);
}
