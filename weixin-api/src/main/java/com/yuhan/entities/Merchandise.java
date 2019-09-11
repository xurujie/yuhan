package com.yuhan.entities;


import java.io.Serializable;
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
public class Merchandise implements Serializable {

@JsonSerialize(include=Inclusion.NON_EMPTY)
private String merchandise;
@JsonSerialize(include=Inclusion.NON_EMPTY)
private int merchandise_id;
@JsonSerialize(include=Inclusion.NON_EMPTY)
private String belongs;
@JsonSerialize(include=Inclusion.NON_EMPTY)
private String img;
@JsonSerialize(include=Inclusion.NON_EMPTY)
private String whethercanactivity;
@JsonSerialize(include=Inclusion.NON_EMPTY)
private String activity_type;
@JsonSerialize(include=Inclusion.NON_EMPTY)
private String activity_coding;
@JsonSerialize(include=Inclusion.NON_EMPTY)
private String title;
@JsonSerialize(include=Inclusion.NON_EMPTY)
private String sub_title;
@JsonSerialize(include=Inclusion.NON_EMPTY)
private String price;
@JsonSerialize(include=Inclusion.NON_EMPTY)
private String originalprice;
@JsonSerialize(include=Inclusion.NON_EMPTY)
private String vip_price;
@JsonSerialize(include=Inclusion.NON_EMPTY)
private String secondsbargain;
@JsonSerialize(include=Inclusion.NON_EMPTY)
private String api_id;
@JsonSerialize(include=Inclusion.NON_EMPTY)
private String origin;
@JsonSerialize(include=Inclusion.NON_EMPTY)
private String brand;
@JsonSerialize(include=Inclusion.NON_EMPTY)
private String suitableobject;
@JsonSerialize(include=Inclusion.NON_EMPTY)
private String bases;
@JsonSerialize(include=Inclusion.NON_EMPTY)
private String usagemode;
@JsonSerialize(include=Inclusion.NON_EMPTY)
private String limitation_sum;
@JsonSerialize(include=Inclusion.NON_EMPTY)
private int commodity_sales;
@JsonSerialize(include=Inclusion.NON_EMPTY)
private int residual_inventory;
@JsonSerialize(include=Inclusion.NON_EMPTY)
private String mv_url;
@JsonSerialize(include=Inclusion.NON_EMPTY)
private String grouppictures;
@JsonSerialize(include=Inclusion.NON_EMPTY)
private String groupparticular;
@JsonSerialize(include=Inclusion.NON_EMPTY)
private String specification;
@JsonSerialize(include=Inclusion.NON_EMPTY)
private int evaluate_count;
@JsonSerialize(include=Inclusion.NON_EMPTY)
private String handpick;
@JsonSerialize(include=Inclusion.NON_EMPTY)
private String ship_address;
@JsonSerialize(include=Inclusion.NON_EMPTY)
private String reduce;

	public String getIntegral_buy() {
		return integral_buy;
	}

	public void setIntegral_buy(String integral_buy) {
		this.integral_buy = integral_buy;
	}

