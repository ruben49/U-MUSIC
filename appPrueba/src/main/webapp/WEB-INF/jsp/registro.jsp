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
		<title>Registro</title>
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
						<li><a href="home">Home</a></li>

						<li><a href="#">Contacto</a></li>
					</ul>
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
					<div class="contact">
						<div class="section group">				
				<div class="col span_1_of_3">
					<div class="contact_info">
    	 				<div class="logo">
							
						</div>

      				</div>

				</div>				
				<div class="col span_2_of_3">
				  <div class="contact-form">
				  	<h3>Registro de Usuario</h3>
					    <form action="registro" method="post">
					    	<div>
						    	<span><label for="nombreUsuario" >Nombre</label></span>
						    	<span><input type="text" id="nombreUsuario" name="nombreUsuario" placeholder="Nombre" required/> </span>
						    </div>
						    <div>
						    	<span><label for="email" >E-mail</label></span>
						    	<span><input type="text" id="email" name="email" placeholder="ejemplo@email.com" required/> </span>
						    </div>
						    <div>
						    	<span><label for="uLogin">Nickname</label></span>
						    	<span><input type="text" id="uLogin" name="uLogin" placeholder="Nickname" required/>  </span>
						    </div>
						    <div>
						    	<span><label for="uPassword" >Contraseña</label></span>
						    	<span><input type="text" id="uPassword" name="uPassword" placeholder="Contraseña" required/>  </span>
						    </div>

						    <div>
						    	<span><label for="edad">Edad</label></span>
						    	<span><input type="number" id="edad" name="edad" placeholder="Edad" required/>  </span>
						    </div>
						    <div>
						    	<span><label for="idSexo">Sexo</label></span>
						    	<span><select id="idSexo" name="idSexo" > 
					                <c:forEach items="${datos2}" var="dato2">
					                
					                  <option value="<c:out value="${dato2.idSexo}" />"><c:out value="${dato2.descripcion}" /></option>
					          
					                </c:forEach>
				            		</select>   
					            </span>
						    </div>
						    <div>
						    	<span><label for="idPais">Nacionalidad</label></span>
						    	<span><select id="idPais" name="idPais" > 
                					<c:forEach items="${datos}" var="dato">
                
             						<option value="<c:out value="${dato.idPais}" />"><c:out value="${dato.nombrePais}" /></option>
          
               						</c:forEach>
            						  </select>   
					            </span>
						    </div>






	
						   <div>
						   		<span><input type="submit" value="Enviar"></span>
						   </div>
					    </form>
				    </div>
  				</div>				
			  </div>
					</div>
			</div>
		</div>
			<div class="clear"> </div>
			<div class="footer">
				<div class="wrap">
				<div class="section group">
				<div class="col_1_of_4 span_1_of_4">
					<h3>INFORMACIÓN</h3>
					<ul>
						<li><a href="#">Sobre Nostros</a></li>
						<li><a href="#">HOME</a></li>
						<li><a href="#">Contacto</a></li>

					</ul>
				</div>


			</div>
			</div>
		</div>
		<!---End-wrap--->
	</body>
</html>
