package tn.esprit.spring.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entities.Event;
import tn.esprit.spring.entities.Local;
import tn.esprit.spring.entities.Pot;
import tn.esprit.spring.repository.EventRepository;
import tn.esprit.spring.repository.LocalRepository;


 @Service
 @Slf4j
 public class EventServiceImpl implements IEventService {

	
	@Autowired
	EventRepository eventRepository;
	@Autowired
	LocalRepository localRepository;
	
	@Override
	public List<Event> retrieveAllEvents() {
		List<Event> eventList =  eventRepository.findAll();
		for (Event event : eventList){
			log.info(" Event: " +event);
		}
		return eventList;
	}
	@Override
	public Event addEvent(Event e) {
		eventRepository.save(e);
		return e;
	}
	@Override
	public Event updateEvent(Event e) {
		eventRepository.save(e);
		return e;
	}
	@Override
	public Event retrieveEvent(int id) {
		return eventRepository.findById(id).orElse(null);
	}
	
	@Override
	public void deleteEvent(int id) {
		eventRepository.deleteById(id);
		
	}
	@Override
	public Event addEventAndAssignLocal(Event e, int idLocal) {
		Local l=localRepository.findById(idLocal).orElse(null);
		e.setLocal(l);
		eventRepository.save(e);
		return e;
		
	}
	

	@Override
	public void newestEvent() {
		List<Event> events = retrieveAllEvents();
		for (int i = 0; i<events.size();i++){
			if(events.get(i).getDateStart().before(events.get(i+1).getDateStart())){
				log.info(i
						+"-Event "
						+events.get(i).getIdEvent()
						+" "
						+events.get(i).getLibelle()
						+" will take place on " 
						+events.get(i).getDateStart()
						+" and end on "
						+events.get(i).getDateEnd());
			}
		}
		
	}

	

}
