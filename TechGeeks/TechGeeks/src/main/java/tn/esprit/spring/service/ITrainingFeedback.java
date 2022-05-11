package tn.esprit.spring.service;


import tn.esprit.spring.entities.TrainingFeedback;

public interface ITrainingFeedback {
	
	
	public void addComment(TrainingFeedback tfeedback, int idTraining);
	public TrainingFeedback updateComment(TrainingFeedback feedback);
	public void deleteAllFeedback();
	public void deleteFeedbackById(int idFeedback);
}
