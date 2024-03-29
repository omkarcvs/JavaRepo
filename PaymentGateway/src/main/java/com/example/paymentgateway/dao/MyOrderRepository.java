package com.example.paymentgateway.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.paymentgateway.entity.MyOrder;
@Repository
public interface MyOrderRepository extends JpaRepository<MyOrder, Long> {
	public MyOrder findByOrderId(String orderId);
}
