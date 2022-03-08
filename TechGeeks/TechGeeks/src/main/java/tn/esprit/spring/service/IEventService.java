package tn.esprit.spring.service;

public interface IEventService {

import java.util.Date;
import java.util.List;

import tn.esprit.spring.entities.Event;

public interface IEventService {
	List<Event> retrieveAllEvents();
	Event addEvent(Event e);
	Event updateEvent(Event e);
	Event retrieveEvent(int id);
	void deleteEvent(int id);
	Event addEventAndAssignLocal(Event e, int idLocal);
	void newestEvent();
}
