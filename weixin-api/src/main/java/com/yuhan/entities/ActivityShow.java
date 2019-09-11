package com.yuhan.entities;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;

import java.sql.Timestamp;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
/*活动列表*/
@Data
/*@AllArgsConstructor
@NoArgsConstructor*/
@Accessors(chain = true)
public class ActivityShow implements Serializable  {
	@JsonSerialize(include=Inclusion.NON_EMPTY)
	private int id;
	@JsonSerialize(include=Inclusion.NON_EMPTY)
	private String activity_type;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonSerialize(include=Inclusion.NON_EMPTY)
	private Timestamp start_time;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JsonSerialize(include=Inclusion.NON_EMPTY)
	private Timestamp end_time;
	@JsonSerialize(include=Inclusion.NON_EMPTY)
	private String product_list;
	public ActivityShow(String activity_type, Timestamp start_time, Timestamp end_time, String product_list, int sum) {
		super();
		this.activity_type = activity_type;
		this.start_time = start_time;
		this.end_time = end_time;
		this.product_list = product_list;
		this.sum = sum;
	}
	public ActivityShow(int id, String activity_type, Timestamp start_time, Timestamp end_time, String product_list,
			int sum) {
		super();
		this.id = id;
		this.activity_type = activity_type;
		this.start_time = start_time;
		this.end_time = end_time;
		this.product_list = product_list;
		this.sum = sum;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((activity_type == null) ? 0 : activity_type.hashCode());
		result = prime * result + ((end_time == null) ? 0 : end_time.hashCode());
		result = prime * result + id;
		result = prime * result + ((product_list == null) ? 0 : product_list.hashCode());
		result = prime * result + ((start_time == null) ? 0 : start_time.hashCode());
		result = prime * result + sum;
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
		ActivityShow other = (ActivityShow) obj;
		if (activity_type == null) {
			if (other.activity_type != null)
				return false;
		} else if (!activity_type.equals(other.activity_type))
			return false;
		if (end_time == null) {
			if (other.end_time != null)
				return false;
		} else if (!end_time.equals(other.end_time))
			return false;
		if (id != other.id)
			return false;
		if (product_list == null) {
			if (other.product_list != null)
				return false;
		} else if (!product_list.equals(other.product_list))
			return false;
		if (start_time == null) {
			if (other.start_time != null)
				return false;
		} else if (!start_time.equals(other.start_time))
			return false;
		if (sum != other.sum)
			return false;
		return true;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getActivity_type() {
		return activity_type;
	}
	public void setActivity_type(String activity_type) {
		this.activity_type = activity_type;
	}
	public Timestamp getStart_time() {
		return start_time;
	}
	public void setStart_time(Timestamp start_time) {
		this.start_time = start_time;
	}
	public Timestamp getEnd_time() {
		return end_time;
	}
	public void setEnd_time(Timestamp end_time) {
		this.end_time = end_time;
	}
	public String getProduct_list() {
		return product_list;
	}
	public void setProduct_list(String product_list) {
		this.product_list = product_list;
	}
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
	@Override
	public String toString() {
		long t =end_time.getTime()-System.currentTimeMillis();
		return "{\"activityType\":\"" + activity_type + "\",\"WhetherOpen\":\"1\",\"date\":\"" +t + "\",\"ListArray\":[";
	}
	@JsonSerialize(include=Inclusion.NON_EMPTY)
	private int sum;

}
