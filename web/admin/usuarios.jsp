<%-- 
    Document   : usuarios
    Created on : 07/05/2019, 08:00:10 PM
    Author     : Mauricio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList, par2019fe.beans.User" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ABM de Usuarios</title>
        <%
            ArrayList<User> usuarios = (ArrayList<User>) request.getAttribute("usuarios");

        %>
    </head>
    <body>
        <h1>Usuarios</h1>
        <table border="1">
            <tr><th>Id</th>
                <th>Nombre</th>
                <th>Apellido</th>
                <th>E-mail</th>
                <th>Accion</th>
            </tr>
            <%                if (usuarios != null) {
                    for (User u : usuarios) { %>
            <tr>
                <td><%=u.getId()%></td>
                <td><%=u.getNombre()%></td>
                <td><%=u.getApellido()%></td>
                <td><%=u.getEmail()%></td>
                <td><form action="/par2019fe/admin/UsuarioServlet" method="DELETE"><input type="hidden" name="id" value="<%=u.getId()%>"><input type="submit" value="Eliminar"/></form></td>
            </tr>
            <% }
                }%>
        </table>
    </body>
</html>
