package tn.esprit.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Training;
import tn.esprit.spring.entities.TrainingFeedback;
import tn.esprit.spring.service.ITrainingFeedback;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class TrainingFeedbackController {
	
	@Autowired
	ITrainingFeedback trainingFeedbackService;
	
	@PostMapping("/addComemnt/{idTraining}/")
	@ResponseBody
	public void addComemnt(@RequestBody TrainingFeedback trainingFeedback,@PathVariable("idTraining") int idTraining) {
		trainingFeedbackService.addComment(trainingFeedback, idTraining);
	}
	
	@PutMapping("/updateComment")
	@ResponseBody
	public void updateComment(@RequestBody TrainingFeedback trainingFeedback) {
		trainingFeedbackService.updateComment(trainingFeedback);
	}
	
	@DeleteMapping("/deleteAllComments")
	@ResponseBody
	public void deleteAllComments() {
		trainingFeedbackService.deleteAllFeedback();;
	}
	
	@DeleteMapping("/deleteCommentByID/{idFeedback}")
	@ResponseBody
	public void deleteCommentByID(@PathVariable("idFeedback") int idFeedback) {
		trainingFeedbackService.deleteFeedbackById(idFeedback);
	}

}
