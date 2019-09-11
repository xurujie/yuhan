package com.yuhan.dao;


import org.apache.ibatis.annotations.Mapper;
import com.yuhan.entities.ActivityShow;


@Mapper
public interface ActivityShowDao {
	public ActivityShow findByTime(String time);
}
  