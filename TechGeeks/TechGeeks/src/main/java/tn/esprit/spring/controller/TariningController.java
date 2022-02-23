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

import tn.esprit.spring.entities.Training;
import tn.esprit.spring.service.ITrainingService;

@RestController
public class TariningController {
	@Autowired
	ITrainingService trainingService;
	
	@PostMapping("/addTraining/{idSector}/{idLocal}")
	@ResponseBody
	public void addTraining(@RequestBody Training training,@PathVariable("idSector") int idSector,@PathVariable("idLocal") int idLocal) {
		trainingService.addTraining(training, idSector, idLocal);
	}
	
	@PutMapping("/updateTraining")
	@ResponseBody
	public void updateTraining(@RequestBody Training training) {
		trainingService.updateTraining(training);
	}
	
	@DeleteMapping("/deleteAllTrainings")
	@ResponseBody
	public void deleteAllTrainings() {
		trainingService.deleteAllTrainings();
	}
	
	@DeleteMapping("/deleteTrainingById/{idTraining}")
	@ResponseBody
	public void deleteTrainingById(@PathVariable("idTraining") int idTraining) {
		trainingService.deleteTrainingById(idTraining);
	}
	
	@GetMapping("/getAllTrainings")
	@ResponseBody
	public List <Training> getAllTrainings() {
		return trainingService.getAllTrainings();
	}
	
	
	@GetMapping("/getTrainingById/{idTraining}")
	@ResponseBody
	public Optional <Training> getTrainingById(@PathVariable("idTraining") int idTraining) {
		return trainingService.getTrainingById(idTraining);
	}

}
