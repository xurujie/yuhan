package com.yuhan.dao;

import org.apache.ibatis.annotations.Mapper;
import com.yuhan.entities.Promotion;

@Mapper
public interface PromotionDao {
	public Promotion findById(int id);
}
