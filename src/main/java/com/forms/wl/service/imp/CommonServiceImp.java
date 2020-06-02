package com.forms.wl.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.forms.wl.entity.CommonEntity;
import com.forms.wl.mapper.CommonMapper;
import com.forms.wl.service.CommonService;

@Service
public class CommonServiceImp implements CommonService{

	@Autowired
	public CommonMapper mapper;
	
	@Override
	public List<CommonEntity> getBigType(String smallClass) {
		// TODO Auto-generated method stub
		return mapper.getBigType(smallClass);
	}

	@Override
	public List<CommonEntity> getCodeList(String codeType) {
		// TODO Auto-generated method stub
		return mapper.getCodeList(codeType);
	}

	@Override
	public List<CommonEntity> getSmallType(CommonEntity entity) {
		// TODO Auto-generated method stub
		return mapper.getSmallType(entity);
	}
	
	
}
