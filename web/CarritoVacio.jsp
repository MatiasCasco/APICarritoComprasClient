<%-- 
    Document   : CarritoVacio
    Created on : 12/11/2019, 04:47:03 PM
    Author     : Matias
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Carrito Vacio</title>
    </head>
    <body>
        <table border="1" width="900" align="center">
          <tr  bcolor="skyblue">
            <th><a href="index.jsp">Inisiar Sesion</a></th>
            <th><a href="Menu Principal.jsp">Catalago</a></th>
            <th><a href="ServletCarrito">Carrito de Compras</a><th>
            <th><a href="Detalle.jsp">Reportes</a><th>
            <th><a href='CerrarSesionServlet'>CerrarSesion</a></th>
           </tr>
        </table>
        <h1>El carrito de compras se encuentra vacio</h1>
    </body>
</html>
