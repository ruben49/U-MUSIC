<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--
Author: W3layouts
Author URL: http://w3layouts.com
License: Creative Commons Attribution 3.0 Unported
License URL: http://creativecommons.org/licenses/by/3.0/
-->
<!DOCTYPE HTML>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>U-MUSIC</title>
		<link href="<c:url value="/css/style.css" />" rel="stylesheet" type="text/css"  media="all" />
		<link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>
		<link rel="stylesheet" href="<c:url value="/css/responsiveslides.css" />">
		<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
		<script src="<c:url value="/js/responsiveslides.min.js" />"></script>
		  <script>
		    // You can also use "$(window).load(function() {"
			    $(function () {
			
			      // Slideshow 1
			      $("#slider1").responsiveSlides({
			        maxwidth: 1600,
			        speed: 600
			      });
			});
		  </script>
	</head>
	<body>
		<!---start-wrap--->
		<div class="wrap">
			<!---start-header--->
			<div class="header">
			<!---start-top-header--->
			<div class="top-header">
				<div class="top-header-left">
					<ul>
						<li><a href="../plataform">Home</a></li>
						<li  class="active"><a href="#">Artistas</a></li>
						
						<li><a href="#">Contacto</a></li>
					</ul>
				</div>
				<div class="top-header-right">

				</div>
				<div class="clear"> </div>
			</div>
			<div class="clear"> </div>
			<div class="sub-header">
				<div class="logo">
					<a href="home"><img src="<c:url value="/images/logo.png" />" title="logo" /></a>
				</div>

				<div class="sub-header-center">
					<form>
						<input type="text"><input type="submit"  value="Buscar" />
					</form>
				</div>


				<div class="sub-header-right">
					<ul>
						<li><a href="">Mi perfil</a></li>
						<li><a href="security">Logout</a></li>
			 		</ul>
				</div>
				<div class="clear"> </div>
			</div>
			<div class="clear"> </div>
			<div class="top-nav">
				<ul>
					<li ><a href="plataform">Home</a></li>
					<li class="active1"><a href="#">Artistas</a></li>
					
					<li><a href="#">Contacto</a></li>
					<div class="clear"> </div>
				</ul>
			</div>
			<!---end-top-header--->
			<!---End-header--->
			</div>
			

			<div class="content" style="height: 150px">
			
					<ul>
						<c:forEach items="${datos}" var="datos">
							<li class="active3" style="margin-left: 20px;margin-top:10px; float:left;"><a href="plataform/artistaP?idGenero=<c:out value="${datos.idGenero}" />"><c:out value="${datos.descripcionGenero}" /></a></li>
							
						</c:forEach>
						<div class="clear"> </div>
					</ul>
			
			</div>	





				</div>
			</div>
		</div>
			<div class="clear"> </div>
			<div class="footer">
				<div class="wrap">
				<div class="section group">
				<div class="col_1_of_4 span_1_of_4">
					<h3>INFORMATION</h3>
					<ul>
						<li><a href="#">About us</a></li>
						<li><a href="#">Sitemap</a></li>
						<li><a href="#">Contact</a></li>
						<li><a href="#">Terms and conditions</a></li>
						<li><a href="#">Legal Notice</a></li>
					</ul>
				</div>
				<div class="col_1_of_4 span_1_of_4">
					<h3>OUR OFFERS</h3>
					<ul>
						<li><a href="#">New products</a></li>
						<li><a href="#">top sellers</a></li>
						<li><a href="#">Specials</a></li>
						<li><a href="#">Products</a></li>
						<li><a href="#">Comments</a></li>
					</ul>
				</div>


			</div>
			</div>
		</div>
		<!---End-wrap--->
	</body>
</html>
