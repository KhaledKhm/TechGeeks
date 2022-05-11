package tn.esprit.spring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import tn.esprit.spring.entities.Sector;
import tn.esprit.spring.entities.Training;
import tn.esprit.spring.service.ISectorService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class SectorController {
	
	@Autowired
	ISectorService sectorService;
	
	@PostMapping("/addSector")
	@ResponseBody
	public void addSector(@RequestBody Sector sector) {
		sectorService.addSector(sector);
	}
	
	@PutMapping("/updateSector")
	@ResponseBody
	public void updateSector(@RequestBody Sector sector) {
		sectorService.updateSector(sector);
	}
	
	@PutMapping("/updateSector/{idSector}/")
	@ResponseBody
	public Sector updateSectorName(@RequestBody Sector sector,@PathVariable("idSector") int idSector) {
		return sectorService.updateSectorName(sector,idSector);
	}
	
	@DeleteMapping("/deleteAllSectors")
	@ResponseBody
	public void deleteAllSectors() {
		sectorService.deleteAllSectors();
	}
	
	@DeleteMapping("/deleteSectorByName/{name}")
	@ResponseBody
	public Sector deleteSectorByName(@PathVariable("name") String name) {
		return sectorService.deleteSectorByName(name);
	}
	
	@DeleteMapping("/deleteSectorById/{idSector}")
	@ResponseBody
	public void deleteSectorById(@PathVariable("idSector") int idSector) {
		sectorService.deleteSectorById(idSector);
	}
	
	@GetMapping("/getAllSectors")
	@ResponseBody
	public List <Sector> getAllSector() {
		return sectorService.getAllSectors();
	}
	
	@GetMapping("/getSectorByName/{name}")
	@ResponseBody
	public Optional <Sector> getSectorByName(@PathVariable("name") String name) {
		return sectorService.getSectorByName(name);
	}
	
	@GetMapping("/getSectorById/{idSector}")
	@ResponseBody
	public Optional <Sector> getSectorById(@PathVariable("idSector") int idSector) {
		return sectorService.getSectorById(idSector);
	}
	
	
}
