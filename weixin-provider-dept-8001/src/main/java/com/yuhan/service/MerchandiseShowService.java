package com.yuhan.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yuhan.entities.MerchandiseShow;

public interface MerchandiseShowService {
	public MerchandiseShow findById(int id);
	public List<MerchandiseShow> findByType(String type);
	public List<MerchandiseShow>   findByTypePaging(String type,int first,int end);
	public List<MerchandiseShow> findByRecommendType(String type,int first,int end);
	public String[]  findByBrand();
	public String[]  findByOrigin();
	public String[]  findByObject();
}
