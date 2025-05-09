package com.mireu.app.websocket;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.socket.WebSocketSession;

public class WebsocketCollection {

	public static final Map<String, WebSocketSession> MAP;
	
	static {
		MAP =new HashMap<>();
	}
}
