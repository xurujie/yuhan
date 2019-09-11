package com.yuhan.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yuhan.dao.ActivityShowDao;
import com.yuhan.entities.ActivityShow;
import com.yuhan.service.ActivityShowService;

@Service
public class ActivityShowServiceImpl implements ActivityShowService {

	@Autowired
	private ActivityShowDao dao;
	@Override
	public ActivityShow findByTime(String time) {
		return dao.findByTime(time);
	}

}
