 <%@page import="com.info.model.CartModel"%>
<%@page import="com.info.model.ItemModel"%>
<%@page import="com.info.model.UserModel"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html >
<head>
  <meta charset="UTF-8">
  <title>Login Form</title>
  
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">
  <link rel="stylesheet" type="text/css" href="<%=application.getContextPath() %>/bootstrap/css/bootstrap.css">
	<script type="text/javascript" src="<%=application.getContextPath() %>/bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="<%=application.getContextPath() %>/bootstrap/js/jquery.js"></script>
	<script type="text/javascript" src="<%=application.getContextPath() %>/bootstrap/js/jquery-1.9.1.js"></script>
	
      <style>

html { width: 100%; height:100%; }

body { 
	width: 100%;
	height:100%;
	font-family: 'Open Sans', sans-serif;
	background: #092756;
	color: white;
	
}
input,button{color: #111;}
    </style>
	<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="bootstrap/js/jquery.js"></script>
	<script type="text/javascript" src="bootstrap/js/jquery-1.9.1.js"></script>
	




</head>

<body>
<%
	String loginFlag = (String)session.getAttribute("loginFlag");

System.out.println(" loginFlag : "+loginFlag);

	if(loginFlag==null || "false".equals(loginFlag)||"true"!=loginFlag)
	{
		request.setAttribute("loginStatus", "Please login to continue...");
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		
		rd.forward(request, response);
	}
%>



<div class="container-fluid">


<%
String userId=(String)session.getAttribute("CuserId");
String name=(String)session.getAttribute("cname");
String mobile=(String)session.getAttribute("mobile");
String email=(String)session.getAttribute("email");
String address=(String)session.getAttribute("address");
int total=0;
%>

	<div class="row ">
		<div class="col-lg-8 col-lg-offset-2" >
		<h4 style="color: white;">Cart Details</h4>
		<hr>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>Item name</th>
						<th>Item Price</th>
						<th>Item pcs</th>
						<th>Total Amount</th>
					</tr>
				</thead>
				<tbody>
					<%
			        	ArrayList<CartModel> itemDb=(ArrayList<CartModel>)session.getAttribute("cartIitemDb");
			        	if(itemDb!=null)
			        	{
			        		for(CartModel show: itemDb)
			        		{
			        			String id=show.getUserid();
			        			
			        			System.out.println("user id : "+userId+" id : "+id);
			        			
			        			if(userId.equals(id))
			        			{
			        				total=total+Integer.parseInt(show.getPrice());
			        			%>
			        			
			        			<tr>
			        				<td><%=show.getItemName()%></td>
			        				<td><%=show.getPrice()%></td>
			        				<td><input type="number"  id="pcs" readonly="readonly" value="1"></td>
			        				<td><input type="number"  id="total" readonly="readonly" value="<%=show.getPrice()%>"></td>
			        			</tr>
			        			<%
			        			}
			        		}
			        	}
			        %>
				</tbody>
				
				
				<tfoot>
					
       					<tr style="background-color: gray; color: white;">
       						<td colspan="4">Your details!</td>
       					</tr>
       					<tr>
       						<td colspan="2">Enter Your Name </th>
       						<td>:</th>
       						<td><input type="text" name="name" value="<%=name%>"></th>
       				</tr>
       					
       					<tr>
       						<td colspan="2">Enter Your Mobile Number </th>
       						<td>:</th>
       						<td><input type="text" name="mobile" value="<%=mobile%>"></th>
       					</tr>
       					
       					<tr>
       						<td colspan="2">Enter Your Email </th>
       						<td>:</th>
       						<td><input type="text" name="mobile" value="<%=email%>"></th>
       					</tr>
       					
       					<tr>
       						<td colspan="2">Enter Your Address </th>
       						<td>:</th>
       						<td><input type="text" name="address" value="<%=address%>"></th>
       					</tr>
       				
       				
       					<tr>
       						<td>
       							<input type="checkbox" checked="checked" readonly="readonly">
       						</td>
       						<td>
       							Cash on delivery
       						</td>
       						<td>Total Amount </td>
       						
       						<td> <input type="text" value="<%=total%>" > </td>
       						
       					</tr>
       					<tr>
       						<td colspan="3"></td>
       						<td>
       							<form action="SaveOrderNow" method="post">
       								
	       								<button type="submit" class="btn-block">Save</button>
	       							
       							</form>
       						</td>
       					</tr>
       					
       				</tfoot>
       			
				
			</table>
			<hr>
		</div>
	</div>
	
	
	
</div>


</body>
</html>