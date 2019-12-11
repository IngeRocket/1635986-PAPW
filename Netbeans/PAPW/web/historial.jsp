<%-- 
    Document   : historial
    Created on : 30/11/2019, 09:03:08 PM
    Author     : Julio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mis compras</title>
    </head>
       <body>
     <%@include file="navbar.jsp" %>
                <br>
         <h1 class="display-4">Historial Compras</h1>
    
    <% if(HISTORIAL_ID!= null){
        for(int i = 0; i< HISTORIAL_ID.size();i++){
   String aux = HISTORIAL_Estado.get(i);
    %> 
  
        <div class="container-fluid">
        <div class="card mb-3" style=" width:80%; margin: auto;">
            <div class="row no-gutters">
                <div class="col-md-2">
                    <img src=<%=HISTORIAL_Foto1.get(i)%> class="card-img" alt="producto" height="150" >
                </div>
                <div class="col-md-8">
                    <div class="card-body">
                        <h5 class="card-title">Articulo: <%=HISTORIAL_Nombre.get(i) %> <br>                      
                         Fecha Pago:<%= HISTORIAL_FechaPago.get(i) %>
                        </h5>
                         <p class="card-text">
                       
                        </p>
                       
                        <p class="card-text">
                            FormaPago: <%=HISTORIAL_PAGO.get(i)%><br>
                            Articulos: <%= HISTORIAL_Cantidad.get(i) %><br>
                            Estado de Compra: <%= HISTORIAL_Estado.get(i)%><br>
                            Precio Pagado: <%=HISTORIAL_Precio.get(i)%>
                            <br>
                            <% if(HISTORIAL_Comentado.get(i).compareTo("0")==0){ %>
                            <a href="Comentar?ID=<%=i%>" class="btn btn-success">Comentar sobre compra</a>
                        <%}%>
                      
                        </p>
                    
                    </div>
                </div>
            </div>
        </div>
    </div>  
        <%
                    }
                }
            %>
      
      
    </body>
</html>
