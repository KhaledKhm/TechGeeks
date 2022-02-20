package tn.esprit.spring.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entities.Event;
import tn.esprit.spring.entities.Local;
import tn.esprit.spring.repository.LocalRepository;

@Service
@Slf4j
public class LocalServiceImpl implements ILocalService{

	public LocalServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	@Autowired
	LocalRepository localRepository;

	@Override
	public Set<Local> retrieveAllLocals() {
		Set<Local> localList = (Set<Local>) localRepository.findAll();
		for (Local local : localList){
			log.info(" Local: " +local);
		}
		return localList;
	}

	@Override
	public Local addLocal(Local l) {
		localRepository.save(l);
		return l;
	}

	@Override
	public Local updateLocal(Local l) {
		localRepository.save(l);
		return l;
	}

	@Override
	public Local retrieveLocal(int id) {
		return localRepository.findById(id).orElse(null);
	}

	@Override
	public void deleteLocal(int id) {
		localRepository.deleteById(id);
	}

}
