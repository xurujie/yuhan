package com.yuhan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yuhan.dao.BelogsDao;
import com.yuhan.entities.Belongs;
import com.yuhan.service.BelongsService;


@Service
public class BelongsServiceImpl implements BelongsService {

	@Autowired
	private BelogsDao dao;
	
	@Override
	public List<Belongs> list() {		
		return dao.list();
	}

	@Override
	public Belongs findById(int id) {
		
		return dao.findById(id);
	}

}
