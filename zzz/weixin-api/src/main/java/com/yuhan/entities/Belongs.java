package com.yuhan.entities;

import java.io.Serializable;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
/*商品专区*/
@Data
/*@AllArgsConstructor
@NoArgsConstructor*/
@Accessors(chain = true)
public class Belongs implements Serializable  {
	@JsonSerialize(include=Inclusion.NON_EMPTY)
	private int id;
	@JsonSerialize(include=Inclusion.NON_EMPTY)
	private String title;

	public Belongs(String title, String icon, String api_id) {
		super();
		this.title = title;
		this.icon = icon;
		this.api_id = api_id;
	}
	public Belongs(int id, String title, String icon, String api_id) {
		super();
		this.id = id;
		this.title = title;
		this.icon = icon;
		this.api_id = api_id;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((api_id == null) ? 0 : api_id.hashCode());
		result = prime * result + ((icon == null) ? 0 : icon.hashCode());
		result = prime * result + id;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		Belongs other = (Belongs) obj;
		if (api_id == null) {
			if (other.api_id != null)
				return false;
		} else if (!api_id.equals(other.api_id))
			return false;
		if (icon == null) {
			if (other.icon != null)
				return false;
		} else if (!icon.equals(other.icon))
			return false;
		if (id != other.id)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getApi_id() {
		return api_id;
	}
	public void setApi_id(String api_id) {
		this.api_id = api_id;
	}
	@Override
	public String toString() {
		return "{\"title\":\""+title+"\", \"icon\":\""+icon+"\", \"api_id\":\""+api_id+"\"}";
	}
	public Belongs() {
		super();
	}
	@JsonSerialize(include=Inclusion.NON_EMPTY)
	private String icon;
	@JsonSerialize(include=Inclusion.NON_EMPTY)
	private String api_id;
	
}
