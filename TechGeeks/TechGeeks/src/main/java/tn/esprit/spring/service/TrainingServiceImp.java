package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Sector;
import tn.esprit.spring.entities.Training;
import tn.esprit.spring.entities.Local;
import tn.esprit.spring.repository.LocalRepository;
import tn.esprit.spring.repository.TrainingRepository;
import tn.esprit.spring.repository.SectorRepository;

@Service
public class TrainingServiceImp implements ITrainingService{
	@Autowired
	TrainingRepository trainingRepository ;
	@Autowired
	LocalRepository localRepository ;
	@Autowired
	SectorRepository sectorRepository ;
	
	@Override
	public void addTraining(Training training, int idSector, int idLocal) {
		Local l = localRepository.findById(idLocal).orElse(null);
		Sector s = sectorRepository.findById(idSector).orElse(null);
		training.setLocal(l);
		training.setSector(s);
		trainingRepository.save(training);	
	}

	@Override
	public Training updateTraining(Training training) {
		Training t = trainingRepository.findById(training.getIdTraining()).orElse(null);
		t.setDescription(training.getDescription());
		t.setDateStart(training.getDateStart());
		t.setDateEnd(training.getDateEnd());
		t.setStatus(training.getStatus());
		t.setFeedback(training.getFeedback());
		return trainingRepository.save(t);
	}

	@Override
	public void deleteAllTrainings() {
		trainingRepository.deleteAll();
	}

	@Override
	public void deleteTrainingById(int idTraining) {
		trainingRepository.deleteById(idTraining);
		
	}

	@Override
	public List<Training> getAllTrainings() {
		return trainingRepository.findAll();
	}

	@Override
	public Optional<Training> getTrainingById(int idTraining) {
		return trainingRepository.findById(idTraining);
	}

}
