package com.mireu.app.users;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDAO {

	public UserVO login(UserVO userVO) throws Exception;
	public int join(UserVO userVO) throws Exception;
	public int statusChange(UserVO userVO) throws Exception;
}
