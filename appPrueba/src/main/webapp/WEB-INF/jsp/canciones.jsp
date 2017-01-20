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
                            <th>Nombre Cancion</th>
                            
                            
                            
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${datos}" var="dato">
                            <tr>
                                <td><c:out value="${dato.codCancion}" /></td>
                                <td><c:out value="${dato.nombreCancion}" /></td>
                                
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>
