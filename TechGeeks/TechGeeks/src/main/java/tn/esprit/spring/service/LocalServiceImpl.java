package tn.esprit.spring.service;

import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entities.Event;
import tn.esprit.spring.entities.Local;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.repository.EventRepository;
import tn.esprit.spring.repository.LocalRepository;

@Service
@Slf4j
public class LocalServiceImpl implements ILocalService{

	public LocalServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	@Autowired
	LocalRepository localRepository;
	@Autowired
	EventRepository eventRepository;
	@Autowired
	IEventService eventService;
	@Autowired
	IUserService userService;

	@Override
	public List<Local> retrieveAllLocals() {
		List<Local> localList =  localRepository.findAll();
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

	@Override
	@Transactional
	public Local assignUserToLocal(int idLocal, int idUser, int idEvent) {
		Local l=retrieveLocal(idLocal);
//		l.setUsers(users);
//		l.setEvents(events);
		
		Set<Event> events =  l.getEvents();
		Set<User> users = l.getUsers();
		if (events.size() == 0){
			events.add(eventService.retrieveEvent(idEvent));
			l.setEvents(events);
		}else{
			for (int i = 0; i<events.size();i++){
				l.setEvents(events);
			}
		}
		if (users.size() == 0){
		users.add(userService.retrieveUser(idUser));
		}
		
		localRepository.save(l);
		return l;
	}

}
