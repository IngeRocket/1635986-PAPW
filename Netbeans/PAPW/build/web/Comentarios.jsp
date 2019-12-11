<%-- 
    Document   : Comentarios
    Created on : 9/12/2019, 10:23:17 AM
    Author     : Julio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Comentarios</title>
    </head>
    <body>
        <%@include file="navbar.jsp" %>
        <% if(Cuenta == 0){%>
        <center>
        <h1>Comentarios del producto</h1>
        <h4 class="text-muted"><br>votos positivos: Ninguno
        <br>votos negativos: Ninguno
        <br>Cantidad de Votos: Ninguno </h4>
        </center>
        
        <% }else{%>
        <center>
        <h1>Comentarios del producto</h1>
        <h4 class="text-muted"><br>votos positivos: <%= Suma %>
        <br>votos negativos: <%= Cuenta - Suma %>
        <br>Cantidad de Votos: <%=Cuenta%> </h4>
        </center>
    <% } %>
        <br>
            <div class="container-fluid">
            <% for(int i = 0; i<COMENTARIO_Nick.size();i++){%>    
        <div class="card mb-3" style=" width:80%; margin: auto;">
            <div class="row no-gutters">
                <div class="col-md-8">
                    <div class="card-body">
                        <h5 class="card-title">Fecha comentario: <%=COMENTARIO_Fecha.get(i) %> <br>De: <%=COMENTARIO_Nick.get(i)%></h5>
                        <p class="card-text"><%=COMENTARIO_Texto.get(i) %></p>
                     
                    
                    </div>
                </div>
            </div>
                            <% } %>
        </div>
    
            </div> 
    </body>
</html>
