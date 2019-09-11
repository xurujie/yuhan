package com.yuhan.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize.Inclusion;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class MerchandiseShow implements Serializable {
	@JsonSerialize(include=Inclusion.NON_EMPTY)
	private int merchandise_id;
	@JsonSerialize(include=Inclusion.NON_EMPTY)
	private String originalprice;//原价
	@JsonSerialize(include=Inclusion.NON_EMPTY)
	private String merchandise;
	@JsonSerialize(include=Inclusion.NON_EMPTY)
	private String secondsbargain;
	@JsonSerialize(include=Inclusion.NON_EMPTY)
	private String grouppictures;
	@JsonSerialize(include=Inclusion.NON_EMPTY)
	private String suitableobject;
	@JsonSerialize(include=Inclusion.NON_EMPTY)
	private String price;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		MerchandiseShow that = (MerchandiseShow) o;
		return merchandise_id == that.merchandise_id &&
				Objects.equals(originalprice, that.originalprice) &&
				Objects.equals(merchandise, that.merchandise) &&
				Objects.equals(secondsbargain, that.secondsbargain) &&
				Objects.equals(grouppictures, that.grouppictures) &&
				Objects.equals(suitableobject, that.suitableobject) &&
				Objects.equals(price, that.price);
	}

	@Override
	public int hashCode() {
		return Objects.hash(merchandise_id, originalprice, merchandise, secondsbargain, grouppictures, suitableobject, price);
	}

	public int getMerchandise_id() {
		return merchandise_id;
	}

	public void setMerchandise_id(int merchandise_id) {
		this.merchandise_id = merchandise_id;
	}

	public String getOriginalprice() {
		return originalprice;
	}

	public void setOriginalprice(String originalprice) {
		this.originalprice = originalprice;
	}

	public String getMerchandise() {
		return merchandise;
	}

	public void setMerchandise(String merchandise) {
		this.merchandise = merchandise;
	}

	public String getSecondsbargain() {
		return secondsbargain;
	}

	public void setSecondsbargain(String secondsbargain) {
		this.secondsbargain = secondsbargain;
	}

	public String getGrouppictures() {
		return grouppictures;
	}

	public void setGrouppictures(String grouppictures) {
		this.grouppictures = grouppictures;
	}

	public String getSuitableobject() {
		return suitableobject;
	}

	public void setSuitableobject(String suitableobject) {
		this.suitableobject = suitableobject;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	@Override
	public String toString() {
		/*名称;商品ID;秒杀价;原价;;适用对象;图片url;，*/
		return "{\"merchandise\":\"" + merchandise+ "\",\"price\":\"" + price +"\""
				+ ",\"merchandise_id\":\"" + merchandise_id + "\",  \"originalprice\":\"" + originalprice + "\", \"secondsbargain\":\"" + secondsbargain + "\", \"suitableobject\":\""
				+ suitableobject + "\", \"grouppictures\":\"" + suB(grouppictures) + "\"}";
	}

	public static String  suB(String str){
		str =str.substring(0,str.length()-1);
		return str.split(";")[0];
	}
	public static List<String> suA(String str){
		List<String> list = new ArrayList<>();
		String[] ss =	str.split(";");
		for(String s:ss){
		list.add(s);
}

		return list;
	}

	public static int suC(String str){
		String[] ss =	str.split(";");
		int i =0;
		for(String s:ss){
			i=i+Integer.parseInt(s);
		}

		return i;
	}

}
