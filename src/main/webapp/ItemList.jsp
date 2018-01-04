<%@page import="com.info.model.ItemModel"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="shortcut icon" href="assets/images/requirement-for-dealers-distributers-for-online-shopping-ak-1647934259-249x128.jpg" type="image/x-icon">
  <meta name="description" content="Web Page Builder Description">
  <title>Web Page Builder Title</title>
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic&amp;subset=latin">
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat:400,700">
  <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i">
  <link rel="stylesheet" href="assets/bootstrap-material-design-font/css/material.css">
  <link rel="stylesheet" href="assets/tether/tether.min.css">
  <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
  <link rel="stylesheet" href="assets/dropdown/css/style.css">
  <link rel="stylesheet" href="assets/animate.css/animate.min.css">
  <link rel="stylesheet" href="assets/socicon/css/styles.css">
  <link rel="stylesheet" href="assets/theme/css/style.css">
  <link rel="stylesheet" href="assets/mobirise/css/mbr-additional.css" type="text/css">
  
  
  
</head>
<body>

<script>
		function createXMLHttp()
		{
			var xmlhttp = null;
			if (window.XMLHttpRequest)
			{   // code for IE7+, Firefox, Chrome, Opera, Safari
				xmlhttp=new XMLHttpRequest();
			}
			else
			{   // code for IE6, IE5
				xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
			}
			return xmlhttp;
		}
		var xmlhttp = createXMLHttp();
		function changeOption()
		{
			var str = document.getElementById("itemOption").value;	
			xmlhttp.open("GET","fetchItemList.jsp?itemOption="+str,true);		  
			xmlhttp.onreadystatechange=dataHandler;
			xmlhttp.send();
		}

		function dataHandler()
		{
			if (xmlhttp.readyState==4)
			{
				if(xmlhttp.status==200)
				{				
					document.getElementById("itemDiv").innerHTML=xmlhttp.responseText;			
				}
			}
		}


    </script>

<section id="ext_menu-8">

    <nav class="navbar navbar-dropdown navbar-fixed-top">
        <div class="container">

            <div class="mbr-table">
                <div class="mbr-table-cell">

                    <div class="navbar-brand">
                        <span class="navbar-logo"><img src="assets/images/requirement-for-dealers-distributers-for-online-shopping-ak-1647934259-249x128.jpg" alt="Mobirise"></span>
                        <a class="navbar-caption" href="wel.jsp">ONLINE MART</a>
                    </div>

                </div>
                <div class="mbr-table-cell">

                    <button class="navbar-toggler pull-xs-right hidden-md-up" type="button" data-toggle="collapse" data-target="#exCollapsingNavbar">
                        <div class="hamburger-icon"></div>
                    </button>

                    <ul class="nav-dropdown collapse pull-xs-right nav navbar-nav navbar-toggleable-sm" id="exCollapsingNavbar">

        			<li class="nav-item nav-btn">
						<a class="nav-link btn btn-white btn-white-outline" href="ItemList.jsp">Menu List</a>
					</li>
					
                    <li class="nav-item nav-btn"><a class="nav-link btn btn-white btn-white-outline" href="CartList">cart</a></li>
                    
                    
                    
                     <li class="nav-item nav-btn"><a class="nav-link btn btn-white btn-white-outline" href="Logout">Logout</a></li>
                    
                    
                    </ul>
                    <button hidden="" class="navbar-toggler navbar-close" type="button" data-toggle="collapse" data-target="#exCollapsingNavbar">
                        <div class="close-icon"></div>
                    </button>

                </div>
            </div>

        </div>
    </nav>

</section>

<section class="engine"><a rel="external" href="https://mobirise.com">Site Maker</a></section><section class="mbr-section article mbr-parallax-background mbr-after-navbar" id="msg-box8-a" style="background-image: url(assets/images/download-2000x13341.jpg); padding-top: 120px; padding-bottom: 120px;">

    <div class="mbr-overlay" style="opacity: 0.5; background-color: rgb(34, 34, 34);">
    </div>
    <div class="container">
        <div class="row">
            <div class="col-md-8 col-md-offset-2 text-xs-center">
                <h3 class="mbr-section-title display-2">Our Menu List</h3>
                <div class="lead"><p>Article header with background image and parallax effect.</p></div>
                
            </div>
        </div>
    </div>

</section>

