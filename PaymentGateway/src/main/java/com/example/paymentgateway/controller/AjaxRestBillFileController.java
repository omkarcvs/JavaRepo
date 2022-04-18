package com.example.paymentgateway.controller;

import java.util.Map;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.paymentgateway.entity.MyOrder;
import com.example.paymentgateway.service.MyOrderService;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;





@RestController
//@RequestMapping("bts/api/ajaxrest")
public class AjaxRestBillFileController {

	@Autowired
	MyOrderService myOrderDao;
	
	@RequestMapping(value = "loadOrder", method = RequestMethod.GET, produces = { MimeTypeUtils.APPLICATION_JSON_VALUE })
	public ResponseEntity<MyOrder> loadOrder()
	{
		System.out.println("Loading order  : ");
		//public MyOrder(long myOrderID, String orderId, String amount, String reciept, String status) {
		MyOrder entity=new MyOrder(1l, "myOrder0111", "111", "Ref00111", "Paid");
		return  new ResponseEntity<MyOrder>(entity,HttpStatus.OK);
	}
	

	
	
	@RequestMapping(value = "createOrder", method = RequestMethod.POST, produces = { MimeTypeUtils.APPLICATION_JSON_VALUE })
	public String createOrder(@RequestBody Map<String, Object> data) throws RazorpayException
	{
		 System.out.println("Hey Order Function done DD");
		 System.out.println("Data : " + data);
		int amt = Integer.parseInt(data.get("amount").toString());
		
		RazorpayClient razorpayClient = new RazorpayClient("rzp_test_AYmnbDejMPggEF", "CNyBwr3Nhi57e50GPEb9Br56"); 
		JSONObject options = new JSONObject(); 
		options.put("amount", amt*100); 
		options.put("currency", "INR"); 
		options.put("receipt", "txn_123456"); 
		Order order = razorpayClient.Orders.create(options);
		System.out.println(order);
		
		// need to save in your database for future use
		MyOrder entity=new MyOrder();
		entity.setMyOrderID(0);
		entity.setAmount(order.get("amount")+"");
		entity.setOrderId(order.get("id"));
		entity.setPaymentId(null);
		entity.setStatus("Created");
		//entity.setUser("User")
		entity.setReciept(order.get("receipt"));
		
		myOrderDao.saveMyOrder(entity);
		
		// return "done : "+amt;
	//	MyOrder entity=new MyOrder(1l, "myOrder1234", "100", "Ref001201", "Paid");
	//			entity.setAmount(amt+"");
		return order.toString();
	}

	@RequestMapping(value = "updateOrder", method = RequestMethod.POST, produces = { MimeTypeUtils.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> updateOrder(@RequestBody Map<String, Object> data)
	{
		System.out.println("updating the status of payment ");
		MyOrder order=myOrderDao.findByOrderId(data.get("order_id").toString());
		
		order.setPaymentId(data.get("payment_id").toString());
		order.setStatus(data.get("status").toString());
		
		myOrderDao.saveMyOrder(order);		
		
		
		return ResponseEntity.ok(Map.of("msg","updated"));
	}
	
	/*
	@RequestMapping(value = "demo1", method = RequestMethod.GET, produces = { MimeTypeUtils.TEXT_PLAIN_VALUE })
	public ResponseEntity<String> demo1() {
		try {
			ResponseEntity<String> responseEntity = new ResponseEntity<String>("Demo 1", HttpStatus.OK);
			return responseEntity;
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "demo2/{fullName}", method = RequestMethod.GET, produces = {
			MimeTypeUtils.TEXT_PLAIN_VALUE })
	public ResponseEntity<String> demo2(@PathVariable("fullName") String fullName) {
		try {
			ResponseEntity<String> responseEntity = new ResponseEntity<String>("Hi " + fullName, HttpStatus.OK);
			return responseEntity;
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "demo3", method = RequestMethod.GET, produces = { MimeTypeUtils.APPLICATION_JSON_VALUE })
	public ResponseEntity<Product> demo3() {
		try {
			ProductModel productModel = new ProductModel();
			ResponseEntity<Product> responseEntity = new ResponseEntity<Product>(productModel.find(), HttpStatus.OK);
			return responseEntity;
		} catch (Exception e) {
			return new ResponseEntity<Product>(HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "demo4", method = RequestMethod.GET, produces = { MimeTypeUtils.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<Product>> demo4() {
		try {
			ProductModel productModel = new ProductModel();
			ResponseEntity<List<Product>> responseEntity = new ResponseEntity<List<Product>>(productModel.findAll(),
					HttpStatus.OK);
			return responseEntity;
		} catch (Exception e) {
			return new ResponseEntity<List<Product>>(HttpStatus.BAD_REQUEST);
		}
	}
	@RequestMapping(value = "demo5", method = RequestMethod.GET, produces = { MimeTypeUtils.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<Product>> demo5() {
		try {
			ProductModel productModel = new ProductModel();
			ResponseEntity<List<Product>> responseEntity = new ResponseEntity<List<Product>>(productModel.findAll(),
					HttpStatus.OK);
			return responseEntity;
		} catch (Exception e) {
			return new ResponseEntity<List<Product>>(HttpStatus.BAD_REQUEST);
		}
	}
  */
}