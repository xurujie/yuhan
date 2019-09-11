package com.yuhan.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yuhan.dao.ExperssDao;
import com.yuhan.entities.Express;
import com.yuhan.service.ExperssService;

@Service 
public class ExperssServiceImpl implements ExperssService{

	@Autowired
	private ExperssDao experssDao;
	@Override
	public Express findByOrderId(int orderId) {
		return experssDao.findByOrderId(orderId);
	}

}
