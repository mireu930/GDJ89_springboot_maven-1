package com.mireu.app.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	@Autowired
	private LoginSuccessHandler loginSuccessHandler;
	@Autowired
	private LoginFailureHandler loginFailureHandler; 
	@Autowired
	private SecurityLogoutSuccessHandler securityLogoutSuccessHandler;
	
	WebSecurityCustomizer webSecurityCustomizer() {
		return (web) -> {
			web.ignoring().requestMatchers("/css/**", "/js/**")
			.requestMatchers("/images/**","/imag/**","/vendor/**");
		};
	}
	
	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity security) throws Exception {
		
		security
			.cors(cors->cors.disable())
			.csrf(csrf->csrf.disable())
			
			.authorizeHttpRequests(authorizeRequest->{
				authorizeRequest
				.requestMatchers("/users/mypage","/users/logout").authenticated()
				.requestMatchers("/admin/check").hasRole("ADMIN")
				.requestMatchers("/manager/check").hasAnyRole("ADMIN","MANAGER")
				.anyRequest().permitAll()
				;
			})
			
			.formLogin(formLogin->{
				formLogin
				.loginPage("/users/login")
				.successHandler(loginSuccessHandler)
				.failureHandler(loginFailureHandler)
				.permitAll()
				;
			})
			
			.logout(logout->{
				logout
					.logoutUrl("/users/logout")
					.addLogoutHandler(securityLogoutSuccessHandler)
					.invalidateHttpSession(true)
					.permitAll()
					;
			})
			
			.sessionManagement(s->
				s
				.maximumSessions(1)
				.maxSessionsPreventsLogin(true)
				.expiredUrl("/")
				
			)
			.sessionManagement(session->
				session.invalidSessionUrl("/")
			)
			;
		
		return security.build();
	}

}
