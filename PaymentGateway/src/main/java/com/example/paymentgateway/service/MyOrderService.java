package com.example.paymentgateway.service;

import com.example.paymentgateway.entity.MyOrder;

public interface MyOrderService {
	
	void saveMyOrder(MyOrder order);
	MyOrder findByOrderId(String orderId);

}
