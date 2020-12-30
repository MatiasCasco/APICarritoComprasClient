<%-- 
    Document   : Cabecera
    Created on : 30/11/2019, 12:48:17 PM
    Author     : Matias
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Transaccion Cabecera</title>
    </head>
    <body>
        <h1>Cabecera Transaccion</h1>
        <form action="ServletConfirmacion" method="post">
            <th> Ubicacion</th>
            <th> <input type="text" name="Ubicacion" placeholder="Localizacion" required/></th>
            
            <h3> Eliga medio de pago</h3>               
                <select name = "MedioPago">                    
                    <option value="1">Credito</option>
                    <option value="2">Debito</option>
                    <option value="3">Deposito</option>
                    <option value="4">Billetera Digital</option>
                </select>
                <h3>Ingrese Nro de Tarjeta </h3>
                <input type="password" name="NroTarjeta" placeholder="Nro.Tarjeta" maxlength="5" required/><br>
            <input type="submit" name="accion" value="Cabecera">
        </form>
    </body>
</html>
