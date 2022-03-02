package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Event;
import tn.esprit.spring.service.IEventService;

@RestController
public class EventController {

	@Autowired
	IEventService eventService;
	
	public EventController() {
		// TODO Auto-generated constructor stub
	}
	
	@PostMapping("/add-event")
	@ResponseBody
	Event addEvent(@RequestBody Event e){
		return eventService.addEvent(e);
	}
	
	@GetMapping("/retrieve-allEvents")
	@ResponseBody
	List<Event> retrieveAllEvents(){
		
		return eventService.retrieveAllEvents();
	}
	
	@GetMapping("/get-Event/{idEvent}")
	@ResponseBody
	Event getLocalById(@PathVariable("idEvent") int idEvent){
		return eventService.retrieveEvent(idEvent);
		
	}
	
	@PutMapping("modify-event")
	@ResponseBody
	Event updateEvent(@RequestBody Event e){
		
		return eventService.updateEvent(e);
	}
	
	@DeleteMapping("delete-event/{id}")
	void deleteEvent(@PathVariable("id") int idEvent){
		eventService.deleteEvent(idEvent);
		
	}

}
