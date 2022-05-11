package tn.esprit.spring.service;

import java.util.List;
import java.util.Optional;

import tn.esprit.spring.entities.Sector;

public interface ISectorService {
	public void addSector(Sector sector);
	public Sector updateSector(Sector sector);
	public Sector updateSectorName(Sector sector, int idSector);
	public void deleteAllSectors();
	public Sector deleteSectorByName(String name);
	public void deleteSectorById(int idSector);
	public List<Sector> getAllSectors();
	public Optional<Sector> getSectorById(int idSector);
	public Optional <Sector> getSectorByName(String name);
}
