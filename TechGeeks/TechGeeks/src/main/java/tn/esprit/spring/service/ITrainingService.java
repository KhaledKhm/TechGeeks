package tn.esprit.spring.service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import tn.esprit.spring.entities.Training;

public interface ITrainingService {
	public void addTrainingByAdmin(Training training,int idLocal);
	public Training updateTraining(Training training);
	public void deleteAllTrainings();
	public void deleteTrainingById(int idTraining);
	public List<Training> getAllTrainings();
	public Optional<Training> getTrainingById(int idTraining);
	public List<Training> getTrainingBySector(String nameSector);
	public List<Training> sortAllTrainingDESC(String attribut);
	public List<Training> sortAllTrainingASC(String attribut);
	public Page<Training> TrainingPagination(int offset, int pagesize );
	public void addComment(int idTraining, String comment);
	public Training updateComment(Training training);
	public void addTrainingByTrainer(Training training, int idUser, int idSector);
	public String addTrainingByTrainer2(Training training, int idUser, int idSector, Date dateStart, Date dateEnd);
}