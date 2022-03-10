package tn.esprit.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entities.Event;
import tn.esprit.spring.entities.Local;
import tn.esprit.spring.entities.Pot;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.repository.EventRepository;
import tn.esprit.spring.repository.LocalRepository;
import tn.esprit.spring.repository.UserRepository;


 @Service
 @Slf4j
 public class EventServiceImpl implements IEventService {

	
	@Autowired
	EventRepository eventRepository;
	@Autowired
	LocalRepository localRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	userService userService;
	@Autowired
	IPotService potService;
	
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
	public Event addEventAndAssignLocal(Event e, int idLocal) { //not needed
		Local l=localRepository.findById(idLocal).orElse(null);
	//	e.setLocalEvent(l);
		eventRepository.save(e);
		return e;
		
	}
	
	@Override
	public void assignUserToEvent(int idEvent, int idUser) {
		if(eventRepository.findById(idEvent).isPresent()){
			Event e = eventRepository.findById(idEvent).get();
			User u = new User();
			if(userRepository.findById(idUser).isPresent()){
				u.setId(idUser);
				e.getEventUsers().add(u);
				eventRepository.save(e);
			}
		}
		
	}
	

	@Override
	public void newestEvent() {
		List<Event> events = retrieveAllEvents();
		for (int i = 1; i<events.size();i++){
			if(events.get(i).getDateStart().before(events.get(i-1).getDateStart())){
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
	
	@Override
	public void mostEarningEvent() {
		List<Event> events = retrieveAllEvents();
		int iEvent=0;
		float sum=0;
		sum=(events.get(0).getPrice()*eventRepository.eventParticipants(events.get(0).getIdEvent())-events.get(0).getSum());
		for (int i = 1; i<events.size();i++){
			
			if( ((events.get(i).getPrice()*eventRepository.eventParticipants(events.get(i).getIdEvent())-events.get(i).getSum())) > ((events.get(i-1).getPrice()*eventRepository.eventParticipants(events.get(i-1).getIdEvent())-events.get(i-1).getSum())) ){
				sum=(events.get(i).getPrice()*eventRepository.eventParticipants(events.get(i).getIdEvent())-events.get(i).getSum());
				iEvent=i;
			}
		}
		log.info("\n"
				+"The most profitable event is "
				+events.get(iEvent).getLibelle()
				+" with a sum of "
				+sum
				+"\n"
				+events.get(iEvent).getPrice()
				+" * "
				+eventRepository.eventParticipants(events.get(iEvent).getIdEvent())
				+" - "
				+events.get(iEvent).getSum()
				+" (which is the money assigned for this event from a pot) "
				+" = "
				+sum
				);
	}
	@Override
	public void mostParticipatingUser() {
		List<User> users =  (List<User>) userService.retrieveAllUsersKhaled();
		int iUser=0;
		int participation=eventRepository.mostParticipatingUser(users.get(0).getId());
		for (int i = 1; i<users.size();i++){
			if(eventRepository.mostParticipatingUser(users.get(i).getId()) > eventRepository.mostParticipatingUser(users.get(i-1).getId()) ){
				participation=eventRepository.mostParticipatingUser(users.get(i).getId());
				iUser=i;
			}
		}
		log.info("\n"
				+"The most participating user is "
				+users.get(iUser).getId()
				+users.get(iUser).getUsername()
				+":\n"
				+users.get(iUser).getFirstName()
				+" "
				+users.get(iUser).getLastName()
				+" with "
				+participation
				+" participations total"
				
				);
	}
	@Override
	public List<User> sortMostParticipatingUsers() {
		List<User> userList =  userRepository.sortMostParticipatingUsers();
		for (User user : userList){
			log.info("\n"
					+user.getId()
					+"-"
					+user.getUsername()
					+": - First name: "
					+user.getFirstName()
					+" Last name: "
					+user.getLastName()
					);
		}
		return userList;
	}
	@Override
	public void addMoneyFromPotToEvent(int idEvent, int idPot, float money) {
		Pot pot =potService.retrievePot(idPot);
		if((money <=0)  || (money > pot.getSum())){
			System.out.println("You cant add money equals or less than 0 or Pot is out of money");
			return;
		}else{
			Event event = retrieveEvent(idEvent);
			float sum;
			sum=event.getSum();
			sum+=money;
			event.setSum(sum);
			potService.takeMoney(idPot, money);
			System.out.println("Money added to "+event.getIdEvent()+"-"+event.getLibelle()+": "+money+" new sum: "+event.getSum());
			eventRepository.save(event);
		}
			
		
	}
	

}
