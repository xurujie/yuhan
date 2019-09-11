package com.yuhan.model;

import java.util.Arrays;
import java.util.List;

import com.yuhan.entities.MerchandiseShow;

public class OrderListShow {
private String orderNumber;
private String status;
private String orderprice;
private List<MerchandiseShow> merchandises;
private String sum;
public String getOrderNumber() {
	return orderNumber;
}
public OrderListShow() {
	super();
}
public void setOrderNumber(String orderNumber) {
	this.orderNumber = orderNumber;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public String getOrderprice() {
	return orderprice;
}
public void setOrderprice(String orderprice) {
	this.orderprice = orderprice;
}
public List<MerchandiseShow> getMerchandises() {
	return merchandises;
}
public void setMerchandises(List<MerchandiseShow> merchandises) {
	this.merchandises = merchandises;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((merchandises == null) ? 0 : merchandises.hashCode());
	result = prime * result + ((orderNumber == null) ? 0 : orderNumber.hashCode());
	result = prime * result + ((orderprice == null) ? 0 : orderprice.hashCode());
	result = prime * result + ((status == null) ? 0 : status.hashCode());
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	OrderListShow other = (OrderListShow) obj;
	if (merchandises == null) {
		if (other.merchandises != null)
			return false;
	} else if (!merchandises.equals(other.merchandises))
		return false;
	if (orderNumber == null) {
		if (other.orderNumber != null)
			return false;
	} else if (!orderNumber.equals(other.orderNumber))
		return false;
	if (orderprice == null) {
		if (other.orderprice != null)
			return false;
	} else if (!orderprice.equals(other.orderprice))
		return false;
	if (status == null) {
		if (other.status != null)
			return false;
	} else if (!status.equals(other.status))
		return false;
	return true;
}
public String getSum() {
	return sum;
}
public void setSum(String sum) {
	this.sum = sum;

}
public OrderListShow(String orderNumber, String status, String orderprice, List<MerchandiseShow> merchandises,
					 String sum) {
	super();
	this.orderNumber = orderNumber;
	this.status = status;
	this.orderprice = orderprice;
	this.merchandises = merchandises;
	this.sum = sum;
}
@Override
public String toString() {
	return "{\"orderNumber\":\"" + orderNumber + "\", \"sum\":" + MerchandiseShow.suA(sum) + ",\"sums\":\""+MerchandiseShow.suC(sum)+"\", \"status\":\"" + status + "\", \"orderprice\":\"" + orderprice
			+ "\", \"merchandises\":[" + merchandises + "]}";
}
public OrderListShow(String orderNumber, String status, String orderprice, List<MerchandiseShow> merchandises) {
	super();
	this.orderNumber = orderNumber;
	this.status = status;
	this.orderprice = orderprice;
	this.merchandises = merchandises;
}

}
