package tn.esprit.spring.service;

import tn.esprit.spring.entities.Advertising;

import java.util.List;
public interface IAdvertisingService {

	public Advertising AjoutAdvertising(Advertising a);
	public void SupprimerAdvertising(int Id);
	public Advertising AdvertisingById(int id);
	public List<Advertising> AdvertisingGetAll();
	public void AdvertisingModifier(Advertising a, int id);
	
	public void AdvertisingDeleteDateFin();
	
	String AjoutVusAdvertising(Advertising ad, int idADs);

}
