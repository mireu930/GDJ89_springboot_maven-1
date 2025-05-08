package com.mireu.app.security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import com.mireu.app.users.UserDAO;
import com.mireu.app.users.UserVO;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class SecurityLogoutSuccessHandler implements LogoutHandler {
	@Autowired
	private UserDAO userDAO;

	@Override
	public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
		UserVO userVO = (UserVO)authentication.getPrincipal();
		userVO.setStatus(false);
		
		try {
			userDAO.statusChange(userVO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	

}
