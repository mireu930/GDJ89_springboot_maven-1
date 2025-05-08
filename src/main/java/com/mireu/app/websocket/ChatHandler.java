package com.mireu.app.websocket;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ChatHandler implements WebSocketHandler {
	
	private Map<String, WebSocketSession> users = new HashMap<>();

	@Autowired
	private ChatDAO chatDAO;
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		users.put(session.getPrincipal().getName(), session);
		
	}

	@Override
	public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
		log.info("m:{}", message.getPayload());
		
		ObjectMapper objectMapper = new ObjectMapper();
		MessageVO messageVO = objectMapper.readValue(message.getPayload().toString(), MessageVO.class);
		
		String sender = session.getPrincipal().getName();
		messageVO.setSender(sender);
		
		if(messageVO.getStatus().equals("3")) {
			WebSocketMessage<?> webSocketMessage = new TextMessage(objectMapper.writeValueAsString(messageVO));
		
			try {
			chatDAO.addChat(messageVO);
			
			users.get(messageVO.getReceiver()).sendMessage(webSocketMessage);
			}catch(Exception e) {
				
			}
		}
	}

	@Override
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
		users.remove(session.getPrincipal().getName());
		
	}

	@Override
	public boolean supportsPartialMessages() {
		// TODO Auto-generated method stub
		return false;
	}

	
}
