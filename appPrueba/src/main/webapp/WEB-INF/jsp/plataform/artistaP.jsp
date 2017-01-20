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
		<title>Artistas Según Género</title>
		<link href="<c:url value="/css/style.css" />" rel="stylesheet" type="text/css"  media="all" />
		<link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>
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
						<li  class="active"><a href="../artistaCategoriaP">Artistas</a></li>
						
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
					<a href="index.html"><img src="<c:url value="/images/logo.png" />" title="logo" /></a>
				</div>
				<div class="sub-header-center">
					<form>
						<input type="text"><input type="submit"  value="buscar" />
					</form>
				</div>
				<div class="sub-header-right">
					<ul>
						<li><a href="">Mi perfil</a></li>
						<li><a href="../security">Logout</a></li>
						
					</ul>
				</div>
				<div class="clear"> </div>
			</div>
			<div class="clear"> </div>
			<div class="top-nav">
				<ul>
					<li><a href="../plataform">Home</a></li>
						<li class="active1"><a href="../artistaCategoriaP">Artistas</a></li>
						
						<li><a href="#">Contacto</a></li>
						<div class="clear"></div>
				</ul>
			</div>
			<!---end-top-header--->
			<!---End-header--->
			</div>
				<div class="content">
					<!--start-cartires-page---->
					<div class="Cartires">
						<h5><span>ARTISTAS</span> SEGÚN GÉNERO</h5>
						<div class="cartires-grids">
						
						
							<!-- |||||||||||||||||||||||||||-->
					<c:forEach items="${artistas}" var="artistas">
							<div class="cartire-grid">
								<div class="cartire-grid-img">
									<img src="<c:url value="/images/a1.jpg" />" title="tries" />
								</div>
								
								<div class="cartire-grid-info">
									<ul>
										<li><span><c:out value="${artistas.nombreArtista}" /></span></li>
									</ul>


								</div>
								<div class="cartire-grid-cartinfo">

									<ul>

									</ul>
									
										</div>
								
								
								<div class="clear"> </div>
							</div><br />
							</c:forEach>
							

			<!--||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||-->

						
						</div>
					</div>
					<!--End-cartires-page---->
				</div>


	









			<div class="clear"> </div>
		</div>
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
				<div class="col_1_of_4 span_1_of_4">
					<h3>YOUR ACCOUNT</h3>
					<ul>
						<li><a href="#">Your Account</a></li>
						<li><a href="#">Personal info</a></li>
						<li><a href="#">Prices</a></li>
						<li><a href="#">Address</a></li>
						<li><a href="#">Locations</a></li>
					</ul>
				</div>
				<div class="col_1_of_4 span_1_of_4 footer-lastgrid">
					<h3>Get in touch</h3>
					<ul>
						<li><a href="#"><img src="images/facebook.png" title="facebook" /></a></li>
						<li><a href="#"><img src="images/twitter.png" title="Twiiter" /></a></li>
						<li><a href="#"><img src="images/rss.png" title="Rss" /></a></li>
						<li><a href="#"><img src="images/gpluse.png" title="Google+" /></a></li>
					</ul>
					<p>Design by <a href="#">W3layouts</a></p>
				</div>
			</div>
			</div>
		</div>
		<!---End-wrap--->
	</body>
</html>