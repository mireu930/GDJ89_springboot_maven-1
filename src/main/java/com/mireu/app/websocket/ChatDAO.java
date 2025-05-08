package com.mireu.app.websocket;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ChatDAO {

	public List<MessageVO> getMessageList(MessageVO messageVO) throws Exception;
	public int addChat(MessageVO messageVO) throws Exception;
	public int readMessage(MessageVO messageVO) throws Exception;
}
