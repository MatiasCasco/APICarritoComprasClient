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
        <h1>Registrar Usuario</h1>
        <form action="RegistrarServlet" method="post">
            <label >Nombre:</label><br>
            <input  name="nombre" value="" type="text" required/><br>
            <label >Apellido:</label><br>
            <input  name="apellido" value="" type="text" required/><br>
            <label >Email:</label><br>
            <input  name="email" value="" type="text" /><br>
            <label>LoginName:</label><br>
            <input name="loginName" value="" type="text" required/><br>
            <label>Password:</label><br>
            <input  name="password" value="" type="password" required/>
            <input type="hidden" name="tipoCliente" value="2" />
            <input type="submit" value="Registrar">
           
        </form>
    </body>
</html>
