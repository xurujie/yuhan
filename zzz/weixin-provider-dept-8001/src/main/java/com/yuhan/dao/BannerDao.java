package com.yuhan.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.yuhan.entities.Banner;

@Mapper
public interface BannerDao {
	    public List<Banner> list();
	    public Banner findById(int id);
}
