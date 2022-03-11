<%-- 
    Document   : Resultado
    Created on : 11 mar 2022, 2:36:30
    Author     : eber
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h3><% out.println("Tu triangulo");%></h3>
        <p><% out.println("El área es: " + request.getAttribute("area") + " unidades");%></p>
        <p><% out.println("Y el perímetro es: " + request.getAttribute("perimetro") + " unidades");%></p>
        <a href="index.jsp">Hacer otra suma</a>
    </body>
</html>
