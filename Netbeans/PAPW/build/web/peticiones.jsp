<%-- 
    Document   : peticiones
    Created on : 4/12/2019, 09:41:58 PM
    Author     : Julio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Peticiones</title>
    </head>
    <body>
        <%@include file="navbar.jsp" %>
                <br>
         <h1 class="display-4">Peticiones</h1>
    
    <% if(PETI_ID!= null){
        for(int i = 0; i< PETI_ID.size();i++){
   String aux = PETI_Estado.get(i);
    %> 
  
        <div class="container-fluid">
        <div class="card mb-3" style=" width:80%; margin: auto;">
            <div class="row no-gutters">
                <div class="col-md-2">
                    <img src=<%=PETI_Foto1.get(i)%> class="card-img" alt="producto" height="150" >
                </div>
                <div class="col-md-8">
                    <div class="card-body">
                        <h5 class="card-title">Peticion: <%= 1 + i%> Fecha:  <%=PETI_Fecha.get(i) %></h5>
                        <p class="card-text">Articulo: <%=PETI_Nombre.get(i) %>
                       
                        </p>
                       
                        <p class="card-text">
                            Articulos: <%= PETI_Cantidad.get(i) %><br>
                            Estado de peticion: <%= PETI_Estado.get(i)%>
                          <br>
                            <% if(aux.compareTo("Solicitud") == 0){ %>
                            Precio a Pagar: Sin definir
                            <a href="EliminarPeticion?ID=<%=i%>" class="btn btn-danger" style="float:right;"> Eliminar Peticion</a> 
                        <%}else{ %>
                            Precio a Pagar: <%=PETI_SubTotal.get(i)%>
                        <a href="AgregarACarrito?ID=<%=i%>" class="btn btn-success" style="float:right;"> Aceptar Presupuesto</a>
                        <a href="EliminarPeticion?ID=<%=i%>" class="btn btn-danger" style="float:right;"> Eliminar Peticion</a>     
                        <% } %>
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
