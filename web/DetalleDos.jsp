<%-- 
    Document   : DetalleDos
    Created on : 02/12/2019, 09:15:01 AM
    Author     : Matias
--%>

<%@page import="par2019.domain.model.entity.Product"%>
<%@page import="Consumir.Resteasy.SeProduct"%>
<%@page import="java.util.ArrayList"%>
<%@page import="par2019.domain.model.entity.Transacciones_det"%>
<%@page import="Consumir.Resteasy.SeTransaccionD"%>
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
            <th><a href="Menu Principal.jsp">Catalago</a></th>
            <th><a href="ServletCarrito">Carrito de Compras</a><th>
            <th><a href='CerrarSesionServlet'>CerrarSesion</a></th>
           </tr>
        </table>
        <div>
            <h1>Detalle de la factura</h1>
            <table broder="1">
                <thead>
                    <tr>
                        <th>Producto</th>
                        <th>Cantidad</th>
                        <th>Precio</th>
                        <th>SubTotal</th>
                    </tr>
                </thead>
                <%
                    
                   // User us = (User) request.getSession().getAttribute("usuario");
                    Gson json = new Gson();                    
                    SeTransaccionD det = new SeTransaccionD();
                    SeProduct p = new SeProduct();
                    Transacciones_det t = new Transacciones_det();
                   
                    ArrayList value = det.getTDet(ArrayList.class);
                    ArrayList<Transacciones_det> lista = new ArrayList();
                    
                    for(Object pro: value){
                      try{
                        t = json.fromJson(pro.toString(), Transacciones_det.class);
                        //t= (Transacciones_cab) pro;
                      } catch(Exception ex){}  
                        if(Integer.valueOf(request.getParameter("id")) == t.getId()){
                           lista.add(t);
                       }    
                    }
                    
                    det.close();
                  
                   for(Transacciones_det ca: lista){
                       
                        String iden = String.valueOf(ca.getId_producto());
                        Product prod = p.getProduct(Product.class, iden);
                       
                         
                %>
                <tbody>
                    
                    <tr>
                        <td><%=prod.getNombre()%></td>
                        <td><%=ca.getCantidad()%></td>
                        <td><%=ca.getPrecio()%></td>
                        <td><%=ca.getSubtotal()%></td>
                        
                    </tr>
                    <%}%>
                </tbody>
            </table>
        </div>
    </body>
</html>
