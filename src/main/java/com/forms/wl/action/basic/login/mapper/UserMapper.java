package com.forms.wl.action.basic.login.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.forms.wl.action.basic.login.entity.UserInfo;



@Mapper
public interface UserMapper {
	
	public List<UserInfo> getUsers(UserInfo info);
	
	public UserInfo findUserByLoginId(String loginId);
	
	public List<String> findRolesByUserId(String userId);
	
	public List<String> findModulesByRoleId(String roleId);
	
	public int register(UserInfo info);

}
