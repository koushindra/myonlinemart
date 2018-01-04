<%@page import="com.info.model.ItemModel"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>




 <%
 String itemOption=request.getParameter("itemOption");
 
        	ArrayList<ItemModel> itemDb=(ArrayList<ItemModel>)session.getAttribute("itemDb");
        	if(itemDb!=null)
        	{
        		for(ItemModel show: itemDb)
        		{
        			String name=show.getCat();
        			
        			System.out.println("itemOption : "+itemOption+"   name : "+name);
        			
        			if(itemOption.equalsIgnoreCase(name))
        			{
        			
        			%>
        			<div class="col-xs-12 col-lg-3" style="padding-top: 40px; padding-bottom: 40px;">
			            <div class="container">
			                <div class="card cart-block">
			                    <div class="card-img">
			                    <img src="FetchImage?id=<%=show.getId()%>" class="card-img-top" style="max-height: 250px; min-height: 250px;"></div>
			                    <div class="card-block">
			                        <h4 class="card-title"><%=show.getName()%></h4>
			                        <h5 class="card-subtitle"><%=show.getShopno()%>/<%=show.getLocation()%></h5>
			                        <p class="card-text">
			                        	Price . <%=show.getPrice()%>/<%=show.getpCat()%><br>
			                        	<%=show.getDesc() %>
			                        </p>
			                        <div class="card-btn">
                       		 <a href="<%=application.getContextPath()%>/AddInCart?id=<%=show.getId()%>" class="btn btn-primary">Add cart</a>
                        </div>
			                    </div>
			                </div>
			            </div>
			        </div>
        			<%
        		}
        			
        		
        	}
        	}
        %>


</body>
</html>