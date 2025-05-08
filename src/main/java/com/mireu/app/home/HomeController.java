package com.mireu.app.home;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mireu.app.users.UserVO;
import com.mireu.app.websocket.ChatDAO;
import com.mireu.app.websocket.MessageVO;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class HomeController {
	@Autowired
	private ChatDAO chatDAO;
	
	@GetMapping("/")
	public String home(@AuthenticationPrincipal UserVO userVO, HttpSession session) throws Exception {
		if(userVO!=null) {
			MessageVO messageVO = new MessageVO();
			messageVO.setReceiver(userVO.getUsername());
			
			List<MessageVO> list = chatDAO.getMessageList(messageVO);
			session.setAttribute("memoList", list);			
		}
		
		
		return "home";
	}
	
	@PostMapping("readMessage")
	@ResponseBody
	public int readMessage(MessageVO messageVO) throws Exception {
		log.info("chatNum:{}",messageVO.getChatNum());
		int result = chatDAO.readMessage(messageVO);
		return result;
	}

}
