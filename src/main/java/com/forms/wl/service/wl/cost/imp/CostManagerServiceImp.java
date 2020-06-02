package com.forms.wl.service.wl.cost.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.forms.wl.entity.wl.cost.CostManagerEntity;
import com.forms.wl.mapper.wl.cost.CostManagerMapper;
import com.forms.wl.service.wl.cost.CostManagerService;

@Service
public class CostManagerServiceImp implements CostManagerService{
	
	@Autowired
	public CostManagerMapper mapper;
	
	@Override
	public int add(CostManagerEntity entity) {
		// TODO Auto-generated method stub
		return mapper.add(entity);
	}

	@Override
	public List<CostManagerEntity> list(CostManagerEntity entity) {
		// TODO Auto-generated method stub
		
	//	PageHelper.startPage(entity.getPageNum(), 3);
		
		return mapper.list(entity);
	}

	@Override
	public CostManagerEntity findById(String costId) {
		// TODO Auto-generated method stub
		return mapper.findById(costId);
	}

	@Override
	public int edit(CostManagerEntity entity) {
		// TODO Auto-generated method stub
		return mapper.edit(entity);
	}

	@Override
	public int delete(String costId) {
		// TODO Auto-generated method stub
		return mapper.delete(costId);
	}

}
