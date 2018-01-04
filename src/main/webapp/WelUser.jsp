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

input ,select{ 
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

System.out.println(" loginFlag : "+loginFlag);

	if(loginFlag==null || "false".equals(loginFlag)||"true"!=loginFlag)
	{
		request.setAttribute("loginStatus", "Please login to continue...");
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		
		rd.forward(request, response);
	}
%>

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
       		<li><a href="#" id="addItemBtn">Add/Remove item</a></li>
       		
       			<li><a href="ItemMenuList" >New Order</a></li>
       		
       		<li><a href="#" id="aretisbookBtn">View order</a></li>
       		<li><a href="Logout">Logout</a></li>
       		
       		
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>


<script type="text/javascript">


$(document).ready(function(){
	$("#adduserBtn").click(function(){
		$(".adduser").show("slow");
		$(".ddItem").hide("slow");
	});
	
	$("#addItemBtn").click(function(){
		$(".adduser").hide("slow");
		$(".addItem").show("slow");
	});
});
</script>

<div class="container-fluid">


<%
String userId=(String)session.getAttribute("userId");
String shopNo=(String)session.getAttribute("shopNo");
String location=(String)session.getAttribute("location");
%>

	<div class="row addItem"style="display: none;">
		<div class=" col-lg-4">
		<h4 style="color: white;">Add Details</h4>
		<hr>
		<form action="AddItem" method="post" enctype="multipart/form-data">
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
			<input type="text"  placeholder="Shop no..." name="shopno" value="<%=shopNo%>" readonly="readonly">
			<input type="text"  placeholder="location..." name="location" value="<%=location%>" readonly="readonly">
			
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
						<th>Name</th>
						<th>Price</th>
						<th>Shop no./location</th>
						<th>Quantity</th>
						<th>Action</th>
					</tr>
				</thead>
				<tbody >
					<%
			        	ArrayList<ItemModel> itemDb=(ArrayList<ItemModel>)session.getAttribute("itemDb");
			        	if(itemDb!=null)
			        	{
			        		for(ItemModel show: itemDb)
			        		{
			        			String id=show.getId();
			        			
			        			if(userId.equals(id))
			        			{
			        			%>
			        			<tr>
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