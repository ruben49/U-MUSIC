<script type="text/javascript">

		var secure = JSON.parse(localStorage.getItem('login'));
		
		if(secure != null)
		{
			location.href="plataform";
		}

</script>

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
		<title>Detalle Canción</title>
		<link href="<c:url value="/css/style.css" />" rel="stylesheet" type="text/css"  media="all" />
		<link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>
		<script src="<c:url value="/js/jquery-1.6.js" />" type="text/javascript"></script>
		<script src="<c:url value="/js/jquery.jqzoom-core.js" />" type="text/javascript"></script>
		<link rel="stylesheet" href="<c:url value="/css/jquery.jqzoom.css" />" type="text/css">
		<script type="text/javascript">
			$(document).ready(function() {
				$('.jqzoom').jqzoom({
			            zoomType: 'standard',
			            lens:true,
			            preloadImages: false,
			            alwaysOn:false
			        });
				
			});
		</script>
		<style type="text/css">
		
		</style>
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
					<li><a href="home">Home</a></li>
					
						
						<li><a href="#">Contacto</a></li>
					</ul>
				</div>

				<div class="clear"> </div>
			</div>
			<div class="clear"> </div>
			<div class="sub-header">
				<div class="logo">
					<a href="/"><img src="<c:url value="/images/logo.png" />" title="logo" /></a>
				</div>
				<div class="sub-header-center">
					<form>
						<input type="text"><input type="submit"  value="Buscar" />
					</form>
				</div>
				<div class="sub-header-right">
					<ul>
						<li><a href="login">Login</a></li>
						<li><a href="registro">Registro</a></li>
						
					</ul>
				</div>
				<div class="clear"> </div>
			</div>
			<div class="clear"> </div>
			<div class="top-nav">
				<ul>
					<li><a href="home">Home</a></li>
						
	
						<li><a href="#">Contacto</a></li>
					<div class="clear"> </div>
				</ul>
			</div>
			<!---end-top-header--->
			<!---End-header--->
			</div>
				<div class="content">
					<div class="single-page"><br />
						<div class="clear"> </div>
						<div class="product-info">
							<div class="product-image">
								<div class="clearfix" id="content" >
								    <div class="clearfix">
								        <a href="<c:url value="/images/a1.jpg" />" class="jqzoom" rel='gal1'  title="triumph" >
								            <img src="<c:url value="/images/a1-small.jpg" />"  title="triumph"  style="border: 1px solid rgba(102, 102, 102, 0.2);">
								        </a>
								    </div>
									<br/>
								 <div class="clearfix" >
									<ul id="thumblist" class="clearfix" >
									
	
										
									</ul>
									</div>
								</div>
							</div>
							<div class="product-price-info">
							<c:forEach items="${cancion}" var="cancion"> 
								<div class="product-catrgory-pagenation">
									<ul>
										<li><h3>CANCIÓN: </h3></li>
										<li class="active3"><c:out value="${cancion.nombreCancion}" /></li>

									</ul>
								</div>

								<div class="product-catrgory-pagenation">
									<ul>
										<li><h3>ALBUM: </h3></li>
										<li class="active3"><c:out value="${cancion.nombreAlbum}" /></li>

									</ul>								

								</div>


								<div class="product-catrgory-pagenation">
								<ul>
									<li><h3>ARTISTA: </h3></li>
									<li class="active3"><a href="artistaRecommend?idArtista=<c:out value="${cancion.idArtista}" />"><c:out value="${cancion.nombreArtista}" /></a></li>

								</ul>
								</div>

							</c:forEach>
								</div>


								<div class="clear"></div>
							</div>
					
					</div>
			</div>

								<div class="products">
						<h5><span>CANCIONES SIMILARES</span> SEGÚN SU VALORACIÓN</h5>
						<div class="section group">

					<c:forEach items="${listaCanciones}" var="listaCanciones">
							<div class="grid_1_of_5 images_1_of_5">
								 <img src="<c:url value="/images/a4.jpg" />">
								 <h3><c:out value="${listaCanciones.nombreCancion}" /></h3>
								 
								 
							     <div class="button"><span><a href="itemRecommend?codCancion=<c:out value="${listaCanciones.codCancion}" />">Ver Más</a></span></div>
						   </div>
 					</c:forEach>



						</div>
						
						<div class="clear"> </div>
					</div>


					<!-- |||||||||||||||||||||||||||||||||||||||-->


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

			</div>
			</div>
		</div>
		<!---End-wrap--->
	</body>
</html>








