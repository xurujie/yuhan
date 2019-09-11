package com.yuhan.service;

import com.yuhan.entities.Express;

public interface ExperssService {
	public Express findByOrderId(int orderId);
}
