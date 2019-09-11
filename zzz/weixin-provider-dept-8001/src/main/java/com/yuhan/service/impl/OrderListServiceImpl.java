package com.yuhan.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import com.yuhan.dao.MerchandiseDao;
import com.yuhan.dao.MerchandiseShowDao;
import com.yuhan.dao.OrderListDao;
import com.yuhan.entities.Merchandise;
import com.yuhan.entities.MerchandiseShow;
import com.yuhan.entities.OrderList;
import com.yuhan.model.OrderListShow;
import com.yuhan.service.OrderListService;
import com.yuhan.util.NumberUtil;
@Service
public class OrderListServiceImpl implements OrderListService {
	StringBuffer sb0;StringBuffer sb;
	@Autowired
	private OrderListDao orderlistDao;
	@Autowired
	private MerchandiseDao merchandiseDao;
	@Autowired
	private MerchandiseShowDao merchandiseShowDao ;
	@Override
	public List<OrderListShow> findByUserId(int user_id) {
	List<OrderList> os = orderlistDao.findByUserId(user_id);
	List<OrderListShow> olss = new ArrayList<>();
	for(OrderList ol :os){
	OrderListShow ols = new OrderListShow();
	ols.setOrderNumber(NumberUtil.number(ol.getId(), ol.getOrder_time().toString()));
	ols.setOrderprice(ol.getOrderprice());
	ols.setStatus(ol.getStatus());
	String s =ol.getMerchandises_id();
	sb = new StringBuffer(s);
	sb = sb.deleteCharAt(sb.length()-1);
	String[] ss= sb.toString().split(";");
	sb0 = new StringBuffer(ol.getMerchandise_sum());
	sb0 = sb0.deleteCharAt(sb0.length()-1);
	String[] ss0= sb0.toString().split(";");
	ols.setMerchandises(new ArrayList<MerchandiseShow>());
		ols.setSum(sb0.toString());
	for(int i =0;i<ss.length;i++){
		int id= Integer.parseInt(ss[i]);
		MerchandiseShow merchandiseShow = merchandiseShowDao.findById(id);

			ols.getMerchandises().add(merchandiseShow);
		}	
		olss.add(ols);
		}
		return olss;
		
	}

	@Override
	public List<OrderListShow> findByUserIdAndStatus(int user_id, String status) {
		List<OrderList> os = orderlistDao.findByUserIdAndStatus(user_id, status);
		List<OrderListShow> olss = new ArrayList<OrderListShow>();
		for(OrderList ol :os){		
			OrderListShow ols = new OrderListShow();
	ols.setOrderNumber(NumberUtil.number(ol.getId(), ol.getOrder_time().toString()));
	ols.setOrderprice(ol.getOrderprice());
	ols.setStatus(ol.getStatus());
			String s =ol.getMerchandises_id();
			sb = new StringBuffer(s);
			sb = sb.deleteCharAt(sb.length()-1);
		String[] ss= sb.toString().split(";");
		sb0 = new StringBuffer(ol.getMerchandise_sum());
		sb0 = sb0.deleteCharAt(sb0.length()-1);
	String[] ss0= sb0.toString().split(";");
		ols.setMerchandises(new ArrayList<MerchandiseShow>());
			ols.setSum(sb0.toString());
		for(int i =0;i<ss.length;i++){

			int id= Integer.parseInt(ss[i]);
			MerchandiseShow merchandiseShow = merchandiseShowDao.findById(id);	
			ols.getMerchandises().add(merchandiseShow);
		}	
		olss.add(ols);
		}
		return olss;
		
	}


	@Override
	public OrderListShow findById(int id) {
		OrderList ol = orderlistDao.findById(id);
		OrderListShow ols = new OrderListShow();
		ols.setOrderNumber(NumberUtil.number(ol.getId(), ol.getOrder_time().toString()));
		ols.setOrderprice(ol.getOrderprice());
		ols.setStatus(ol.getStatus());
		String s =ol.getMerchandises_id();
		sb = new StringBuffer(s);
		sb = sb.deleteCharAt(sb.length()-1);
		String[] ss= sb.toString().split(";");
		ols.setMerchandises(new ArrayList<MerchandiseShow>());
		sb0 = new StringBuffer(ol.getMerchandise_sum());
		sb0 = sb0.deleteCharAt(sb0.length()-1);
		String[] ss0= sb0.toString().split(";");
		ols.setMerchandises(new ArrayList<MerchandiseShow>());
		ols.setSum(sb0.toString());
		for(int i =0;i<ss.length;i++){

			int mid= Integer.parseInt(ss[i]);
			MerchandiseShow merchandiseShow = merchandiseShowDao.findById(mid);
			ols.getMerchandises().add(merchandiseShow);
		}
		return  ols;
	}


	@Override
	public int addOrderList(OrderList orderList) {
		return orderlistDao.addOrderList(orderList);
	}
}
