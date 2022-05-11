package tn.esprit.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Certificate;
import tn.esprit.spring.entities.UserAnswer;
import tn.esprit.spring.service.IUserAnswerService;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UserAnswerController {
	
	@Autowired
	IUserAnswerService userAnswerService;
	
	@PostMapping("/addUserAnswer/{idQuestion}/{idAnswer}/{idCertificate}")
	@ResponseBody
	public void addUserAnswer(@RequestBody UserAnswer Uanswer, @PathVariable("idQuestion") int idQuestion,@PathVariable("idAnswer") int idAnswer,@PathVariable("idCertificate")int idCertificate) {
		userAnswerService.distributeMark(Uanswer, idQuestion, idAnswer,idCertificate);
	}
	
	@PutMapping("/QuizMark/{idQuiz}/{idCertificate}")
	@ResponseBody
	public void QuizMark(@RequestBody Certificate certificate,@PathVariable("idQuiz") int idQuiz,@PathVariable("idCertificate") int idCertificate) {
		userAnswerService.QuizMark(idQuiz,idCertificate);
	}
}
