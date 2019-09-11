package com.yuhan.entities;

import java.sql.Timestamp;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
/*@AllArgsConstructor
@NoArgsConstructor*/
@Accessors(chain = true)
public class OrderList {
	@JsonSerialize(include=Inclusion.NON_EMPTY)
private int id;
	@JsonSerialize(include=Inclusion.NON_EMPTY)
private int user_id;
	@JsonSerialize(include=Inclusion.NON_EMPTY)
private String merchandises_id;
	@JsonSerialize(include=Inclusion.NON_EMPTY)
private String merchandise_sum;
	@JsonSerialize(include=Inclusion.NON_EMPTY)
private Timestamp order_time;
	@JsonSerialize(include=Inclusion.NON_EMPTY)
private String orderprice;
	@JsonSerialize(include=Inclusion.NON_EMPTY)
private String discountcoding;
	@JsonSerialize(include=Inclusion.NON_EMPTY)
private String balance_account;
	@JsonSerialize(include=Inclusion.NON_EMPTY)
private String integral;
	@JsonSerialize(include=Inclusion.NON_EMPTY)
private String status;
	@JsonSerialize(include=Inclusion.NON_EMPTY)
private String state;
	@JsonSerialize(include=Inclusion.NON_EMPTY)
private Timestamp deadline;
	@JsonSerialize(include=Inclusion.NON_EMPTY)
private String error;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getUser_id() {
	return user_id;
}
public void setUser_id(int user_id) {
	this.user_id = user_id;
}
public String getMerchandises_id() {
	return merchandises_id;
}
public void setMerchandises_id(String merchandises_id) {
	this.merchandises_id = merchandises_id;
}
public String getMerchandise_sum() {
	return merchandise_sum;
}
public void setMerchandise_sum(String merchandise_sum) {
	this.merchandise_sum = merchandise_sum;
}
public Timestamp getOrder_time() {
	return order_time;
}
public void setOrder_time(Timestamp order_time) {
	this.order_time = order_time;
}
public String getOrderprice() {
	return orderprice;
}
public void setOrderprice(String orderprice) {
	this.orderprice = orderprice;
}
public String getDiscountcoding() {
	return discountcoding;
}
public void setDiscountcoding(String discountcoding) {
	this.discountcoding = discountcoding;
}
public String getBalance_account() {
	return balance_account;
}
public void setBalance_account(String balance_account) {
	this.balance_account = balance_account;
}
public String getIntegral() {
	return integral;
}
public void setIntegral(String integral) {
	this.integral = integral;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
public Timestamp getDeadline() {
	return deadline;
}
public void setDeadline(Timestamp deadline) {
	this.deadline = deadline;
}
public String getError() {
	return error;
}
public void setError(String error) {
	this.error = error;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((balance_account == null) ? 0 : balance_account.hashCode());
	result = prime * result + ((deadline == null) ? 0 : deadline.hashCode());
	result = prime * result + ((discountcoding == null) ? 0 : discountcoding.hashCode());
	result = prime * result + ((error == null) ? 0 : error.hashCode());
	result = prime * result + id;
	result = prime * result + ((integral == null) ? 0 : integral.hashCode());
	result = prime * result + ((merchandise_sum == null) ? 0 : merchandise_sum.hashCode());
	result = prime * result + ((merchandises_id == null) ? 0 : merchandises_id.hashCode());
	result = prime * result + ((order_time == null) ? 0 : order_time.hashCode());
	result = prime * result + ((orderprice == null) ? 0 : orderprice.hashCode());
	result = prime * result + ((state == null) ? 0 : state.hashCode());
	result = prime * result + ((status == null) ? 0 : status.hashCode());
	result = prime * result + user_id;
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
	OrderList other = (OrderList) obj;
	if (balance_account == null) {
		if (other.balance_account != null)
			return false;
	} else if (!balance_account.equals(other.balance_account))
		return false;
	if (deadline == null) {
		if (other.deadline != null)
			return false;
	} else if (!deadline.equals(other.deadline))
		return false;
	if (discountcoding == null) {
		if (other.discountcoding != null)
			return false;
	} else if (!discountcoding.equals(other.discountcoding))
		return false;
	if (error == null) {
		if (other.error != null)
			return false;
	} else if (!error.equals(other.error))
		return false;
	if (id != other.id)
		return false;
	if (integral == null) {
		if (other.integral != null)
			return false;
	} else if (!integral.equals(other.integral))
		return false;
	if (merchandise_sum == null) {
		if (other.merchandise_sum != null)
			return false;
	} else if (!merchandise_sum.equals(other.merchandise_sum))
		return false;
	if (merchandises_id == null) {
		if (other.merchandises_id != null)
			return false;
	} else if (!merchandises_id.equals(other.merchandises_id))
		return false;
	if (order_time == null) {
		if (other.order_time != null)
			return false;
	} else if (!order_time.equals(other.order_time))
		return false;
	if (orderprice == null) {
		if (other.orderprice != null)
			return false;
	} else if (!orderprice.equals(other.orderprice))
		return false;
	if (state == null) {
		if (other.state != null)
			return false;
	} else if (!state.equals(other.state))
		return false;
	if (status == null) {
		if (other.status != null)
			return false;
	} else if (!status.equals(other.status))
		return false;
	if (user_id != other.user_id)
		return false;
	return true;
}
@Override
public String toString() {
	return "OrderList [id=" + id + ", user_id=" + user_id + ", merchandises_id=" + merchandises_id
			+ ", merchandise_sum=" + merchandise_sum + ", order_time=" + order_time + ", orderprice=" + orderprice
			+ ", discountcoding=" + discountcoding + ", balance_account=" + balance_account + ", integral=" + integral
			+ ", status=" + status + ", state=" + state + ", deadline=" + deadline + ", error=" + error + "]";
}
public OrderList(int id, int user_id, String merchandises_id, String merchandise_sum, Timestamp order_time,
		String orderprice, String discountcoding, String balance_account, String integral, String status, String state,
		Timestamp deadline, String error) {
	super();
	this.id = id;
	this.user_id = user_id;
	this.merchandises_id = merchandises_id;
	this.merchandise_sum = merchandise_sum;
	this.order_time = order_time;
	this.orderprice = orderprice;
	this.discountcoding = discountcoding;
	this.balance_account = balance_account;
	this.integral = integral;
	this.status = status;
	this.state = state;
	this.deadline = deadline;
	this.error = error;
}
public OrderList() {
	super();
}
public OrderList(int user_id, String merchandises_id, String merchandise_sum, Timestamp order_time, String orderprice,
		String discountcoding, String balance_account, String integral, String status, String state, Timestamp deadline,
		String error) {
	super();
	this.user_id = user_id;
	this.merchandises_id = merchandises_id;
	this.merchandise_sum = merchandise_sum;
	this.order_time = order_time;
	this.orderprice = orderprice;
	this.discountcoding = discountcoding;
	this.balance_account = balance_account;
	this.integral = integral;
	this.status = status;
	this.state = state;
	this.deadline = deadline;
	this.error = error;
}




}
