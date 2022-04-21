package tn.esprit.spring.service;

import java.util.Date;
import java.util.List;

import tn.esprit.spring.entities.Event;
import tn.esprit.spring.entities.User;

public interface IEventService {
	List<Event> retrieveAllEvents();
	Event addEvent(Event e);
	Event updateEvent(Event e);
	Event retrieveEvent(int id);
	void deleteEvent(int id);
	Event addEventAndAssignLocal(Event e, int idLocal);
	void assignUserToEvent(int idEvent, int idUser);
	void addMoneyFromPotToEvent(int idEvent, int idPot, float money);
	void newestEvent();
	void mostEarningEvent();
	void mostParticipatingUser();
	List<User> sortMostParticipatingUsers();
}
