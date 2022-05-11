package tn.esprit.spring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import tn.esprit.spring.entities.Document;
import tn.esprit.spring.service.IDocumentService;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class DocumentController {
	@Autowired
	IDocumentService documentService;
	

	@PostMapping("/addDocument")
	@ResponseBody
	public void addDocument(@RequestBody Document document) {
		documentService.addDocument(document);
	}
	
	@PostMapping("/addDocument/{idTraining}/{description}")
	@ResponseBody
	public String addDocument(@PathVariable("idTraining") int idTraining,@PathVariable("description") String description,@RequestParam("files") MultipartFile[] files) {
		for (MultipartFile file : files){
			documentService.addDocumentByTraining(idTraining,description,file);
		}
		return null ;
	}
	
	@PutMapping("/updateDocument")
	@ResponseBody
	public void updateDocument(@RequestBody Document document ) {
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
	
	@GetMapping("/downloadFile/{fileId}")
	public ResponseEntity<ByteArrayResource>downLoadSingleFile(@PathVariable Integer fileId){
		  // Load File as Resource
		Document document = documentService.getDocumentById(fileId).get();

				return ResponseEntity.ok()
						.contentType(MediaType.parseMediaType(document.getContentType()))
						.header(HttpHeaders.CONTENT_DISPOSITION, "attachement; filename=\""+document.getFileName()+"\"")
						.body(new ByteArrayResource(document.getData()));
	}
	
}
