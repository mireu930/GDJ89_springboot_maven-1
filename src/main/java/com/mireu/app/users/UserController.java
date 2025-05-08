package com.mireu.app.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/users/*")
public class UserController {
	@Autowired
	private UserService userService;

	@GetMapping("login")
	public String login(@AuthenticationPrincipal UserVO userVO) throws Exception {
		
		if(userVO != null) {
			return "redirect:/";
		}
		
		return "users/login";
	}
	
	
	@GetMapping("join")
	public String join(@ModelAttribute UserVO userVO) throws Exception {
		return "users/join";
	}
	
	@PostMapping("join")
	public String join(UserVO userVO,BindingResult bindingResult,@RequestParam("profile")MultipartFile multipartFile) throws Exception {
		int result = userService.join(userVO, multipartFile);
		
		return "redirect:/";
	}
	
	@GetMapping("mypage")
	public void mypage() throws Exception {
	}
}
