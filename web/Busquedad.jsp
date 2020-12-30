<%-- 
    Document   : Buesquedad
    Created on : 28/11/2019, 06:14:16 PM
    Author     : Matias
--%>

<%@page import="par2019.domain.model.entity.Product"%>
<%@page import="par2019fe.carrito.Producto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Consumir.Resteasy.SeProduct"%>
<%@page import="com.google.gson.Gson"%>
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
            <th><a href="index.jsp">Inisiar Sesion</a></th>
            <th><a href="Menu Principal.jsp">Catalago</a></th>
            <th><a href="ServletCarrito">Carrito de Compras</a><th>
            <th><a href='CerrarSesionServlet'>CerrarSesion</a></th>
           </tr>
        </table>
        <h2 align="center">Busquedad realizada de Productos</h2>
        <table border="0" width="900" align="center">
            <%  
                Gson json = new Gson();
                SeProduct prod = new SeProduct();
                ArrayList<Producto> lista = new ArrayList();
                ArrayList value = new ArrayList();
                if(request.getParameter("Categoria").equals("0")) {
                     value = prod.getProductc(ArrayList.class, (String) request.getParameter("Nombre"));
                } else {
                    value = prod.getProductXC(ArrayList.class, (String) request.getParameter("Nombre"), (String) request.getParameter("Categoria"));
                }
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
