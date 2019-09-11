package com.yuhan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yuhan.dao.BannerDao;
import com.yuhan.dao.MerchandiseShowDao;
import com.yuhan.entities.MerchandiseShow;
import com.yuhan.service.MerchandiseShowService;
@Service
public class MerchandiseShowServiceImpl implements MerchandiseShowService{

	@Autowired
	private MerchandiseShowDao dao;
	@Override
	public MerchandiseShow findById(int id) {
		
		return dao.findById(id);
	}
	@Override
	public List<MerchandiseShow> findByType(String type) {

		return dao.findByType(type);
	}

	@Override
	public List<MerchandiseShow> findByTypePaging(String type, int first, int end) {
		return dao.findByTypePaging(type,first,end);
	}

	@Override
	public List<MerchandiseShow> findByRecommendType(String type, int first, int end) {
		return dao.findByRecommendType(type,first,end);
	}

	@Override
	public String[] findByBrand() {
		return dao.findByBrand();
	}

	@Override
	public String[] findByOrigin() {
		return dao.findByOrigin();
	}

	@Override
	public String[] findByObject() {
		return dao.findByObject();
	}

}
