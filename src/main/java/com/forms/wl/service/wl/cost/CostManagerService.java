package com.forms.wl.service.wl.cost;

import java.util.List;

import com.forms.wl.entity.wl.cost.CostManagerEntity;

public interface CostManagerService {
	
	public int add(CostManagerEntity entity);
	
	public List<CostManagerEntity> list(CostManagerEntity entity);
	
	public CostManagerEntity findById(String costId);
	
	public int edit(CostManagerEntity entity);
	
	public int delete(String costId);

}
