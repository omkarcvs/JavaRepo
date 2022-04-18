package com.example.paymentgateway.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;



@Entity
@Table(name="MY_ORDER")
public class MyOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "MY_ORDER_SEQ")
	@SequenceGenerator(name = "MY_ORDER_SEQ",initialValue = 1,allocationSize = 1,sequenceName = "MY_ORDER_SEQ")
	@Column(name="MY_ORDER_SEQ")	
	private Long myOrderID;
	
	private String orderId;
	
	private String amount;
	
	private String reciept;
	
	private String status;
	
	
	private String paymentId;
	
	@Column(name="CREATE_DATE")
	@DateTimeFormat(pattern="yyyy-MM-dd hh:mm:ss")
	@CreationTimestamp 
	private LocalDateTime  createDate;	

	
	@Column(name="UPDATE_DATE")
	@DateTimeFormat(pattern="yyyy-MM-dd hh:mm:ss")
	@UpdateTimestamp
	private LocalDateTime updateDate;
	
	public MyOrder() {
		
	}
	public MyOrder(long myOrderID, String orderId, String amount, String reciept, String status) {
		
		this.myOrderID = myOrderID;
		this.orderId = orderId;
		this.amount = amount;
		this.reciept = reciept;
		this.status = status;
	}
	public long getMyOrderID() {
		return myOrderID;
	}
	public void setMyOrderID(long myOrderID) {
		this.myOrderID = myOrderID;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getReciept() {
		return reciept;
	}
	public void setReciept(String reciept) {
		this.reciept = reciept;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}
	public void setMyOrderID(Long myOrderID) {
		this.myOrderID = myOrderID;
	}
	
	
}
