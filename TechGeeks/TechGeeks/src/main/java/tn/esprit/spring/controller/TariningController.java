package tn.esprit.spring.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Certificate;
import tn.esprit.spring.entities.Local;
import tn.esprit.spring.entities.Training;
import tn.esprit.spring.service.ITrainingService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class TariningController {
	@Autowired
	ITrainingService trainingService;

	@PostMapping("/addTrainingByTrainer/{idUser}/{idSector}")
	@ResponseBody
	public void addTrainingByTrainer(@RequestBody Training training, @PathVariable("idUser") int idUser,
			@PathVariable("idSector") int idSector) {
		trainingService.addTrainingByTrainer(training, idUser, idSector);
	}

	@PutMapping("/updateStatus/{idTraining}/")
	@ResponseBody
	public Training updateStatus(@RequestBody Training training, @PathVariable("idTraining") int idTraining) {
		return trainingService.updateStatus(training, idTraining);
	}

	@PostMapping("/addTrainingByWomen/{idTraining}/{idUser}")
	@ResponseBody
	public String addTrainingByWomen(@RequestBody Certificate c, @PathVariable("idTraining") int idTraining,
			@PathVariable("idUser") int idUser) {
		return trainingService.addTrainingByWomen(c, idTraining, idUser);
	}

	@PostMapping("/addTrainingByTrainer2/{idUser}/{idSector}/{dateStart}/{dateEnd}")
	@ResponseBody
	public String addTrainingByTrainer2(@RequestBody Training training, @PathVariable("idUser") int idUser,
			@PathVariable("idSector") int idSector, @PathVariable("dateStart") String dateStart,
			@PathVariable("dateEnd") String dateEnd) {
		try {
			Date date1 = new SimpleDateFormat("yyyy-MM-dd").parse(dateStart);
			java.sql.Date dateDebut = new java.sql.Date(date1.getTime());
			Date date2 = new SimpleDateFormat("yyyy-MM-dd").parse(dateEnd);
			java.sql.Date dateFin = new java.sql.Date(date2.getTime());
			return trainingService.addTrainingByTrainer2(training, idUser, idSector, dateDebut, dateFin);
		} catch (ParseException e) {
			return null;
		}
	}

	@PostMapping("/addTrainingByAdmin/{idLocal}/{idTraining}")
	@ResponseBody
	public void addTrainingByAdmin(@RequestBody Training training, @PathVariable("idLocal") int idLocal,
			@PathVariable("idTraining") int idTraining) {
		trainingService.addTrainingByAdmin(training, idLocal, idTraining);
	}

	@PutMapping("/updateTraining/{idTraining}")
	@ResponseBody
	public void updateTraining(@RequestBody Training training,@PathVariable("idTraining") int idTraining) {
		trainingService.updateTraining(training, idTraining);
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
	public List<Training> getAllTrainings() {
		return trainingService.getAllTrainings();
	}

	@GetMapping("/getAllLocal/{dateStart}/{dateEnd}")
	@ResponseBody
	public List<Local> getAllLocal(@PathVariable("dateStart") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateStart,
			@PathVariable("dateEnd") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateEnd) {

		return trainingService.getAllLocal(dateStart, dateEnd);

	}

	@GetMapping("/getTrainingById/{idTraining}")
	@ResponseBody
	public Optional<Training> getTrainingById(@PathVariable("idTraining") int idTraining) {
		return trainingService.getTrainingById(idTraining);
	}

	@GetMapping("/getTrainingBySector/{name}")
	@ResponseBody
	public List<Training> getTrainingBySector(@PathVariable("name") String nameSector) {
		return trainingService.getTrainingBySector(nameSector);
	}

	@GetMapping("/getTrainingByUser/{id}")
	@ResponseBody
	public List<Training> getTrainingByUser(@PathVariable("id") int idUser) {
		return trainingService.getTrainingByUser(idUser);
	}
	
	@GetMapping("/getTrainingByUserStatus/{idUser}")
	@ResponseBody
	public List<Training> getTrainingByUserStatus(@PathVariable("idUser") int idUser) {
		return trainingService.getTrainingByUserStatus(idUser);
	}
	
	@GetMapping("/sortAllTrainingDESC/{attribut}")
	@ResponseBody
	public List<Training> sortAllTrainingDESC(@PathVariable("attribut") String attribut) {
		return trainingService.sortAllTrainingDESC(attribut);
	}

	@GetMapping("/sortAllTrainingASC/{attribut}")
	@ResponseBody
	public List<Training> sortAllTrainingASC(@PathVariable("attribut") String attribut) {
		return trainingService.sortAllTrainingASC(attribut);
	}

	@GetMapping("/TrainingPagination/{offset}/{pagesize}")
	@ResponseBody
	public Page<Training> TrainingPagination(@PathVariable("offset") int offset,
			@PathVariable("pagesize") int pagesize) {
		return trainingService.TrainingPagination(offset, pagesize);
	}

}
