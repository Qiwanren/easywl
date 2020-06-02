package com.forms.wl.action.basic.login.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.forms.wl.action.basic.login.entity.UserInfo;
import com.forms.wl.action.basic.login.mapper.LoginMapper;



@Service
public class LoginServiceImp {
	
	@Autowired
	LoginMapper loginMapper ;
	
	public UserInfo getUserById(String userId)
	{
		return loginMapper.getUserById(userId);
		
	}

	
}
