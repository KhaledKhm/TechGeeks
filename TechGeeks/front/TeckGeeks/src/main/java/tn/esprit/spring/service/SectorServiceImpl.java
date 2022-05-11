package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Sector;
import tn.esprit.spring.entities.Training;
import tn.esprit.spring.repository.SectorRepository;

@Service
public class SectorServiceImpl implements ISectorService {
	
	@Autowired
	SectorRepository sectorRepository ;
	
	@Override
	public void addSector(Sector sector) {
		sectorRepository.save(sector);
		
	}

	@Override
	public Sector updateSector(Sector sector) {
		Sector s = sectorRepository.findById(sector.getIdSector()).orElse(null);
		s.setName(sector.getName());
		return sectorRepository.save(s);
		
	}

	@Override
	public void deleteAllSectors() {
		sectorRepository.deleteAll();
		
	}

	@Override
	public List<Sector> getAllSectors() {
		return sectorRepository.findAll();
	}

	@Override
	public Optional<Sector> getSectorById(int idSector) {
		return sectorRepository.findById(idSector);
		
	}

	@Override
	public Optional<Sector> getSectorByName(String name) {
		return sectorRepository.findByName(name);
		
	}

	@Override
	public Sector deleteSectorByName(String name) {
		return sectorRepository.deleteByName(name);
		
	}

	@Override
	public void deleteSectorById(int idSector) {
		sectorRepository.deleteById(idSector);
		
	}
	@Override
	public Sector updateSectorName(Sector sector, int idSector) {
		Sector s = sectorRepository.findById(idSector).get();
		s.setName(sector.getName());
		return sectorRepository.save(s);
	}

}
