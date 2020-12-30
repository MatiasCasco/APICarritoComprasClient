<%-- 
    Document   : Carrito
    Created on : 12/11/2019, 02:01:59 PM
    Author     : Matias
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="par2019fe.carrito.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Contenido del carrito</title>
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
        <h1>Productos contenidos en el carrito</h1>
        <tr>
        <table border="0" width="900" align="center">
            <%         
               //Carrito c = (Carrito) request.getAttribute("carri");
                Carrito c = (Carrito) request.getSession().getAttribute("carrito");
                ArrayList<Producto> carrito = new ArrayList();
                try{ 
                 carrito = c.getItems();
                }catch(Exception e){
                }
             
                int salto=0;
                for (Producto p: carrito) {
           %>
           <form method="post" action="ServletCarrito">
             <tr>
                    <th><img src="img/<%=p.getDescripcion()%>.jpg" width="140" height="140"><p>
                    <%=p.getDescripcion() %><br>
                    <%=p.getPrecio() %><br>
                    <%=p.getCantidad() %>
                    </th>
             </tr>
             <tr>
                 <th colspan="3"><input type="submit" value="Eliminar"/></th> 
             </tr>
             <input type="hidden" name="idProd" value="<%=p.getId()%>" />
              <input type="hidden" name="accion" value="Borrar" />
           </form>
            <%
                    salto++;
                    if(salto ==3){                
            %>
                <tr>
            <%
                    salto = 0;
                    }
                }
            %> 
            
        </table>  
            <form method="post" action="ServletConfirmacion">
                <input type="hidden" name="accion" value="Confirmar" />
                <input type="submit" value="Confirmar"/>
            </form>
    </body>    
    
</html>
