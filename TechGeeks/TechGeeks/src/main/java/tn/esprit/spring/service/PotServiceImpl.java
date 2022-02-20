package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entities.Pot;
import tn.esprit.spring.repository.PotRepository;

@Service
@Slf4j
public class PotServiceImpl implements IPotService{

	public PotServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Autowired
	PotRepository potRepository;
	
	@Override
	public List<Pot> retrieveAllPots() {
		List<Pot> potList =  potRepository.findAll();
		for (Pot pot : potList){
			log.info(" Pot: " +pot);
		}
		return potList;
	}

	@Override
	public Pot addPot(Pot p) {
		potRepository.save(p);
		return p;
	}

	@Override
	public Pot updatePot(Pot p) {
		potRepository.save(p);
		return p;
	}

	@Override
	public Pot retrievePot(int id) {
		return potRepository.findById(id).orElse(null);
	}

	@Override
	public void deletePot(int id) {
		potRepository.deleteById(id);	
	}

}
