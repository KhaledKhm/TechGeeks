package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entities.Event;
import tn.esprit.spring.repository.EventRepository;


 @Service
 @Slf4j
 public class EventServiceImpl implements IEventService {

	
	@Autowired
	EventRepository eventRepository;
	
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

	

}
