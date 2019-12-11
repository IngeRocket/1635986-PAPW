<%-- 
    Document   : CarritoEspecifico
    Created on : 9/12/2019, 02:07:38 AM
    Author     : Julio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
      <body>
        <%@include file="navbar.jsp" %>
                <br>
                <p> <a href="carrito.jsp" class="btn btn-info" style="margin-left: 20px;">Regresar</a></p>
         <h1 class="display-4">Carrito</h1>
    
   
  
        <div class="container-fluid">
        <div class="card mb-3" style=" width:80%; margin: auto;">
            <div class="row no-gutters">
                <div class="col-md-2">
                    <img src=<%=HISTORIAL_Foto1.get(productoEspecifico)%> class="card-img" alt="producto" height="150" >
                </div>
                <div class="col-md-8">
                    <div class="card-body">
                        <h5 class="card-title">Articulo: <%=HISTORIAL_Nombre.get(productoEspecifico) %>
                        </h5>
                         <p class="card-text">
                       
                        </p>
                       
                        <p class="card-text">
                            Articulos: <%= HISTORIAL_Cantidad.get(productoEspecifico) %><br>
                            Estado de Compra: <%= HISTORIAL_Estado.get(productoEspecifico)%><br>
                        Precio Establecido: <%=HISTORIAL_Precio.get(productoEspecifico) %>
                            <br>
                        <form action="PagarCarrito" method="POST">
                            
            <select name="SelectPago" class="form-control" >
                <option value="Efectivo" >Efectivo</option>
                <option value="Tarjeta Debito">Tarjeta Debito</option>
                <option value="Tarjeta Credito">Tarjeta Credito</option>
                <option value="PayPal">PayPal</option>
                <option value="OXXO">OXXO</option>
                <option value="Puntos Infonavit">Puntos Infonavit</option>
                <option value="Titulo de propiedad">Titulo de propiedad</option>
                <option value="Mercado Pago">Mercado Pago</option>
            </select>
                        </p>

                            <center>
                            <button class="btn btn-success" type="submit">Pagar</button>
                            </center>
                        </form>
                    
                    </div>
                </div>
            </div>
        </div>
    </div>  
      
    </body>
</html>
