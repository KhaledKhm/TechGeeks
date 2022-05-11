package tn.esprit.spring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Answer;
import tn.esprit.spring.entities.Certificate;
import tn.esprit.spring.entities.Question;
import tn.esprit.spring.entities.Quiz;
import tn.esprit.spring.entities.Training;
import tn.esprit.spring.repository.AnswerRepository;
import tn.esprit.spring.repository.QuestionRepository;
import tn.esprit.spring.repository.QuizRepository;
import tn.esprit.spring.service.IQuizService;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class QuizController {
	@Autowired
	IQuizService quizService;

	
	@PostMapping("/addQuiz")
	@ResponseBody
	public void addQuiz(@RequestBody Quiz quiz) {
		quizService.addQuiz(quiz);
	}
	
	
	@PostMapping("/AffecterCertificate/{idQuiz}/{idTraining}")
	@ResponseBody
	public List<Certificate> AffecterCertificate(@RequestBody Quiz quiz,@PathVariable("idQuiz") int idQuiz,@PathVariable("idTraining") int idTraining) {
		return quizService.AffecterCertificate(idQuiz,idTraining);
	}
	
	
	@PostMapping("/addQuizByTraining/{idTraining}")
	@ResponseBody
	public void addQuizByTraining(@RequestBody Quiz quiz, @PathVariable("idTraining") int idTraining) {
		quizService.addQuizByTraining(quiz,idTraining);
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
	

	@GetMapping("/getQuizByTraining/{idTraining}")
	@ResponseBody
	public Quiz getQuizByTraining(@PathVariable("idTraining") int idTraining){
		return quizService.getQuizByTraining(idTraining);
	}

}
