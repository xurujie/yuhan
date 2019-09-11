package com.yuhan.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yuhan.dao.PromotionDao;
import com.yuhan.entities.Promotion;
import com.yuhan.service.PromotionService;


@Service
public class PromotionServiceImpl implements PromotionService{

	
	@Autowired
	private PromotionDao dao;
	@Override
	public Promotion findById(int id) {
		return dao.findById(id);
	}

}
