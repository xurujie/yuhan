package com.yuhan.entities;

import java.sql.Timestamp;
import java.util.Objects;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
/*@AllArgsConstructor
@NoArgsConstructor*/
@Accessors(chain = true)
public class Express {
private int id;
private int order_id;
private String express_type;
private String express_number;
private Timestamp shipments;

	public Express() {
	}

	public Express(int order_id, String express_type, String express_number, Timestamp shipments) {
		this.order_id = order_id;
		this.express_type = express_type;
		this.express_number = express_number;
		this.shipments = shipments;
	}

	public int getId() {
		return id;
	}

	public Express(int id, int order_id, String express_type, String express_number, Timestamp shipments) {
		this.id = id;
		this.order_id = order_id;
		this.express_type = express_type;
		this.express_number = express_number;
		this.shipments = shipments;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Express express = (Express) o;
		return id == express.id &&
				order_id == express.order_id &&
				Objects.equals(express_type, express.express_type) &&
				Objects.equals(express_number, express.express_number) &&
				Objects.equals(shipments, express.shipments);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, order_id, express_type, express_number, shipments);
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public String getExpress_type() {
		return express_type;
	}

	public void setExpress_type(String express_type) {
		this.express_type = express_type;
	}

	public String getExpress_number() {
		return express_number;
	}

	public void setExpress_number(String express_number) {
		this.express_number = express_number;
	}

	public Timestamp getShipments() {
		return shipments;
	}

	public void setShipments(Timestamp shipments) {
		this.shipments = shipments;
	}

	@Override
public String toString() {
	return "\"Express\": {\"id\":\"" + id + "\", \"order_id\":\"" + order_id + "\", \"express_type\":\"" + express_type + "\", \"express_number\":\""
			+ express_number + "\", \"shipments\":\"" + shipments + "\"}";
}

}
