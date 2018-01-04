
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

<%-- <%
	String loginFlag = (String)session.getAttribute("loginFlag");
	if(loginFlag==null || "false".equals(loginFlag))
	{
		request.setAttribute("loginStatus", "Please login to continue...");
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		
		rd.forward(request, response);
	}
%>	 --%>







<div class="container-fluid" >
	
	
	<div class="row ">
		<div class=" col-lg-4 col-lg-offset-4" style="margin-top: 150px;">
		<h4 style="color: white;">Add Details</h4>
		<hr>
		<form action="SignUp" method="post">
			<input type="text"  placeholder="name..." name="name">
			<input type="number"  placeholder="mobile..." name="mobile">
			
			<input type="text"  placeholder="Email id..." name="Email">
			<input type="text"  placeholder="location..." name="location">
	
			<input type="text"  placeholder="username..." name="username">
			<input type="password"  placeholder="password..." name="password">
			<input type="submit" class="btn btn-default btn-block" value="Save it...">
		</form>
		<hr>
		</div>
	</div>
	

	
	
	
	
	
	
	
	
	
	
	
	
	
</div>


</body>
</html>