	@JsonSerialize(include=Inclusion.NON_EMPTY)
private String parcel;
	@JsonSerialize(include=Inclusion.NON_EMPTY)
	private String integral_buy;
public Merchandise(String merchandise, String belongs, String img, String whethercanactivity, String activity_type,
		String activity_coding, String title, String sub_title, String price, String originalprice, String vip_price,
		String secondsbargain, String api_id, String origin, String brand, String suitableobject, String bases,
		String usagemode, String limitation_sum, int commodity_sales, int residual_inventory, String mv_url,
		String grouppictures, String groupparticular, String specification, int evaluate_count, String specifcation,
		String handpick, String ship_address, String reduce, String parcel) {
	super();
	this.merchandise = merchandise;
	this.belongs = belongs;
	this.img = img;
	this.whethercanactivity = whethercanactivity;
	this.activity_type = activity_type;
	this.activity_coding = activity_coding;
	this.title = title;
	this.sub_title = sub_title;
	this.price = price;
	this.originalprice = originalprice;
	this.vip_price = vip_price;
	this.secondsbargain = secondsbargain;
	this.api_id = api_id;
	this.origin = origin;
	this.brand = brand;
	this.suitableobject = suitableobject;
	this.bases = bases;
	this.usagemode = usagemode;
	this.limitation_sum = limitation_sum;
	this.commodity_sales = commodity_sales;
	this.residual_inventory = residual_inventory;
	this.mv_url = mv_url;
	this.grouppictures = grouppictures;
	this.groupparticular = groupparticular;
	this.specification = specification;
	this.evaluate_count = evaluate_count;

	this.handpick = handpick;
	this.ship_address = ship_address;
	this.reduce = reduce;
	this.parcel = parcel;
}

@Override
public String toString() {
	return "\"Merchandise\": {\"merchandise\":\"" + merchandise + "\", \"merchandise_id\":\"" + merchandise_id + "\", \"belongs\":\"" + belongs
			+ "\", \"img\":\"" + img + "\",\" whethercanactivity\":\"" + whethercanactivity + "\", \"activity_type\":\"" + activity_type
			+ "\", \"activity_coding\":\"" + activity_coding + "\", \"title\":\"" + title + "\", \"sub_title\":\"" + sub_title + "\", \"price\":\""
			+ price + "\", \"originalprice\":\"" + originalprice + "\", \"vip_price\":\"" + vip_price + "\",\" secondsbargain\":\""
			+ secondsbargain + "\", \"api_id\":\"" + api_id + "\", \"origin\":\"" + origin + "\", \"brand\":\"" + brand + "\", \"suitableobject\":\""
			+ suitableobject + "\", \"bases\":\"" + bases + "\", \"usagemode\":\"" + usagemode + "\",\" limitation_sum\":\"" + limitation_sum
			+ "\", \"commodity_sales\":\"" + commodity_sales + "\", \"residual_inventory\":\"" + residual_inventory + "\", \"mv_url\":\""
			+ mv_url + "\", \"grouppictures\":\"" + grouppictures + "\", \"groupparticular\":\"" + groupparticular + "\", \"specification\":\""
			+ specification + "\", \"evaluate_count\":\"" + evaluate_count + "\", \"handpick\":\""
			+ handpick + "\", \"ship_address\":\"" + ship_address + "\", \"reduce\":\"" + reduce + "\",\" parcel\":\"" + parcel + "\",\"integral_buy\":\"" + integral_buy +"\"}";
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((activity_coding == null) ? 0 : activity_coding.hashCode());
	result = prime * result + ((activity_type == null) ? 0 : activity_type.hashCode());
	result = prime * result + ((api_id == null) ? 0 : api_id.hashCode());
	result = prime * result + ((bases == null) ? 0 : bases.hashCode());
	result = prime * result + ((belongs == null) ? 0 : belongs.hashCode());
	result = prime * result + ((brand == null) ? 0 : brand.hashCode());
	result = prime * result + commodity_sales;
	result = prime * result + evaluate_count;
	result = prime * result + ((groupparticular == null) ? 0 : groupparticular.hashCode());
	result = prime * result + ((grouppictures == null) ? 0 : grouppictures.hashCode());
	result = prime * result + ((handpick == null) ? 0 : handpick.hashCode());
	result = prime * result + ((img == null) ? 0 : img.hashCode());
	result = prime * result + ((limitation_sum == null) ? 0 : limitation_sum.hashCode());
	result = prime * result + ((merchandise == null) ? 0 : merchandise.hashCode());
	result = prime * result + merchandise_id;
	result = prime * result + ((mv_url == null) ? 0 : mv_url.hashCode());
	result = prime * result + ((origin == null) ? 0 : origin.hashCode());
	result = prime * result + ((originalprice == null) ? 0 : originalprice.hashCode());
	result = prime * result + ((parcel == null) ? 0 : parcel.hashCode());
	result = prime * result + ((price == null) ? 0 : price.hashCode());
	result = prime * result + ((reduce == null) ? 0 : reduce.hashCode());
	result = prime * result + residual_inventory;
	result = prime * result + ((secondsbargain == null) ? 0 : secondsbargain.hashCode());
	result = prime * result + ((ship_address == null) ? 0 : ship_address.hashCode());
	result = prime * result + ((specification == null) ? 0 : specification.hashCode());
	result = prime * result + ((sub_title == null) ? 0 : sub_title.hashCode());
	result = prime * result + ((suitableobject == null) ? 0 : suitableobject.hashCode());
	result = prime * result + ((title == null) ? 0 : title.hashCode());
	result = prime * result + ((usagemode == null) ? 0 : usagemode.hashCode());
	result = prime * result + ((vip_price == null) ? 0 : vip_price.hashCode());
	result = prime * result + ((whethercanactivity == null) ? 0 : whethercanactivity.hashCode());
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
	Merchandise other = (Merchandise) obj;
	if (activity_coding == null) {
		if (other.activity_coding != null)
			return false;
	} else if (!activity_coding.equals(other.activity_coding))
		return false;
	if (activity_type == null) {
		if (other.activity_type != null)
			return false;
	} else if (!activity_type.equals(other.activity_type))
		return false;
	if (api_id == null) {
		if (other.api_id != null)
			return false;
	} else if (!api_id.equals(other.api_id))
		return false;
	if (bases == null) {
		if (other.bases != null)
			return false;
	} else if (!bases.equals(other.bases))
		return false;
	if (belongs == null) {
		if (other.belongs != null)
			return false;
	} else if (!belongs.equals(other.belongs))
		return false;
	if (brand == null) {
		if (other.brand != null)
			return false;
	} else if (!brand.equals(other.brand))
		return false;
	if (commodity_sales != other.commodity_sales)
		return false;
	if (evaluate_count != other.evaluate_count)
		return false;
	if (groupparticular == null) {
		if (other.groupparticular != null)
			return false;
	} else if (!groupparticular.equals(other.groupparticular))
		return false;
	if (grouppictures == null) {
		if (other.grouppictures != null)
			return false;
	} else if (!grouppictures.equals(other.grouppictures))
		return false;
	if (handpick == null) {
		if (other.handpick != null)
			return false;
	} else if (!handpick.equals(other.handpick))
		return false;
	if (img == null) {
		if (other.img != null)
			return false;
	} else if (!img.equals(other.img))
		return false;
	if (limitation_sum == null) {
		if (other.limitation_sum != null)
			return false;
	} else if (!limitation_sum.equals(other.limitation_sum))
		return false;
	if (merchandise == null) {
		if (other.merchandise != null)
			return false;
	} else if (!merchandise.equals(other.merchandise))
		return false;
	if (merchandise_id != other.merchandise_id)
		return false;
	if (mv_url == null) {
		if (other.mv_url != null)
			return false;
	} else if (!mv_url.equals(other.mv_url))
		return false;
	if (origin == null) {
		if (other.origin != null)
			return false;
	} else if (!origin.equals(other.origin))
		return false;
	if (originalprice == null) {
		if (other.originalprice != null)
			return false;
	} else if (!originalprice.equals(other.originalprice))
		return false;
	if (parcel == null) {
		if (other.parcel != null)
			return false;
	} else if (!parcel.equals(other.parcel))
		return false;
	if (price == null) {
		if (other.price != null)
			return false;
	} else if (!price.equals(other.price))
		return false;
	if (reduce == null) {
		if (other.reduce != null)
			return false;
	} else if (!reduce.equals(other.reduce))
		return false;
	if (residual_inventory != other.residual_inventory)
		return false;
	if (secondsbargain == null) {
		if (other.secondsbargain != null)
			return false;
	} else if (!secondsbargain.equals(other.secondsbargain))
		return false;
	if (ship_address == null) {
		if (other.ship_address != null)
			return false;
	} else if (!ship_address.equals(other.ship_address))
		return false;
	if (specification == null) {
		if (other.specification != null)
			return false;
	} else if (!specification.equals(other.specification))
		return false;
	if (sub_title == null) {
		if (other.sub_title != null)
			return false;
	} else if (!sub_title.equals(other.sub_title))
		return false;
	if (suitableobject == null) {
		if (other.suitableobject != null)
			return false;
	} else if (!suitableobject.equals(other.suitableobject))
		return false;
	if (title == null) {
		if (other.title != null)
			return false;
	} else if (!title.equals(other.title))
		return false;
	if (usagemode == null) {
		if (other.usagemode != null)
			return false;
	} else if (!usagemode.equals(other.usagemode))
		return false;
	if (vip_price == null) {
		if (other.vip_price != null)
			return false;
	} else if (!vip_price.equals(other.vip_price))
		return false;
	if (whethercanactivity == null) {
		if (other.whethercanactivity != null)
			return false;
	} else if (!whethercanactivity.equals(other.whethercanactivity))
		return false;
	return true;
}
public String getMerchandise() {
	return merchandise;
}
public void setMerchandise(String merchandise) {
	this.merchandise = merchandise;
}
public int getMerchandise_id() {
	return merchandise_id;
}
public void setMerchandise_id(int merchandise_id) {
	this.merchandise_id = merchandise_id;
}
public String getBelongs() {
	return belongs;
}
public void setBelongs(String belongs) {
	this.belongs = belongs;
}
public String getImg() {
	return img;
}
public void setImg(String img) {
	this.img = img;
}
public String getWhethercanactivity() {
	return whethercanactivity;
}
public void setWhethercanactivity(String whethercanactivity) {
	this.whethercanactivity = whethercanactivity;
}
public String getActivity_type() {
	return activity_type;
}
public void setActivity_type(String activity_type) {
	this.activity_type = activity_type;
}
public String getActivity_coding() {
	return activity_coding;
}
public void setActivity_coding(String activity_coding) {
	this.activity_coding = activity_coding;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getSub_title() {
	return sub_title;
}
public void setSub_title(String sub_title) {
	this.sub_title = sub_title;
}
public String getPrice() {
	return price;
}
public void setPrice(String price) {
	this.price = price;
}
public String getOriginalprice() {
	return originalprice;
}
public void setOriginalprice(String originalprice) {
	this.originalprice = originalprice;
}
public String getVip_price() {
	return vip_price;
}
public void setVip_price(String vip_price) {
	this.vip_price = vip_price;
}
public String getSecondsbargain() {
	return secondsbargain;
}
public void setSecondsbargain(String secondsbargain) {
	this.secondsbargain = secondsbargain;
}
public String getApi_id() {
	return api_id;
}
public void setApi_id(String api_id) {
	this.api_id = api_id;
}
public String getOrigin() {
	return origin;
}
public void setOrigin(String origin) {
	this.origin = origin;
}
public String getBrand() {
	return brand;
}
public void setBrand(String brand) {
	this.brand = brand;
}
public String getSuitableobject() {
	return suitableobject;
}
public void setSuitableobject(String suitableobject) {
	this.suitableobject = suitableobject;
}
public String getBases() {
	return bases;
}
public void setBases(String bases) {
	this.bases = bases;
}
public String getUsagemode() {
	return usagemode;
}
public void setUsagemode(String usagemode) {
	this.usagemode = usagemode;
}
public String getLimitation_sum() {
	return limitation_sum;
}
public void setLimitation_sum(String limitation_sum) {
	this.limitation_sum = limitation_sum;
}
public int getCommodity_sales() {
	return commodity_sales;
}
public void setCommodity_sales(int commodity_sales) {
	this.commodity_sales = commodity_sales;
}
public int getResidual_inventory() {
	return residual_inventory;
}
public void setResidual_inventory(int residual_inventory) {
	this.residual_inventory = residual_inventory;
}
public String getMv_url() {
	return mv_url;
}
public void setMv_url(String mv_url) {
	this.mv_url = mv_url;
}
public String getGrouppictures() {
	return grouppictures;
}
public void setGrouppictures(String grouppictures) {
	this.grouppictures = grouppictures;
}
public String getGroupparticular() {
	return groupparticular;
}
public void setGroupparticular(String groupparticular) {
	this.groupparticular = groupparticular;
}
public String getSpecification() {
	return specification;
}
public void setSpecification(String specification) {
	this.specification = specification;
}
public int getEvaluate_count() {
	return evaluate_count;
}
public void setEvaluate_count(int evaluate_count) {
	this.evaluate_count = evaluate_count;
}
public String getHandpick() {
	return handpick;
}
public void setHandpick(String handpick) {
	this.handpick = handpick;
}
public String getShip_address() {
	return ship_address;
}
public void setShip_address(String ship_address) {
	this.ship_address = ship_address;
}
public String getReduce() {
	return reduce;
}
public void setReduce(String reduce) {
	this.reduce = reduce;
}
public String getParcel() {
	return parcel;
}
public void setParcel(String parcel) {
	this.parcel = parcel;
}


}
