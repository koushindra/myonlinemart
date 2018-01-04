
<%@page import="com.info.model.OrderModel"%>
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

input,select { 
	width: 100%; 
	margin-bottom: 10px; 
	background: rgba(0,0,0,0.3);
	border: none;
	outline: none;
	padding: 10px;
	font-size: 13px;
	color: #fff;
	text-shadow: 1px 1px 1px rgba(0,0,0,0.3);
	border: 1px solid rgba(0,0,0,0.3);
	border-radius: 4px;
	box-shadow: inset 0 -5px 45px rgba(100,100,100,0.2), 0 1px 1px rgba(255,255,255,0.2);
	-webkit-transition: box-shadow .5s ease;
	-moz-transition: box-shadow .5s ease;
	-o-transition: box-shadow .5s ease;
	-ms-transition: box-shadow .5s ease;
	transition: box-shadow .5s ease;
}
input:focus { box-shadow: inset 0 -5px 45px rgba(100,100,100,0.4), 0 1px 1px rgba(255,255,255,0.2); }

    </style>
	<script type="text/javascript" src="bootstrap/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="bootstrap/js/jquery.js"></script>
	<script type="text/javascript" src="bootstrap/js/jquery-1.9.1.js"></script>



</head>

<body>

<%
	String loginFlag = (String)session.getAttribute("loginFlag");
	if(loginFlag==null || "false".equals(loginFlag))
	{
		request.setAttribute("loginStatus", "Please login to continue...");
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		
		rd.forward(request, response);
	}
%>	




<script type="text/javascript">


$(document).ready(function(){
	$("#adduserBtn").click(function(){
		$(".adduser").show("slow");
		$(".addItem").hide("slow");
		$(".orderDiv").hide("slow");
	});
	
	$("#addItemBtn").click(function(){
		$(".adduser").hide("slow");
		$(".addItem").show("slow");
	});
	
	$("#orderBtn").click(function(){
		$(".adduser").hide("slow");
		$(".addItem").hide("slow");
		$(".orderDiv").show("slow");
	});
	
	
});
</script>

<nav class="navbar navbar-default">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">Online Library</a>
    </div>
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav navbar-right">
       		<li><a href="#" id="adduserBtn">Add/View user</a></li>
       		<li><a href="#" id="addItemBtn">Add/Remove item</a></li>
       		<li><a href="#" id="orderBtn">View order</a></li>
           <li><a href="Logout">Logout</a></li>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>

