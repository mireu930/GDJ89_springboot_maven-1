package com.mireu.app.websocket;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageVO {
	
	private Long chatNum;
	private Long roomNum;
	private String sender;
	private String body;
	private String receiver;
	private String date;
	private String status;
	private boolean readStatus;

}
