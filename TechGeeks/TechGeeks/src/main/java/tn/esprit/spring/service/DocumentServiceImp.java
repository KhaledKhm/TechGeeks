package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Document;
import tn.esprit.spring.entities.Training;
import tn.esprit.spring.repository.DocumentRepository;
import tn.esprit.spring.repository.TrainingRepository;

@Service
public class DocumentServiceImp implements IDocumentService{
	
	@Autowired
	DocumentRepository 	documentRepository ;
	@Autowired
	TrainingRepository trainingRepository ;
	
	@Override
	public void addDocument(Document document){
		documentRepository.save(document);	
	}
	
	@Override
	public void addDocumentByTraining(Document document,int idTraining){
		Training t = trainingRepository.findById(idTraining).orElse(null);
		document.setTraining(t);
		documentRepository.save(document);	
	}
	
	@Override
	public Document updateDocument(Document document) {
		Document d = documentRepository.findById(document.getIdDocument()).orElse(null);
		d.setDescription(document.getDescription());
		d.setDocument(document.getDocument());
		return documentRepository.save(d);
	}
	

	@Override
	public void deleteAllDocuments() {
		documentRepository.deleteAll();
		
	}

	@Override
	public void deleteDocumentById(int idDocument) {
		documentRepository.deleteById(idDocument);
		
	}

	@Override
	public List<Document> getAllDocuments() {
		return documentRepository.findAll();
	}

	@Override
	public Optional<Document> getDocumentById(int idDocument) {
		return documentRepository.findById(idDocument);
	}
	

}
