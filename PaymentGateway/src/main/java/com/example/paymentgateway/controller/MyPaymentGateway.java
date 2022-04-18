package com.example.paymentgateway.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/*import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;*/
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.paymentgateway.entity.MyOrder;


@Controller
public class MyPaymentGateway {

	Logger  logger= LoggerFactory.getLogger(MyPaymentGateway.class);
	
	@RequestMapping(value="/pay", method = RequestMethod.GET)
	public String pay(ModelMap model)
	{
		String resultData="";
		
		try {
			resultData="pay";		
			model.addAttribute("myOrder", new MyOrder());  
		} catch (Exception e) {			
			resultData="error";			
		
		}
		
		logger.error("Testing of Log4j");	
		return resultData;
	}

	
/*
 * private String getPrincipal(){ String userName = null; Object principal =
 * SecurityContextHolder.getContext().getAuthentication().getPrincipal();
 * System.out.println("Enter in getPrincipal() : AppController " );
 * 
 * if (principal instanceof UserDetails) { userName =
 * ((UserDetails)principal).getUsername(); } else { userName =
 * principal.toString(); }
 * System.out.println("Exit from getPrincipal() : AppController " );
 * 
 * return userName; }
 */
}
