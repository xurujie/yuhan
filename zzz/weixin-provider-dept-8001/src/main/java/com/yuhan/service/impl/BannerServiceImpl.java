package com.yuhan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yuhan.dao.BannerDao;
import com.yuhan.entities.Banner;
import com.yuhan.service.BannerService;

@Service
public class BannerServiceImpl implements BannerService{

	@Autowired
	private BannerDao dao;

	@Override
	public List<Banner> list() {
		  return dao.list();
	}

	@Override
	public Banner findById(int id) {

		return dao.findById(id);
	}
	 
}
