package com.yuhan.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
/*@AllArgsConstructor
@NoArgsConstructor*/
@Accessors(chain = true)
public class Profile {
private int id;
private int user_id;
private String tel;
private String capital;
private String city;
private String district;
private String indetail;
private String recipient;
@Override
public String toString() {
	return "\"Profile\":{\"id\":\"" + id + "\", \"user_id\":\"" + user_id + "\", \"tel\":\"" + tel + "\", \"capital\":\"" + capital + "\", \"city\":\"" + city
			+ "\", \"district\":\"" + district + "\", \"indetail\":\"" + indetail + "\", \"recipient\":\"" + recipient + "\"}";
}
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
public String getTel() {
	return tel;
}
public void setTel(String tel) {
	this.tel = tel;
}
public String getCapital() {
	return capital;
}
public void setCapital(String capital) {
	this.capital = capital;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getDistrict() {
	return district;
}
public void setDistrict(String district) {
	this.district = district;
}
public String getIndetail() {
	return indetail;
}
public void setIndetail(String indetail) {
	this.indetail = indetail;
}
public String getRecipient() {
	return recipient;
}
public void setRecipient(String recipient) {
	this.recipient = recipient;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((capital == null) ? 0 : capital.hashCode());
	result = prime * result + ((city == null) ? 0 : city.hashCode());
	result = prime * result + ((district == null) ? 0 : district.hashCode());
	result = prime * result + id;
	result = prime * result + ((indetail == null) ? 0 : indetail.hashCode());
	result = prime * result + ((recipient == null) ? 0 : recipient.hashCode());
	result = prime * result + ((tel == null) ? 0 : tel.hashCode());
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
	Profile other = (Profile) obj;
	if (capital == null) {
		if (other.capital != null)
			return false;
	} else if (!capital.equals(other.capital))
		return false;
	if (city == null) {
		if (other.city != null)
			return false;
	} else if (!city.equals(other.city))
		return false;
	if (district == null) {
		if (other.district != null)
			return false;
	} else if (!district.equals(other.district))
		return false;
	if (id != other.id)
		return false;
	if (indetail == null) {
		if (other.indetail != null)
			return false;
	} else if (!indetail.equals(other.indetail))
		return false;
	if (recipient == null) {
		if (other.recipient != null)
			return false;
	} else if (!recipient.equals(other.recipient))
		return false;
	if (tel == null) {
		if (other.tel != null)
			return false;
	} else if (!tel.equals(other.tel))
		return false;
	if (user_id != other.user_id)
		return false;
	return true;
}
public Profile(int id, int user_id, String tel, String capital, String city, String district, String indetail,
		String recipient) {
	super();
	this.id = id;
	this.user_id = user_id;
	this.tel = tel;
	this.capital = capital;
	this.city = city;
	this.district = district;
	this.indetail = indetail;
	this.recipient = recipient;
}
public Profile(int user_id, String tel, String capital, String city, String district, String indetail,
		String recipient) {
	super();
	this.user_id = user_id;
	this.tel = tel;
	this.capital = capital;
	this.city = city;
	this.district = district;
	this.indetail = indetail;
	this.recipient = recipient;
}
public Profile() {
	super();
}


}
