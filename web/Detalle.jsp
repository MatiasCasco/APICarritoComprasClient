<%-- 
    Document   : Detalle
    Created on : 30/11/2019, 05:48:20 PM
    Author     : Matias
--%>

<%@page import="par2019.domain.model.entity.Transacciones_cab"%>
<%@page import="par2019.domain.model.entity.*"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Consumir.Resteasy.SeTransaccion"%>
<%@page import="com.google.gson.Gson"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Detalle introdusca</title>
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
            <h1>Reporte Facturacion</h1>
            <table broder="1">
                <thead>
                    <tr>
                        <th>Fecha</th>
                        <th>Total</th>
                        <th>Direccion</th>
                        <th>Estado</th>
                    </tr>
                </thead>
                <%
                    
                    User us = (User) request.getSession().getAttribute("usuario");
                    Gson json = new Gson();                    
                    SeTransaccion cab = new SeTransaccion();
                    Transacciones_cab t = new Transacciones_cab();
                    ArrayList value = cab.getTransaccionesCab(ArrayList.class);
                    ArrayList<Transacciones_cab> lista = new ArrayList();
                    
                    for(Object pro: value){
                      try{
                        t = json.fromJson(pro.toString(), Transacciones_cab.class);
                        if(us.getId() == t.getId_cliente()){
                           lista.add(t);
                       }    
                        //t= (Transacciones_cab) pro;
                      } catch(Exception ex){}  
                        
                    }
                    
                    cab.close();
                  
                   for(Transacciones_cab ca: lista){
                         
                %>
                <tbody>
                    
                    <tr>
                        <td><%=ca.getFecha()%></td>
                        <td><%=ca.getTotal()%></td>
                        <td><%=ca.getDireccion_envio()%></td>
                        <td><%=ca.getEstado()%></td>
                        <td><form action="DetalleDos.jsp">
                           <input type="hidden" name="id" value="<%=ca.getId_transaccion()%>">
                           <input type="submit" name="Detalle" value="Detalle">
                        </form></td>
                    </tr>
                    <%}%>
                </tbody>
            </table>
        </div>
    </body>
</html>
