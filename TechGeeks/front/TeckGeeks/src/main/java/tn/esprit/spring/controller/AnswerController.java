package tn.esprit.spring.controller;

import java.util.List;
import java.util.Optional;
import java.util.Set;

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
import tn.esprit.spring.entities.Question;
import tn.esprit.spring.service.IAnswerService;
import tn.esprit.spring.service.IQuestionService;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class AnswerController {
	@Autowired
	IAnswerService answerService;
	
	@Autowired
	IQuestionService questionService ;
	
	@PostMapping("/addAnswer")
	@ResponseBody
	public void addAnswer(@RequestBody Answer answer) {
		answerService.addAnswer(answer);
	}
	

	@PostMapping("/addAnswerByQuestion/{question}")
	@ResponseBody
	public void addAnswerByQuestion(@RequestBody Answer answer, @PathVariable("question") Question question) {
		answerService.addAnswerByQuestion(answer,question);
	}
	
	@PutMapping("/updateAnswer")
	@ResponseBody
	public void updateAnswer(@RequestBody Answer answer) {
		answerService.updateAnswer(answer);
	}
	
	@DeleteMapping("/deleteAllAnswers")
	@ResponseBody
	public void deleteAllAnswers() {
		answerService.deleteAllAnswers();
	}
	
	@DeleteMapping("/deleteAnswerByAnswer/{answer}")
	@ResponseBody
	public Answer deleteAnswerByAnswer(@PathVariable("answer") String answer) {
		return answerService.deleteAnswerByAnswer(answer);
	}
	
	@DeleteMapping("/deleteAnswerById/{idAnswer}")
	@ResponseBody
	public void deleteAnswerById(@PathVariable("idAnswer") int idAnswer) {
		answerService.deleteAnswerById(idAnswer);
	}
	
	@GetMapping("/getAllAnswers")
	@ResponseBody
	public List <Answer> getAllAnswers() {
		return answerService.getAllAnswers();
	}
	
	@GetMapping("/getAnswerByAnswer/{answer}")
	@ResponseBody
	public Optional <Answer> getAnswerByAnswer(@PathVariable("answer") String answer) {
		return answerService.getAnswerByAnswer(answer);
	}
	
	@GetMapping("/getAnswerById/{idAnswer}")
	@ResponseBody
	public Optional <Answer> getAnswerById(@PathVariable("idAnswer") int idAnswer) {
		return answerService.getAnswerById(idAnswer);
	}
	
	@PostMapping("/addAnswersByQuestion/{question}")
	@ResponseBody
	public void addAnswersByQuestion(@RequestBody Set<Answer> answers, @PathVariable("idQuestion") Question question) {
		answerService.addAnswersByQuestion(answers,question);
	}
	
}
