package com.mireu.app.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class SecurityTestController {

	@GetMapping("/admin/check")
	public void admin() {
		log.info("admin");
	}
	
	@GetMapping("/manager/check")
	public void manager() {
		log.info("manager");
	}
	
	@GetMapping("/user/check")
	public void user() {
		log.info("user");
	}
}
