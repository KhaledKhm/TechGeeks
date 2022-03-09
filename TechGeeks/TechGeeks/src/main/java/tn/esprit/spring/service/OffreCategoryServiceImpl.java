package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.OffreCategory;
import tn.esprit.spring.repository.OffreCategoryRepository;
import tn.esprit.spring.repository.OffreRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class OffreCategoryServiceImpl implements IOffreCategoryService  {
	
	@Autowired
	OffreCategoryRepository offreCategoryRepository; 
	@Autowired
	OffreRepository offreRepository; 
	@Override
	public List<OffreCategory> retrieveAllOffresCategory() {
		List<OffreCategory> categoryList =  offreCategoryRepository.findAll();
		for (OffreCategory category : categoryList){
			log.info(" Category : " +category);
		}
		return categoryList;
	}

	@Override
	public OffreCategory addOffreCategory(OffreCategory cat ) {
		offreCategoryRepository.save(cat);
		return cat;
	}

	@Override
	public OffreCategory updateOffreCategory(OffreCategory cat) {
		offreCategoryRepository.save(cat);
		return cat;
	}

	@Override
	public OffreCategory retrieveOffreCategory(int id) {
		return offreCategoryRepository.findById(id).orElse(null);
	}

	@Override
	public void deleteOffreCategory(int id) {
		offreCategoryRepository.deleteById(id);
	}

}
