package com.forms.wl.mapper.wl.cost;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.forms.wl.entity.wl.cost.CostManagerEntity;


@Mapper
public interface CostManagerMapper {
	
	public int add(CostManagerEntity entity);
	
	public List<CostManagerEntity> list(CostManagerEntity entity);
	
	public CostManagerEntity findById(String costId);
	
	public int edit(CostManagerEntity entity);
	
	public int delete(String costId);

}
