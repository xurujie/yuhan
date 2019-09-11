package com.yuhan.entities;

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
public class Promotion {
public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((sum == null) ? 0 : sum.hashCode());
		result = prime * result + ((sum_off == null) ? 0 : sum_off.hashCode());
		return result;
	}
	public Promotion(String sum, String sum_off) {
		super();
		this.sum = sum;
		this.sum_off = sum_off;
	}
	public Promotion() {
		super();
	}
	public Promotion(int id, String sum, String sum_off) {
		super();
		this.id = id;
		this.sum = sum;
		this.sum_off = sum_off;
	}
	@Override
	public String toString() {
		return "\"Promotion\": {\"id\":\"" + id + "\", \"sum\":\"" + sum + "\", \"sum_off\":\"" + sum_off + "\"}";
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Promotion other = (Promotion) obj;
		if (id != other.id)
			return false;
		if (sum == null) {
			if (other.sum != null)
				return false;
		} else if (!sum.equals(other.sum))
			return false;
		if (sum_off == null) {
			if (other.sum_off != null)
				return false;
		} else if (!sum_off.equals(other.sum_off))
			return false;
		return true;
	}
	public String getSum() {
		return sum;
	}
	public void setSum(String sum) {
		this.sum = sum;
	}
	public String getSum_off() {
		return sum_off;
	}
	public void setSum_off(String sum_off) {
		this.sum_off = sum_off;
	}
@JsonSerialize(include=Inclusion.NON_EMPTY)
private int id;
@JsonSerialize(include=Inclusion.NON_EMPTY)
private String sum;
@JsonSerialize(include=Inclusion.NON_EMPTY)
private String sum_off;

}
