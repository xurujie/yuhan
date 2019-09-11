package com.yuhan.entities;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;


/*首页轮播主图*/
@Data
/*@AllArgsConstructor
@NoArgsConstructor*/
@Accessors(chain = true)
public class Banner implements Serializable {
@JsonSerialize(include=Inclusion.NON_EMPTY)
private int id;
public Banner() {
	super();
}
public Banner(String bannerimg, String jum_url) {
	super();
	this.bannerimg = bannerimg;
	this.jum_url = jum_url;
}
public Banner(int id, String bannerimg, String jum_url) {
	super();
	this.id = id;
	this.bannerimg = bannerimg;
	this.jum_url = jum_url;
}
@JsonSerialize(include=Inclusion.NON_EMPTY)
private String bannerimg;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getBannerimg() {
	return bannerimg;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((bannerimg == null) ? 0 : bannerimg.hashCode());
	result = prime * result + id;
	result = prime * result + ((jum_url == null) ? 0 : jum_url.hashCode());
	return result;
}
@Override
public String toString() {
	return "{\"bannerimg\""+":\"" + bannerimg + "\", \"jum_url\":\"" + jum_url + "\"}";
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Banner other = (Banner) obj;
	if (bannerimg == null) {
		if (other.bannerimg != null)
			return false;
	} else if (!bannerimg.equals(other.bannerimg))
		return false;
	if (id != other.id)
		return false;
	if (jum_url == null) {
		if (other.jum_url != null)
			return false;
	} else if (!jum_url.equals(other.jum_url))
		return false;
	return true;
}
public void setBannerimg(String bannerimg) {
	this.bannerimg = bannerimg;
}
public String getJum_url() {
	return jum_url;
}
public void setJum_url(String jum_url) {
	this.jum_url = jum_url;
}
@JsonSerialize(include=Inclusion.NON_EMPTY)
private String jum_url;
}
