package com.yuhan.dao;

import org.apache.ibatis.annotations.Mapper;

import com.yuhan.entities.Merchandise;

@Mapper
public interface MerchandiseDao {
	public Merchandise findById(int id);
}
