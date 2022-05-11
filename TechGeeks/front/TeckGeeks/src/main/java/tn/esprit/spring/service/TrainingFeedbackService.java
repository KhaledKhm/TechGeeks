package tn.esprit.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Training;
import tn.esprit.spring.entities.TrainingFeedback;
import tn.esprit.spring.repository.TrainingFeedbackRepository;
import tn.esprit.spring.repository.TrainingRepository;

@Service
public class TrainingFeedbackService implements ITrainingFeedback{
	
	@Autowired
	TrainingFeedbackRepository trainingFeedbackRepository; 
	@Autowired
	TrainingRepository trainingRepository; 

	@Override
	public void addComment(TrainingFeedback tfeedback,int idTraining) {
		Training t = trainingRepository.findById(idTraining).get();
		tfeedback.setTraining(t);
		trainingFeedbackRepository.save(tfeedback);
	}

	public TrainingFeedback updateComment(TrainingFeedback feedback) {
		TrainingFeedback t = trainingFeedbackRepository.findById(feedback.getIdTrainingFeedback()).orElse(null);
		t.setFeedback(feedback.getFeedback());
		return trainingFeedbackRepository.save(t);
	}

	@Override
	public void deleteAllFeedback() {
		trainingFeedbackRepository.deleteAll();
		
	}

	@Override
	public void deleteFeedbackById(int idFeedback) {
		trainingFeedbackRepository.deleteById(idFeedback);
		
	}

}
