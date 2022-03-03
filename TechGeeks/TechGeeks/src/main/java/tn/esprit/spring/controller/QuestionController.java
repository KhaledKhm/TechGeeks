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

import tn.esprit.spring.entities.Answer;
import tn.esprit.spring.entities.Question;
import tn.esprit.spring.repository.AnswerRepository;
import tn.esprit.spring.repository.QuestionRepository;
import tn.esprit.spring.service.IAnswerService;
import tn.esprit.spring.service.IQuestionService;

@RestController
public class QuestionController {
	@Autowired
	IQuestionService questionService;
	@Autowired
	IAnswerService answerService;
	@Autowired
	AnswerRepository answerRepo;
	@Autowired
	QuestionRepository questionRepo;
	
	@PostMapping("/addQuestion")
	@ResponseBody
	public void addQuestion(@RequestBody Question question) {
		questionService.addQuestion(question);
	}
	
	@PostMapping("/addQuestionByQuiz/{idQuiz}")
	@ResponseBody
	public void addQuestionByQuiz(@RequestBody Question question, @PathVariable("idQuiz") int idQuiz) {
		questionService.addQuestionByQuiz(question,idQuiz);
	}
	
	@PutMapping("/updateQuestion")
	@ResponseBody
	public void updateQuestion(@RequestBody Question question) {
		questionService.updateQuestion(question);
	}
	
	@DeleteMapping("/deleteAllQuestions")
	@ResponseBody
	public void deleteAllQuestions() {
		questionService.deleteAllQuestions();
	}
	
	/*@DeleteMapping("/deleteQuestionWithAnswer/{idQuestion}")
	@ResponseBody
	public void deleteQuestionWithAnswer(@PathVariable("idQuestion") int idQuestion) {
		questionService.deleteQuestionWithAnswer(idQuestion);
	}*/
	
	
	@DeleteMapping("/deleteQuestionById/{idQuestion}")
	@ResponseBody
	public void deleteQuestionById(@PathVariable("idQuestion") int idQuestion) {
		Question ques = questionRepo.findById(idQuestion).get();
		List<Answer> answers = answerRepo.findAll();
		answers.forEach(a->{
			if(ques.getIdQuestion() == a.getQuestion().getIdQuestion()){
				answerRepo.delete(a);
			}
		});
		questionRepo.deleteById(idQuestion);
	}
	
	@GetMapping("/getAllQuestions")
	@ResponseBody
	public List <Question> getAllQuestions() {
		return questionService.getAllQuestions();
	}
	
	
	@GetMapping("/getQuestionById/{idQuestion}")
	@ResponseBody
	public Optional <Question> getQuestionById(@PathVariable("idQuestion") int idQuestion) {
		return questionService.getQuestionById(idQuestion);
	}

}
