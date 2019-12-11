<%-- 
    Document   : AdminRespuestas
    Created on : 8/12/2019, 08:30:25 PM
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
      
        <%@include file="AdminNavbar.jsp" %>
                <br>
         <h1 class="display-4">Peticiones</h1>
    
    <% if(PETICION_ID!= null){
        for(int i = 0; i< PETICION_ID.size();i++){
   String aux = PETICION_Estado.get(i);
    %> 
  
        <div class="container-fluid">
        <div class="card mb-3" style=" width:80%; margin: auto;">
            <div class="row no-gutters">
                <div class="col-md-2">
                    <img src=<%=PETICION_Foto.get(i)%> class="card-img" alt="producto" height="150" >
                </div>
                <div class="col-md-8">
                    <div class="card-body">
                        <h5 class="card-title">Peticion: <%= i+1%> Fecha:  <%=PETICION_Fecha.get(i) %></h5>
                  
                        <p class="card-text">
                            Usuario: <%=PETICION_Nick.get(i)%><br>
                            Articulo: <%=PETICION_Nombre.get(i) %>
                            , Articulos: <%= PETICION_Cantidad.get(i) %><br>
                            Estado de peticion: <%= PETICION_Estado.get(i)%><br>
                            Precio Establecido: <%=PETICION_Sugerido.get(i)%>  <br>
                            <a href="CancelaRespuesta?ID=<%= i%>" class="btn btn-info" style="float:right;">Cancelar Respuesta</a> 
                    <br>
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