<div class="container-fluid" >
	
	
	<div class="row adduser"style="display: none;">
		<div class=" col-lg-4">
		<h4 style="color: white;">Add Details</h4>
		<hr>
		<form action="AddUser" method="post">
			<input type="text"  placeholder="name..." name="name">
			<input type="number"  placeholder="mobile..." name="mobile">
			
			<input type="text"  placeholder="Shop no..." name="shopno">
			<input type="text"  placeholder="location..." name="location">
	
			
			<input type="text"  placeholder="username..." name="username">
			<input type="password"  placeholder="password..." name="password">
			<input type="submit" class="btn btn-default btn-block" value="Save it...">
		</form>
		<hr>
		</div>
		
		
		<div class="col-lg-8" >
		<h4 style="color: white;">View And Remove</h4>
		<hr>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>Sl.no</th>
						<th>Name</th>
						<th>Mobile</th>
						
						<th>Shop no.</th>
						<th>location</th>
						
						<th>Username</th>
						<th>password</th>
						
						<th>Action</th>
						
					</tr>
				</thead>
				<tbody >
					<%
					int count=1;
			        	ArrayList<UserModel> userDb=(ArrayList<UserModel>)session.getAttribute("userDb");
			        	if(userDb!=null)
			        	{
			        		for(UserModel show: userDb)
			        		{
			        			%>
			        			<tr>
			        				<td><%=count++ %></td>
			        				<td><%=show.getName()%></td>
			        				<td><%=show.getMobile()%></td>
			        				<td><%=show.getShopno()%></td>
			        				<td><%=show.getLocation()%></td>
			        				<td><%=show.getUsername()%></td>
			        				<td><%=show.getPassword()%></td>
			        				<td>
                                 		<a href="<%=application.getContextPath()%>/Removeuser?typeID=<%=show.getId()%>">
                                         	<button type="button" class="btn btn-danger btn-xs">Remove</button>
                                     	</a>
			        				</td>
			        			</tr>
			        			<%
			        		}
			        	}
			        %>
				</tbody>
				
			</table>
			<hr>
		</div>
	</div>
	
	
	
	
	
	
	
	
	
	
	
	
	
	<div class="row addItem"style="display: none;">
		<div class=" col-lg-4">
		<h4 style="color: white;">Add Details</h4>
		<hr>
		<form action="AddItemAdmin" method="post" enctype="multipart/form-data">
			<input type="text"  placeholder="name..." name="name">
			
			<select name="cat">
				<option value="Dairy Prodect">Dairy Prodect</option>
				<option>cloth</option>
				<option>Daily Use</option>
			</select>
			
			<input type="number"  placeholder="Price..." name="price">
			
			<select name="Pcat">
				<option>KG</option>
				<option>PCS</option>
			</select>
			
			<input type="number"  placeholder="Qwntitey..." name="qwt">
			
			<input type="text"  placeholder="Shop no..." name="shopno" value="OnlineMart" readonly="readonly">
			<input type="text"  placeholder="location..." name="location" value="OnlineMart" readonly="readonly">
	
			
			<input type="file"  placeholder="image..." name="image">
			<input type="text"  placeholder="descraption..." name="desc">
			<input type="submit" class="btn btn-default btn-block" value="Save it...">
			<BR><BR>
		</form>
		<hr>
		</div>
		
		
		<div class="col-lg-8" >
		<h4 style="color: white;">View And Remove</h4>
		<hr>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>Sl.no</th>
						<th>Name</th>
						<th>Price</th>
						<th>Shop no./location</th>
						<th>Quantity</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody >
					<%
					int count1=0;
			        	ArrayList<ItemModel> itemDb=(ArrayList<ItemModel>)session.getAttribute("itemDb");
			        	if(itemDb!=null)
			        	{
			        		for(ItemModel show: itemDb)
			        		{
			        			
			        			%>
			        			<tr>
			        				<td><%=count1++%></td>
			        				<td><%=show.getName()%></td>
			        				<td><%=show.getPrice()%>/<%=show.getpCat()%></td>
			        				<td><%=show.getShopno()%>/<%=show.getLocation()%></td>
			        				<td><%=show.getQyt()%></td>
			        				<td>
                                 		<a href="<%=application.getContextPath()%>/RemoveItemAdmin?typeID=<%=show.getId()%>">
                                         	<button type="button" class="btn btn-danger btn-xs">Remove</button>
                                     	</a>
			        				</td>
			        			</tr>
			        			<%
			        		}
			        	}
			        %>
				</tbody>
				
			</table>
			<hr>
		</div>
	</div>
	
	
	
	
	
	
	
	
	
<div class="row orderDiv" style="display: none;">


		<div class="col-lg-8" >
		<h4 style="color: white;">View And Remove</h4>
		<hr>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>Sl.no.</th>
						<th>Name</th>
						<th>Mobile</th>
						<th>Email.</th>
						<th>Address</th>
						<th>Tottal</th>
						<th>Action</th>
						
					</tr>
				</thead>
				<tbody >
					<%
					int count2=1;
			        	ArrayList<OrderModel> orderDb=(ArrayList<OrderModel>)session.getAttribute("orderDb");
			        	if(orderDb!=null)
			        	{
			        		for(OrderModel show: orderDb)
			        		{
			        			%>
			        			<tr>
			        				<td><%=count2++%></td>
			        				<td><%=show.getName()%></td>
			        				<td><%=show.getMobile()%></td>
			        				<td><%=show.getEmail()%></td>
			        				<td><%=show.getAddress()%></td>
			        				<td><%=show.getTotal()%></td>
			        				<td>
                                 		<a href="<%=application.getContextPath()%>/RemoveOrder?typeID=<%=show.getId()%>">
                                         	<button type="button" class="btn btn-danger btn-xs">Remove</button>
                                     	</a>
			        				</td>
			        			</tr>
			        			<%
			        		}
			        	}
			        %>
				</tbody>
				
			</table>
			<hr>
		</div>
</div>
	
	
	
	
</div>


</body>
</html>
