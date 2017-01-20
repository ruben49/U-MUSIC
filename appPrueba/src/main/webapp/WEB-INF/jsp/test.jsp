<%-- 
    Document   : test
    Created on : 03-12-2016, 1:54:20
    Author     : Carla
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset=UTF-8">
        <title>Página para mostrar datos</title>
    </head>
    <body>
        <h1>Página para mostrar datos</h1>
        <div class="container">
            <div class="row">
                <table class="table table-bordered table-striped table-hover">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Nombre</th>
                            <th>Login</th>
                            <th>Contraseña</th>
                            <th>Edad</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${datos}" var="dato">
                            <tr>
                                <td><c:out value="${dato.idUsuario}" /></td>
                                <td><c:out value="${dato.nombreUsuario}" /></td>
                                <td><c:out value="${dato.uLogin}" /></td>
                                <td><c:out value="${dato.uPassword}" /></td>
                                <td><c:out value="${dato.edad}" /></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>
