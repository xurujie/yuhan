package com.yuhan.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.yuhan.entities.OrderList;

@Mapper
public interface OrderListDao {
public  List<OrderList> findByUserId(int  user_id);
public OrderList findById(int id);
public List<OrderList> findByUserIdAndStatus(int userId,@Param("status")String status);
public int addOrderList(OrderList orderList);
}
