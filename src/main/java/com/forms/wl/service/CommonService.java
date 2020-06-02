package com.forms.wl.service;

import java.util.List;

import com.forms.wl.entity.CommonEntity;

public interface CommonService {
	
	//获取码表中开销类大类类型列表
	public List<CommonEntity> getBigType(String codeType);
	
	//根据小类获取明细列表
	public List<CommonEntity> getCodeList(String smallType);
	
	//获取开销小类信息
	public List<CommonEntity> getSmallType(CommonEntity entity);
}
