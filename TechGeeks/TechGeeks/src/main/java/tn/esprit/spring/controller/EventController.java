package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Event;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.repository.EventRepository;
import tn.esprit.spring.service.IEventService;

@RestController
public class EventController {

	@Autowired
	IEventService eventService;
	
	@Autowired
	EventRepository ev;
	public EventController() {
		// TODO Auto-generated constructor stub
	}
	
	@PostMapping("/add-event")
	Event addEvent(@RequestBody Event e){
		return eventService.addEvent(e);
	}
	
	@GetMapping("/retrieve-allEvents")
	List<Event> retrieveAllEvents(){
		
		return eventService.retrieveAllEvents();
	}
	
	@GetMapping("/get-Event/{idEvent}")
	Event getLocalById(@PathVariable("idEvent") int idEvent){
		return eventService.retrieveEvent(idEvent);
		
	}
	
	@GetMapping("/newest-Event")
	void newestEvent(){
		eventService.newestEvent();
		
	}
	
	@PutMapping("modify-event")
	Event updateEvent(@RequestBody Event e){
		
		return eventService.updateEvent(e);
	}
	
	@DeleteMapping("delete-event/{id}")
	void deleteEvent(@PathVariable("id") int idEvent){
		eventService.deleteEvent(idEvent);
		
	}
	
	@PostMapping("/assign-local-to-event/{idLocal}")
	Event assignLocalToEvent(@RequestBody Event e, @PathVariable("idLocal") int idLocal){
		return eventService.addEventAndAssignLocal(e, idLocal);
	}
	
	@PutMapping("/assign-user-to-event/{idEvent}/{idUser}")
	void assignUserToEvent(@PathVariable("idEvent") int idEvent, @PathVariable("idUser") int idUser){
		eventService.assignUserToEvent(idEvent, idUser);
	}
	
	@GetMapping("/most-profitable-event")
	void mostEarningEvent(){
		eventService.mostEarningEvent();
		
	}
	
	@GetMapping("/most-particpating-user-Event")
	void mostParticipatingUser(){
		eventService.mostParticipatingUser();
		
	}
	@GetMapping("/sort-most-particpating-users-Event")
	List<User> sortParticipatingUsers(){
		//return eventService.sortMostParticipatingUsers();
		return eventService.sortMostParticipatingUsers();
		
	}
	
	@PutMapping("/add-money-to-event/{idEvent}/{idPot}/{money}")
	void addMoneyFromPotToEvent(@PathVariable("idEvent") int idEvent, @PathVariable("idPot") int idPot,@PathVariable("money") int money){
		eventService.addMoneyFromPotToEvent(idEvent, idPot,money);
	}
	
	
	

}
