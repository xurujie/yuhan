package com.yuhan.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import com.yuhan.entities.Belongs;

@Mapper
public interface BelogsDao {
	public List<Belongs> list();	
	 public Belongs findById(int id);
}
