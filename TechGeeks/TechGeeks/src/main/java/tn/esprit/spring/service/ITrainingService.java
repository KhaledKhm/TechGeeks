package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import tn.esprit.spring.entities.Training;

public interface ITrainingService {
	public void addTraining(Training training,int idSector, int idLocal);
	public Training updateTraining(Training training);
	public void deleteAllTrainings();
	public void deleteTrainingById(int idTraining);
	public List<Training> getAllTrainings();
	public Optional<Training> getTrainingById(int idTraining);
	public List<Training> sortAllTrainingDESC(String attribut);
	public List<Training> sortAllTrainingASC(String attribut);
	public Page<Training> TrainingPagination(int offset, int pagesize );
	
}