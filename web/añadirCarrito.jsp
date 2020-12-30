<%-- 
    Document   : añadirCarrito
    Created on : 14/11/2019, 04:33:51 PM
    Author     : Matias
--%>






<%@page import="Consumir.Resteasy.SeProduct"%>
<%@page import="par2019.domain.model.entity.Product"%>
<%@page import="par2019fe.carrito.Producto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

    <%  
        SeProduct prod = new SeProduct();
         
        String c = (String) request.getParameter("id");
        Producto p= new Producto();
        
         
        
        
     try {
        
        //c = (String) request.getSession().getAttribute("param");
         
        
        Product pr = prod.getProduct(Product.class, c);
        p =  new Producto(pr.getId(), pr.getNombre(), pr.getCantidad(), pr.getPrecio_unit()); 
         
     }catch(Exception e){}   
         
    %>
              <%--Aca asignarle el web services que me retorna el producto con el id
        que recibimos del  link Integer.parseInt(request.getParameter("idProd"));
        obs: mirar como traer la clase web services para usar el metodo
        
        --%>
        
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%-- Probablemente necesitare los mismos vinculos que el menu principal 
         aun no hice jeje
        --%>
        <h2 align="center"> Agregar producto a Carrito</h2>
        <table border="0" width="500" align="center">
            <form method="post" action="ServletCarrito">
             <tr>
                
                <th rowspan="5"><img src="img/<%=p.getDescripcion()%>.jpg" width="140" height="140"></th>
                
                <th> Codigo </th>
                <th> <input type="text" name="idProd" value="<%=p.getId()%>" readonly></th>
                <th> Nombre </th>
                <th> <input type="text" name="descripcion" value="<%=p.getDescripcion()%>" readonly></th>
                <th> Precio </th>
                <th> <input type="text" name="precio" value="<%=p.getPrecio()%>" readonly></th>
                <th> Cantidad </th>
                <th> <input type="number"  min="1" name="cantidad" value="1" /></th>
             </tr>
             <tr>
                 <th colspan="3"><input type="submit" value="Agregar" name="btn1"/></th> 
             </tr>
             <input type="hidden" name="accion" value="AgregarCarrito" />
            </form>
        </table>
        
    </body>

 