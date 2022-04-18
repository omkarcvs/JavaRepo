<%-- <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> --%>

<!DOCTYPE html>
<html>
<head>

<title>Payment Gateway</title>

<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!--   <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"> -->
<%-- <link href="<c:url value='/static/css/dist461/bootstrap.min.css' />" rel="stylesheet"></link>  --%>

	
<%-- 	<script src="<c:url value='/static/js/jquery.min.js'/>"></script> --%>
<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script> -->
 <script
  src="https://code.jquery.com/jquery-3.6.0.min.js"
  integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
  crossorigin="anonymous"></script>
<%-- <script src="<c:url value='/static/js/mypayment.js'/>"></script> --%>

<style>
table, th, td {
  border: 1px solid black;
  border-collapse: collapse;
   width: 35%;
}

table.center {
  margin-left: auto; 
  margin-right: auto;
}
</style>




<style>
input[type=text], select {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}

input[type=submit] {
  width: 100%;
  background-color: #4CAF50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

input[type=submit]:hover {
  background-color: #45a049;
}

div {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
}
</style>
<script src="https://checkout.razorpay.com/v1/checkout.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	 //alert('tttt');
	  $('#paymentButton').click(function() {
		
			console.log("Payment started ....");
			var amount=$('#payment_field').val();
			 
			console.log(amount);
			if(amount=="" || amount == null) {
				alert("Amount is required !! tt");
				return; 
			}			
			
			
			$.ajax({
				
				url : '/createOrder',
				type : 'POST',
				data : JSON.stringify({amount:amount, info: "order_request"}),	
				dataType : 'json',
				contentType : 'application/json',
				success : function(response) {
					//alert(' success => amount : '+amount);	
					console.log(response);
					
					//opening form
					
					var options = { 
							"key": "rzp_test_AYmnbDejMPggEF", // Enter the Key ID generated from the Dashboard
							"amount": response.amount, // Amount is in currency subunits. Default currency is INR. Hence, 50000 refers to 50000 paise 
							"currency": "INR", 
							"name": "Omkar Payment Test", 
							"description": "Test Transaction",
							"image": "http://localhost:8085/static/images/logo.jpg", 
							"order_id": response.id, //This is a sample Order ID. Pass the `id` obtained in the response of Step 1 
							"handler": function (response){ 
								console.log(response.razorpay_payment_id); 
								console.log(response.razorpay_order_id); 
								console.log(response.razorpay_signature) 								
								console.log("Payment successfull!! ");	
								
								 updatePaymentOnServer(
										response.razorpay_payment_id,
										response.razorpay_order_id,
										"paid"
							   ); 
								
							//	alert("Congrates Payment successfull!! ");	
							}, 
							"prefill": { 
								"name": "", 
								"email": "", 
								"contact": ""
							/* 	
									"name": "Omkar Singh", 
									"email": "omkarsingh.ohm@gmail.com", 
									"contact": "8285907154"  */
							}, 
							"notes": { 
								"address": "Razorpay Corporate Office"
							},
							"theme": {
								 "color": "#3399cc" 
								 } 
							};
					
					
					
					var rzp = new Razorpay(options); 
					rzp.on('payment.failed', function (response){ 
						console.log(response.error.code); 
						console.log(response.error.description); 
						console.log(response.error.source); 
						console.log(response.error.step); 
						console.log(response.error.reason); 
						console.log(response.error.metadata.order_id); 
						console.log(response.error.metadata.payment_id); 
						alert("Opps Payment Failed !! ");	
					});
					
					rzp.open();
					//end form 
					
					
				},
				error: function(e){
					alert('Failed'+amount);
					console.log(JSON.stringify({amount:amount, info: "order_request"}));
			   }
				
			 
			});	
			
			
	});
});
 
function updatePaymentOnServer(payment_id,order_id,status)
{
	  $.ajax({		
		url : '/updateOrder',
		type : 'POST',
		data : JSON.stringify({
			payment_id:payment_id, 
			order_id: order_id,
			status:status
		}),	
		dataType : 'json',
		contentType : 'application/json',
		
		success : function(response) {
			//alert(' success => amount : '+amount);	
			console.log(response);
			
			
			alert("Congrates Payment successfull!! ");	
		},
	   error: function(e){
			alert("Your Payment is successfull, but we did not capture it we will contact you as soon as possible ");	
			
	   }
		
		
		
	  });
}
 

</script>
<script type="text/javascript">
/* $(document).ready(function() {
	    $('#paymentButton').click(function() {
	    	
	    	var amount = $('#payment_field').val();
	    	
	    	//document.getElementById('createOrderID').submit();
	    	//alert('payment_field : '+payment_field);
	    	//var departmentId = $('#departmentId').val();
	    	 
			  $.ajax({
				type : 'POST',
				url : '/bts-app-ws/bts/api/ajaxrest/createOrder',
				dataType : 'json',
				contentType : 'application/json',
				
				success : function(result) {
					
					alert(' success : ');	
					
				},
				error: function(e){
					
					alert('Failed');
			   }
				
			 
			});  
		});
	}); */
</script>

</head>
<body>
<div>
	<div>
		<jsp:include page="index.jsp" />
	</div>
	<div>
	<!-- <form method="POST" action="/createOrder" id="createOrderID"> -->
			  <table  class="center">
			  <tr><td>
				  		<!-- <div class="container" > -->
					        <h3 class="my-3">Implementing Payment Gateway</h3>
					                                                                                              
							        <label for="invoiceDate" class="col-sm-6 col-form-label">Donate Us</label>
							      <input type="text" id="payment_field" name="amount" value="10" placeholder="Enter amount here" required="required" step="any" min="0"/> 
							   
							        <br>
							<div class="text-center">		      
							       <button id="paymentButton"class="btn btn-success form-control">Pay</button> 
							</div> 
					      <!--  </div>	 -->				  
					      
					
			 </td></tr>
			 </table>
<!-- </form>  -->
	 </div>		 
</div>
</body>
</html>