package tn.esprit.spring.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
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

	@Override
	@Scheduled(cron = "* * * 1 * *")
	public void monthlyPotSum() {
		for (Pot pot:retrieveAllPots()){
			log.info("Pot " 
					+ pot.getLibelle() 
					+ " with the id " 
					+ pot.getIdPot() 
					+ " has a sum of " 
					+ pot.getSum()
					);
		}
		
	}

	@Override
	@Transactional
	public void takeMoney(int idPot, float money) {
		if(money <=0){
			System.out.println("You cant delete money equals or less than 0");
			return;
		}else{
			Pot p=retrievePot(idPot);
			float sum;
			sum=p.getSum();
			sum-=money;
			p.setSum(sum);
			System.out.println("Money taken from "+p.getIdPot()+"-"+p.getLibelle()+": "+money+" new sum: "+p.getSum());
			potRepository.save(p);
		}
		
		
	}

}
