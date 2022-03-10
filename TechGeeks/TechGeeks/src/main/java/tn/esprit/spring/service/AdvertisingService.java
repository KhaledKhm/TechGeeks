package tn.esprit.spring.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
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

	@Override
	@Scheduled(cron = "*/30 * * * * *")
	public void AdvertisingDeleteDateFin() {
		// TODO Auto-generated method stub
		List<Advertising> ads=advertisingRepository.findAll();

		Date localDateTime = new Date(System.currentTimeMillis());
		for(int i=0;i<ads.size();i++) {
			if(ads.get(i).getDateEnd().before(localDateTime))  {
				advertisingRepository.delete(ads.get(i));
			}else {
				System.out.println("rien a faire");
			}
		}
	}

	@Override
	public String AjoutVusAdvertising(int idADs) {
		// TODO Auto-generated method stub
//		Advertising ad=advertisingRepository.getById(idADs);
//		ads.setNumbervus(ad.getNumbervus());
//		if (ad.getIdAdvertising()==idADs) {
//			int nb=0;
//			ads.setNumbervus(nb+1);
//			advertisingRepository.save(ad);
//		}
//		return "vus dans post ajouter";
		
		int vus;
		Advertising ad=advertisingRepository.getById(idADs);
		vus=ad.getNumbervus();
		vus++;
		ad.setNumbervus(vus);
		advertisingRepository.save(ad);
		return "vus dans post ajouter";
	}

}
