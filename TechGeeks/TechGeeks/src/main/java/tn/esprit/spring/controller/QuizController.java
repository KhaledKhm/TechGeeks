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
import tn.esprit.spring.entities.Certificate;
import tn.esprit.spring.entities.Question;
import tn.esprit.spring.entities.Quiz;
import tn.esprit.spring.repository.AnswerRepository;
import tn.esprit.spring.repository.QuestionRepository;
import tn.esprit.spring.repository.QuizRepository;
import tn.esprit.spring.service.IQuizService;

@RestController
public class QuizController {
	@Autowired
	IQuizService quizService;
	@Autowired
	QuizRepository quizRepo;
	@Autowired
	QuestionRepository questionRepo;
	@Autowired
	AnswerRepository answerRepo;
	
	
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
			Quiz quiz = quizRepo.findById(idQuiz).get();
			List<Question> questions = questionRepo.findAll();
			List<Answer> answers = answerRepo.findAll();
			questions.forEach(q->{
				if(quiz.getIdQuiz() == q.getQuiz().getIdQuiz()){
					answers.forEach(a->{
						if(q.getIdQuestion() == a.getQuestion().getIdQuestion()){
							answerRepo.delete(a);
						}
					});
					questionRepo.delete(q);
				}
			});
			quizRepo.deleteById(idQuiz);
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
