package tn.esprit.spring.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

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
	public Document addDocumentByTraining(int idTraining,String description, MultipartFile file){
		Training t = trainingRepository.findById(idTraining).orElse(null);
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		try {	
			
			Document document = new Document (fileName,file.getContentType(),file.getBytes());
			document.setTraining(t);
			document.setDescription(description);
			
			return documentRepository.save(document);
		}catch (IOException e) {
			return null ;
		}	
	}
	
	@Override
	public Document updateDocument(Document document) {
		Document d = documentRepository.findById(document.getIdDocument()).orElse(null);
			d.setDescription(document.getDescription());
			d.setFileName(document.getFileName());
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
