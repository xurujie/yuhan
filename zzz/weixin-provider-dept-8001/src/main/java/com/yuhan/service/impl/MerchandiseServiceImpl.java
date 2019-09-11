package com.yuhan.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yuhan.dao.MerchandiseDao;
import com.yuhan.entities.Merchandise;
import com.yuhan.service.MerchandiseService;

@Service
public class MerchandiseServiceImpl implements MerchandiseService{

	@Autowired
	private MerchandiseDao dao;

	@Override
	public Merchandise findById(int id) {
		
		return dao.findById(id);
	}
	
}
