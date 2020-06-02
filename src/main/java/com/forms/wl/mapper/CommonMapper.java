package com.forms.wl.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.forms.wl.entity.CommonEntity;

@Mapper
public interface CommonMapper {
	
	//获取码表中开销类大类类型列表
	public List<CommonEntity> getBigType(String smallType);
	
	//根据小类获取明细列表
	public List<CommonEntity> getCodeList(String codeType);
	
	//获取开销小类信息
	public List<CommonEntity> getSmallType(CommonEntity entity);

}
