<%-- 
    Document   : VerComentario
    Created on : 9/12/2019, 11:42:47 PM
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
                <p> <a href="historial.jsp" class="btn btn-info" style="margin-left: 20px;">Regresar</a></p>
         <h1 class="display-4">Comentar</h1>
    
   
  
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
                        
                    </div>
                </div>
            </div>
        </div>
                     
                    
    </div>  
                               <h1>Comentario del producto</h1>
        <h4 class="text-muted"><br>votos positivos: <%=Cuenta%>
        <br>votos negativos: <%= Cuenta - Suma %>
        <br>Cantidad de Votos: <%= Suma %> </h4>
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
