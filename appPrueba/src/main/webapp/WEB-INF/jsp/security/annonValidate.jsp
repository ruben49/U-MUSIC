<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<script type="text/javascript" >

  
	var i = [];
	i = JSON.parse(localStorage.getItem("login"));
	
	if(i == null)
    {
			
	
		pagina="annon";
	
		location.href=pagina;
    }else
    	{
    	
			
			//------------------------------------------------------
			
			
			//se guarda el usuario y contraseña en variables para luego mandarlas al servidor
			var uLogin = i[0].uLogin;
			
			
				
			//alert("Nombre Usuario: " + ulogin);	
			pagina="http://localhost:8080/appPrueba/recommend?uLogin="+uLogin;
			location.href=pagina
    	
    	}
	

	

	



</script>
</head>
<body>

</body>
</html>