package tn.esprit.spring.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import tn.esprit.spring.entities.Certificate;
import tn.esprit.spring.entities.Local;
import tn.esprit.spring.entities.Training;

public interface ITrainingService {
	
	public void addTrainingByAdmin(Training training,int idLocal,int idTarining);
	public void addTrainingByTrainer(Training training, int idUser, int idSector);
	public String addTrainingByTrainer2(Training training, int idUser, int idSector, Date dateStart, Date dateEnd);
	public String addTrainingByWomen(Certificate c ,int idTraining,int idUser);
	
	public Training updateTraining(Training training,int idTraining);
	
	public void deleteAllTrainings();
	public void deleteTrainingById(int idTraining);
	
	public List<Training> getAllTrainings();
	public Optional<Training> getTrainingById(int idTraining);
	public List<Training> getTrainingBySector(String nameSector);
	public List<Training> getTrainingByUser(int idUser);
	public List<Training> getTrainingByUserStatus(int idUser);
	
	public List<Training> sortAllTrainingDESC(String attribut);
	public List<Training> sortAllTrainingASC(String attribut);
	
	public Page<Training> TrainingPagination(int offset, int pagesize );
	
	public Training updateStatus(Training training , int idtraining);
	
	public List<Local> getAllLocal(Date dateStart, Date dateEnd );
}