<script type="text/javascript">

		var secure = JSON.parse(localStorage.getItem('login'));
		
		if(secure == null)
		{
			location.href="login";
		}

</script>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
						<li class="active"><a href="plataform">Home</a></li>
						<li><a href="artistaCategoriaP">Artistas</a></li>
						
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
					<li class="active1"><a href="plataform">Home</a></li>
					<li><a href="artistaCategoriaP">Artistas</a></li>
					
					<li><a href="#">Contacto</a></li>
					<div class="clear"> </div>
				</ul>
			</div>
			<!---end-top-header--->
			<!---End-header--->
			</div>
			
				<!--start-image-slider---->
					<div class="image-slider">
						<!-- Slideshow 1 -->
					    <ul class="rslides" id="slider1">
					      <li><img src="<c:url value="/images/slider1.jpg" />" alt=""></li>
					      <li><img src="<c:url value="/images/slider3.jpg" />" alt=""></li>
					      <li><img src="<c:url value="/images/slider1.jpg" />" alt=""></li>
					    </ul>
						 <!-- Slideshow 2 -->
					</div>
					<!--End-image-slider---->
				<div class="content">
					<div class="products-box">

					<div class="products">
						<h5><span>RECOMENDACIÓN DE CANCIONES: </span> VECINOS MÁS CERCANOS BASADO EN USUARIO</h5>

					
						<div class="section group">
						<c:forEach items="${listaCanciones}" var="listaCanciones">
							<div class="grid_1_of_5 images_1_of_5">
								 <img src="<c:url value="/images/a4.jpg" />">
								 <h3><c:out value="${listaCanciones.nombreCancion}"/></h3>
								 
								 
							     <div class="button"><span><a href="plataform/itemRecommend?codCancion=<c:out value="${listaCanciones.codCancion}" />">Ver Más</a></span></div>
						   </div>
					 </c:forEach>
						</div>
						
						<div class="clear"> </div>
					</div>


					<!-- ||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||-->


					<div class="products products-secondbox">
						<h5><span>RECOMENDACIÓN DE ARTISTAS: </span> VECINOS MÁS CERCANOS BASADO EN USUARIO</h5>

					
						<div class="section group">
						<c:forEach items="${listaArtistas}" var="listaArtistas">
							<div class="grid_1_of_5 images_1_of_5">
								 <img src="<c:url value="/images/a4.jpg" />">
								 <h3><c:out value="${listaArtistas.nombreArtista}"/></h3>
 
							     <div class="button"><span><a href="plataform/artistaRecommend?idArtista=<c:out value="${listaArtistas.idArtista}" />">Ver Más</a></span></div>
						   </div>
					 </c:forEach>
						</div>
						
						<div class="clear"> </div>
					</div>


					<!-- ||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||-->



					<div class="products products-secondbox">
						<h5><span>TOP 5</span> CANCIONES MÁS VALORADAS</h5>

					
						<div class="section group">
						<c:forEach items="${cancionesTop6}" var="cancionesTop6">
							<div class="grid_1_of_5 images_1_of_5">
								 <img src="<c:url value="/images/a4.jpg" />">
								 <h3><c:out value="${cancionesTop6.nombreCancion}"/></h3>
								 <p>Valoración: <c:out value="${cancionesTop6.cantidadValoraciones}"/></p>
								 
							     <div class="button"><span><a href="plataform/itemRecommend?codCancion=<c:out value="${cancionesTop6.codCancion}" />">Ver Más</a></span></div>
						   </div>
					 </c:forEach>
						</div>
						
						<div class="clear"> </div>
					</div>


					<!-- ||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||-->




					<div class="products products-secondbox">
						<h5><span>TOP 5</span> ALBUMS MÁS VALORADOS</h5>

					
						<div class="section group">
						<c:forEach items="${albumsTop6}" var="albumsTop6">
							<div class="grid_1_of_5 images_1_of_5">
								 <img src="images/a9.jpg">
								 <h3><c:out value="${albumsTop6.nombreAlbum}"/></h3>
								 <p>Valoración: <c:out value="${albumsTop6.valoracion}"/></p>
								 
							     
						   </div>
					</c:forEach>

							
						<div class="clear"> </div>
						</div>
					</div>
 					


					<!-- |||||||||||||||||||||||||||||||||||||||-->





					<div class="products products-secondbox">
						<h5><span>TOP 5</span> ARTISTAS MÁS VALORADOS</h5>
						

						<div class="section group">
						<c:forEach items="${artistaTop6}" var="artistaTop6">
							<div class="grid_1_of_5 images_1_of_5">
								 <img src="images/a9.jpg">
								 <h3><c:out value="${artistaTop6.nombreArtista}"/></h3>
								 <p><c:out value="${artistaTop6.valoracion}"/></p>
								 
							     <div class="button"><span><a href="plataform/artistaRecommend?idArtista=<c:out value="${artistaTop6.idArtista}" />">Ver más</a></span></div>
						   </div>
							
							</c:forEach>	 
							
							</div>
							
						<div class="clear"> </div>
						</div>
					</div>



					

					<!-- |||||||||||||||||||||||||||||||||||||||-->






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