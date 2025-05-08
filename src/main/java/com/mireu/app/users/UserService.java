package com.mireu.app.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService implements UserDetailsService {

	@Autowired
	private UserDAO userDAO;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserVO userVO = new UserVO();
		
		userVO.setUsername(username);
		
		try {
			userVO = userDAO.login(userVO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			userVO = null;
		}
		return userVO;
	}
	
	public boolean userErrorCheck(UserVO userVO, BindingResult bindingResult) throws Exception {
		boolean check = false;
		
		check = bindingResult.hasErrors();
		
		if(userVO.getPassword().equals(userVO.getPassword())) {
			check = true;
			bindingResult.rejectValue("passwordCheck", "userVO.password.equals");
		}
		
		return check;
	}
	
	public UserVO login(UserVO userVO) throws Exception {
		UserVO userVO2 = userDAO.login(userVO);
		if(userVO2.getPassword().equals(userVO.getPassword())) {
			log.info("login:{}",userVO2);
			return userVO2;
		}
		
		return null;
	}
	
	public int join(UserVO userVO, MultipartFile multipartFile) throws Exception {
		String filename = "";
		userVO.setFilename(filename);
		userVO.setOriginalname(multipartFile.getOriginalFilename());
		userVO.setPassword(passwordEncoder.encode(userVO.getPassword()));
		int result = userDAO.join(userVO);
		return result;
	}

}
