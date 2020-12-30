<%-- 
    Document   : index
    Created on : 05/11/2019, 07:36:52 PM
    Author     : Matias
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
         <table border="1" width="900" align="center">
          <tr  bcolor="skyblue">
            <th><a href="Menu Principal.jsp">Catalago</a></th>
            <th><a href="ServletCarrito">Carrito de Compras</a><th>   
           </tr>
        </table>
        <h1>Inicio Sesion</h1>
        <form action="ValidarServlet" method="post">
            <input type="text" name="txtNombre" placeholder="Nombre de usuario"/><br>
            <input type="password" name="txtPass" placeholder="Contraseña"/><br>
            <input type="submit" value="Iniciar Sesion">
        </form>
    </body>
</html>
