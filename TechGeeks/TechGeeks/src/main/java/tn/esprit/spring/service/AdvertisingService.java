package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Advertising;
import tn.esprit.spring.repository.AdvertisingRepository;

@Service
public class AdvertisingService implements IAdvertisingService{
	@Autowired 
	AdvertisingRepository advertisingRepository;
	
	@Override
	public Advertising AjoutAdvertising(Advertising a) {
		
		return advertisingRepository.save(a);
	}

	@Override
	public void SupprimerAdvertising(int Id) {
		// TODO Auto-generated method stub
		advertisingRepository.deleteById(Id);
	}

	@Override
	public Advertising AdvertisingById(int id) {
		// TODO Auto-generated method stub
		return advertisingRepository.findById(id).orElse(null);
	}

	@Override
	public List<Advertising> AdvertisingGetAll() {
		// TODO Auto-generated method stub
		return advertisingRepository.findAll();
	}

	@Override
	public void AdvertisingModifier(Advertising a, int id) {
		// TODO Auto-generated method stub
		advertisingRepository.save(a);
	}

}
