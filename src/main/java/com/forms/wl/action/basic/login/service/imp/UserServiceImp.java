package com.forms.wl.action.basic.login.service.imp;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.forms.wl.action.basic.login.entity.UserInfo;
import com.forms.wl.action.basic.login.mapper.UserMapper;
import com.forms.wl.action.basic.login.service.UserService;

@Service
public class UserServiceImp implements UserService{
	
	@Autowired
	UserMapper userMapper;
	
	@Override
	public UserInfo findUserByLoginId(String loginId) {
		// TODO Auto-generated method stub
		UserInfo userInfo = userMapper.findUserByLoginId(loginId);
		return userInfo;
	}

	@Override
	public List<String> findRolesByUserId(String userId) {
		// TODO Auto-generated method stub
		List<String> list = userMapper.findRolesByUserId(userId);
		return list;
	}
	@Override
	public List<String> findModulesByRoleId(String roleId) {
		// TODO Auto-generated method stub
		List<String> list = userMapper.findModulesByRoleId(roleId);
		return list;
	}
	
	@Override
	public int register(UserInfo info) {
		// TODO Auto-generated method stub
		return userMapper.register(info);
	}

}
