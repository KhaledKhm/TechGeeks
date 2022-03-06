package tn.esprit.spring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
	
	@PostMapping("/addTrainingByTrainer/{idUser}/{idSector}")
	@ResponseBody
	public void addTrainingByTrainer(@RequestBody Training training,@PathVariable("idUser") int idUser,@PathVariable("idSector") int idSector) {
		trainingService.addTrainingByTrainer(training, idUser, idSector);
	}
	
	@PostMapping("/addTrainingByAdmin/{idLocal}")
	@ResponseBody
	public void addTrainingByAdmin(@RequestBody Training training,@PathVariable("idLocal") int idLocal) {
		trainingService.addTrainingByAdmin(training, idLocal);
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
	
	@GetMapping("/getTrainingBySector/{nameSector}")
	@ResponseBody
	public List<Training> getTrainingBySector(@PathVariable("nameSector") String nameSector) {
		return trainingService.getTrainingBySector(nameSector);
	}
	
	@GetMapping("/sortAllTrainingDESC/{attribut}") 
	@ResponseBody
	public List<Training> sortAllTrainingDESC (@PathVariable("attribut")String attribut){
	    return trainingService.sortAllTrainingDESC(attribut);
	}
	
	@GetMapping("/sortAllTrainingASC/{attribut}") 
	@ResponseBody
	public List<Training> sortAllTrainingASC (@PathVariable("attribut")String attribut){
	    return trainingService.sortAllTrainingASC(attribut);
	}
	
	@GetMapping("/TrainingPagination/{offset}/{pagesize}")
	@ResponseBody
	public Page<Training> TrainingPagination(@PathVariable ("offset")int offset,@PathVariable("pagesize")int pagesize ){
	    return trainingService.TrainingPagination(offset, pagesize);
	}
	
	@PutMapping("/addComment/{idTraining}/{comment}")
	@ResponseBody
	public void addComment(@PathVariable("idTraining")int idTraining,@PathVariable("comment") String comment) {
		trainingService.addComment(idTraining,comment);
	}
	
	@PutMapping("/updateComment")
	@ResponseBody
	public void updateComment(@RequestBody Training training) {
		trainingService.updateComment(training);
	}
		               
}
