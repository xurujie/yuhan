package com.yuhan.service;

import java.util.List;

import com.yuhan.entities.OrderList;
import com.yuhan.model.OrderListShow;

public interface OrderListService {
	public  OrderListShow findById(int  id);
	public  List<OrderListShow> findByUserId(int  user_id);
	public List<OrderListShow> findByUserIdAndStatus(int user_id,String status);
	public int addOrderList(OrderList orderList);

}
