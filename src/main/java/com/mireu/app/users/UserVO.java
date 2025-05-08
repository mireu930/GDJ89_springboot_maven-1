package com.mireu.app.users;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserVO implements UserDetails {
	
		private String username;
		private String password;
		private String name;
		private String phone;
		private String email;
		private Date birth;
		private String filename;
		private String originalname;
		
		private boolean accountNonExpired;
		private boolean accountNonLocked;
		private boolean credentialsNonExpired;
		private boolean enabled;
		private int social;
		private boolean status;
		
		private List<RoleVO> roleVO;
		
		@Override
		public Collection<? extends GrantedAuthority> getAuthorities() {
			List<GrantedAuthority> list = new ArrayList<>();
			
			for(RoleVO roleVO: roleVO) {
				GrantedAuthority g = new SimpleGrantedAuthority(roleVO.getRoleName());
				list.add(g);
			}
			
			return list;
		}
		
		
}
