package tn.esprit.spring.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import tn.esprit.spring.entities.Chat;
import tn.esprit.spring.entities.MessageType;
import tn.esprit.spring.entities.User;

@Component
public class WebSocketEventListner {

	private static final Logger LOGGER=LoggerFactory.getLogger(WebSocketEventListner.class);
	@Autowired 
	private SimpMessageSendingOperations sendingoperation;
	
	@EventListener
	public void handleWebSocketConnectListener(final SessionConnectedEvent event) {
		LOGGER.info("Bing Bong Connection ");
	}
	
	@EventListener
	public void handleWebSocketDisConnectListener(final SessionDisconnectEvent event) {
		final StompHeaderAccessor headeraccessor=StompHeaderAccessor.wrap(event.getMessage());
		final User username=(User)headeraccessor.getSessionAttributes().get("username");
		final Chat chatMassage=Chat.builder()
				.type(MessageType.Disconnect)
				.sender(username).build();
		
		sendingoperation.convertAndSend("/topic/public",chatMassage);
	}
}
