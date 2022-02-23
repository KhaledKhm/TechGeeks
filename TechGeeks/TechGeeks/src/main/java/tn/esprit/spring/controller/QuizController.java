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

import tn.esprit.spring.entities.Quiz;
import tn.esprit.spring.service.IQuizService;

@RestController
public class QuizController {
	@Autowired
	IQuizService quizService;
	
	@PostMapping("/addQuiz")
	@ResponseBody
	public void addQuiz(@RequestBody Quiz quiz) {
		quizService.addQuiz(quiz);
	}
	
	@PostMapping("/addQuizByCertificate/{idCertificate}")
	@ResponseBody
	public void addQuizByCertificate(@RequestBody Quiz quiz, @PathVariable("idCertificate") int idCertificate) {
		quizService.addQuizByCertificate(quiz,idCertificate);
	}
	
	@PutMapping("/updateQuiz")
	@ResponseBody
	public void updateQuiz(@RequestBody Quiz quiz) {
		quizService.updateQuiz(quiz);
	}
	
	@DeleteMapping("/deleteAllQuizs")
	@ResponseBody
	public void deleteAllQuizs() {
		quizService.deleteAllQuizs();
	}
	
	@DeleteMapping("/deleteQuizById/{idQuiz}")
	@ResponseBody
	public void deleteQuizById(@PathVariable("idQuiz") int idQuiz) {
		quizService.deleteQuizById(idQuiz);
	}
	
	@GetMapping("/getAllQuizs")
	@ResponseBody
	public List <Quiz> getAllQuizs() {
		return quizService.getAllQuizs();
	}
	
	
	@GetMapping("/getQuizById/{idQuiz}")
	@ResponseBody
	public Optional <Quiz> getQuizById(@PathVariable("idQuiz") int idQuiz) {
		return quizService.getQuizById(idQuiz);
	}

}
