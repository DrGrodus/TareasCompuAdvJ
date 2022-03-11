<%-- 
    Document   : index
    Created on : 10 mar 2022, 22:02:11
    Author     : eber
--%>

<%@page import="java.util.Enumeration"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            HttpSession sesion = request.getSession();
            Enumeration e = sesion.getAttributeNames();
            if(e.hasMoreElements()){
                out.println("Hola de nuevo: ");
                out.println(sesion.getAttribute(""));
            } else{
                boolean dis = true;
            }
        %>
        <%
            
        %>
    </body>
</html>