<section class="mbr-section mbr-section__container article" id="header3-b" style="background-color: rgb(193, 193, 193); padding-top: 20px; padding-bottom: 20px;">
    <div class="container">
        <div class="row">
            <div class="col-xs-12">
                <h3 class="mbr-section-title display-2">Filter with your choice........</h3>
                <small class="mbr-section-subtitle"></small>
                <select class="form-control" onchange="changeOption()" id="itemOption">
                	<option>Dairy Prodect</option>
					<option>cloth</option>
					<option>Daily Use</option>
                </select>
            </div>
        </div>
    </div>
</section>



<section class="mbr-cards mbr-section mbr-section-nopadding" id="features3-5" style="background-color: rgb(255, 255, 255);">

    

    <div class="mbr-cards-row row" id="itemDiv">
        <%
        	ArrayList<ItemModel> itemDb=(ArrayList<ItemModel>)session.getAttribute("itemDb");
        	if(itemDb!=null)
        	{
        		for(ItemModel show: itemDb)
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
        %>
    </div>
</section>



<section class="mbr-section mbr-section-md-padding mbr-footer footer1" id="contacts1-6" style="background-color: rgb(193, 193, 193); padding-top: 90px; padding-bottom: 90px;">
    
    <div class="container">
        <div class="row">
            <div class="mbr-footer-content col-xs-12 col-md-3">
                <div><img src="assets/images/requirement-for-dealers-distributers-for-online-shopping-ak-1647934259-128x65.jpg"></div>
            </div>
            <div class="mbr-footer-content col-xs-12 col-md-3">
                <p><strong>ABOUTUS</strong><br><br>innovation is defined as the translation of knowledge and technologies in the form of newer and better products and services. Being innovative adds value to our graduates' education and training, which gives them the extra edge and ultimately increases their employability.<br></p>
            </div>
            <div class="mbr-footer-content col-xs-12 col-md-3">
                <p><font color="#000000"><strong>ONLINE SHOPPING MART</strong></font><br><br>Corporate Resource Centre<br>Our Recruiters<br>Placements Records<br>Corporate Advisory Board<br>Industrial VisitT<br></p>
            </div>
            <div class="mbr-footer-content col-xs-12 col-md-3">
                <p><strong>CONTACT US</strong><br><br>Plot No. 2, Knowledge Park III, G. Noida Distt. Gautam Budh Nagar, U.P., India<br>Ph: 0120- 3272515 / 2323818 | Fax: 0120-2323817<br>Mobile : 9891591875 8750610005, 8750620005<br>E mail :&nbsp;<br></p>
            </div>

        </div>
    </div>
</section>

<section class="mbr-section mbr-section-md-padding" id="social-buttons4-7" style="background-color: rgb(46, 46, 46); padding-top: 90px; padding-bottom: 90px;"> 
    <div class="container">
        <div class="row">
            <div class="col-md-8 col-md-offset-2 text-xs-center">
                <h3 class="mbr-section-title display-2">FOLLOW US</h3>
                <div><a class="btn btn-social" title="Twitter" target="_blank" href="https://twitter.com/"><i class="socicon socicon-twitter"></i></a> 
				<a class="btn btn-social" title="Facebook" target="_blank" href="https://www.facebook.com/"><i class="socicon socicon-facebook"></i></a> 
				<a class="btn btn-social" title="Google+" target="_blank" href="https://plus.google.com/"><i class="socicon socicon-googleplus"></i></a> 
				<a class="btn btn-social" title="YouTube" target="_blank" href="https://www.youtube.com/"><i class="socicon socicon-youtube"></i></a>    
				<a class="btn btn-social" title="LinkedIn" target="_blank" href="https://www.linkedin.com/"><i class="socicon socicon-linkedin"></i></a>   
				</div>
            </div>
        </div>
    </div>
</section>
  <script src="assets/web/assets/jquery/jquery.min.js"></script>
  <script src="assets/tether/tether.min.js"></script>
  <script src="assets/bootstrap/js/bootstrap.min.js"></script>
  <script src="assets/smooth-scroll/smooth-scroll.js"></script>
  <script src="assets/dropdown/js/script.min.js"></script>
  <script src="assets/touch-swipe/jquery.touch-swipe.min.js"></script>
  <script src="assets/viewport-checker/jquery.viewportchecker.js"></script>
  <script src="assets/jarallax/jarallax.js"></script>
  <script src="assets/theme/js/script.js"></script>
  
  
  <input name="animation" type="hidden">
  </body>
</html>