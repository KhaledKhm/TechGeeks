package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;

import tn.esprit.spring.entities.Training;

public interface ITrainingService {
	public void addTraining(Training training,int idSector, int idLocal);
	public Training updateTraining(Training training);
	public void deleteAllTrainings();
	public void deleteTrainingById(int idTraining);
	public List<Training> getAllTrainings();
	public Optional<Training> getTrainingById(int idTraining);
}
