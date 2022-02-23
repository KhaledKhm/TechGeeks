package tn.esprit.spring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Document;
import tn.esprit.spring.service.IDocumentService;

@RestController
public class DocumentController {
	@Autowired
	IDocumentService documentService;
	

	@PostMapping("/addDocument")
	@ResponseBody
	public void addDocument(@RequestBody Document document) {
		documentService.addDocument(document);
	}
	
	@PostMapping("/addDocument/{idTraining}")
	@ResponseBody
	public void addDocument(@RequestBody Document document,@PathVariable("idTraining") int idTraining) {
		documentService.addDocumentByTraining(document,idTraining);
	}
	
	@PutMapping("/updateDocument")
	@ResponseBody
	public void updateDocument(@RequestBody Document document) {
		documentService.updateDocument(document);
	}
	
	@PutMapping("/updateDocumentByTraining")
	@ResponseBody
	public void updateDocumentByTraining(@RequestBody Document document) {
		documentService.updateDocument(document);
	}
	
	@DeleteMapping("/deleteAllDocuments")
	@ResponseBody
	public void deleteAllDocuments() {
		documentService.deleteAllDocuments();
	}
	
	@DeleteMapping("/deleteDocumentById/{idDocument}")
	@ResponseBody
	public void deleteDocumentById(@PathVariable("idDocument") int idDocument) {
		documentService.deleteDocumentById(idDocument);
	}
	
	@GetMapping("/getAllDocuments")
	@ResponseBody
	public List <Document> getAllDocuments() {
		return documentService.getAllDocuments();
	}
	
	
	@GetMapping("/getDocumentById/{idDocument}")
	@ResponseBody
	public Optional <Document> getDocumentById(@PathVariable("idDocument") int idDocument) {
		return documentService.getDocumentById(idDocument);
	}
	
	
}
