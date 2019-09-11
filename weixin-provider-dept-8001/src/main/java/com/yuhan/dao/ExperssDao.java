package com.yuhan.dao;

import org.apache.ibatis.annotations.Mapper;

import com.yuhan.entities.Express;

@Mapper
public interface ExperssDao {
public Express findByOrderId(int orderId);
}
