package com.forms.wl.action.basic.login.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.forms.wl.action.basic.login.entity.UserInfo;

@Mapper
public interface LoginMapper {
	
	public UserInfo getUserById(String userId);

}
