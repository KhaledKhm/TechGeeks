package tn.esprit.spring.service;

import java.util.Set;

import tn.esprit.spring.entities.Event;

public interface IEventService {
	Set<Event> retrieveAllEvents();
	Event addEvent(Event e);
	Event updateEvent(Event e);
	Event retrieveEvent(int id);
	void deleteEvent(int id);
}
