package com.forms.wl.action.basic.login.service;

import java.util.List;

import com.forms.wl.action.basic.login.entity.UserInfo;


public interface UserService {
	
	public UserInfo findUserByLoginId(String loginId);
	
	public List<String> findRolesByUserId(String uid);
	
	public List<String> findModulesByRoleId(String uid);
	
	public int register(UserInfo info);
	
}
