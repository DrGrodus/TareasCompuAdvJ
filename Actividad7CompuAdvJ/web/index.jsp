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
            HttpSession sesion = request.getSession(false);
            Enumeration e = sesion.getAttributeNames();
            
            if(e.hasMoreElements()){
                out.println("Hola de nuevo: ");
                out.println(sesion.getAttribute("user"));
            }
        %>

        <form action="Controlador" method="post">
            <label>Escribe tu usuario (si es que no esta presente): </label><br>
            <input type="text" placeholder="Usuario" name="user"><br>
            <input type="submit" value="Guardar"><br>
        </form>
        
        
        
        <h3>Calcular el área de un triángulo equilátero</h3><br>
        
        <%
            if(request.getAttribute("flag")!= null){
                out.println("<h2>Los valores de base y altura no puede ser menores a 0</h2>");
            }
        %>
        
        <%
            Cookie ck[] = request.getCookies();
            if(ck != null){
                for(int i=0;i<ck.length;i++){
                    if(ck[i].getName().equals("campo_Base")){
                        out.println("Tu operacion anterior fue:\n" 
                                + "Base: "+ ck[i].getValue() + " \nunidades ||");
                    }
                    if(ck[i].getName().equals("campo_Altura")){
                        out.println("Altura: " + ck[i].getValue() + " \nunidades ||");
                    }
                    if(ck[i].getName().equals("area")){
                        out.println("Area: " + ck[i].getValue() + " \nunidades ||");
                    }
                    if(ck[i].getName().equals("perimetro")){
                        out.println("Perimetro: " + ck[i].getValue() + " \nunidades ||");
                    }
                }
            }
        %>
        <form action="ReceptorSuma" method="post">
            <label>Base</label>
            <input id="campo_base" name="campo_Base" type="text" placeholder="Base"><br>
            <label>Altura</label>
            <input id="campo_altura" name="campo_Altura" type="text" placeholder="Altura"><br>
            <input type="submit" value="Calcular">
        </form>
        
    </body>
</html>
