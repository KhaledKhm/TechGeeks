package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import tn.esprit.spring.entities.Document;

public interface IDocumentService {
	public void addDocument(Document document);
	//public void addDocumentByTraining(Document document,int idTraining);
	public Document addDocumentByTraining(int idTraining,String description, MultipartFile file);
	public Document updateDocument(Document document);
	public void deleteAllDocuments();
	public void deleteDocumentById(int idDocument);
	public List<Document> getAllDocuments();
	public Optional<Document> getDocumentById(int idDocument);
	
}
