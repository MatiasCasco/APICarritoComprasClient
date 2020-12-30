<%-- 
    Document   : Menu Principal
    Created on : 12/11/2019, 10:02:14 AM
    Author     : Matias
--%>

<%@page import="par2019.domain.model.entity.Product"%>
<%@page import="Consumir.Resteasy.SeProduct"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="par2019fe.carrito.Producto"%>
<%@page import="par2019.domain.model.entity.User"%>
<%@page import="java.util.ArrayList"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menú</title>
    </head>
    <body>     
        <% 
            String variable = request.getParameter("txtNombre");
            if (variable == null) { variable = " ";}
        %>
        <p>Bienvenido <%= variable%></p>
        <a href='CerrarSesionServlet'>CerrarSesion</a>
        
         <form action="ServletCarrito">
            <input type="search" name="Nombre" placeholder="Busquedad">
            
            <h5> Filtrar por categoria:</h5>
                <select name = "Categoria">
                    <option value="0"></option>
                    <option value="1">PLOMERIA</option>
                    <option value="2">ELECTRICIDAD</option>
                    <option value="3">ELECTRONICA</option>
                </select>
            <input type="submit" name="accion" value="Buscar">
        </form>
        
        <table border="1" width="900" align="center">
          <tr  bcolor="skyblue">
            <th><a href="index.jsp">Inisiar Sesion</a></th>
            <th><a href="Menu Principal.jsp">Catalago</a></th>
            <th><a href="ServletCarrito">Carrito de Compras</a><th>
            <th><a href="Detalle.jsp">Reportes</a><th>
            <th><a href='CerrarSesionServlet'>CerrarSesion</a></th>
           </tr>
        </table>
        <h2 align="center">Catalago de Productos</h2>
        <table border="0" width="900" align="center">
            <%  
                Gson json = new Gson();
                SeProduct prod = new SeProduct();
                ArrayList<Producto> lista = new ArrayList();
                ArrayList value = prod.getProducts(ArrayList.class);
                for(Object pro: value){
                    Product product = json.fromJson(pro.toString(), Product.class);
                    lista.add(new Producto(product.getId(), product.getNombre(), product.getCantidad(), product.getPrecio_unit()));                   
                }
              
               
                int salto=0;
                for(Producto p: lista) {
            %>
                    <th><img src="img/<%=p.getDescripcion()%>.jpg" width="140" height="140"><p>
                    <%=p.getDescripcion()%>
                    <%=p.getPrecio()%>
                    <a href="">Modificar</a>
                    
                    <form action="añadirCarrito.jsp">
                        <input type="hidden" name="id" value="<%=p.getId()%>">
                        <input type="submit" name="bt1" value="Agregar">
                    </form>
                    </th>
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
    </body>
</html>
