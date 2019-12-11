<%-- 
    Document   : AdminPeticionEspecifica
    Created on : 8/12/2019, 06:46:51 PM
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
    
  
        <div class="container-fluid">
        <div class="card mb-3" style=" width:80%; margin: auto;">
            <div class="row no-gutters">
                <div class="col-md-2">
                    <img src=<%=PETICION_Foto.get(IndiceN)%> class="card-img" alt="producto" height="150" >
                </div>
                <div class="col-md-8">
                    <div class="card-body">
                        <h5 class="card-title">Peticion: <%=1 + IndiceN%> Fecha:  <%=PETICION_Fecha.get(IndiceN) %></h5>
                  
                        <p class="card-text">
                            Usuario: <%=PETICION_Nick.get(IndiceN)%><br>
                            Articulo: <%=PETICION_Nombre.get(IndiceN) %>
                            , Articulos: <%= PETICION_Cantidad.get(IndiceN) %><br>
                            Estado de peticion: <%= PETICION_Estado.get(IndiceN)%><br>
                            Precio Sugerido: <%=PETICION_Sugerido.get(IndiceN)%>  
                            
                            Establecer Precio:
                            <form method="POST" action="RespondePeticion">
                            <input type="number"  name="PrecioProducto" pattern="[0-9]+.[0-9]{2}" min = "1" minlength ="1" maxlength="10" required>
                            <button type="submit" class="btn btn-info" style="float:right;"> Responder Peticion</button> 
                    </form>
                            </p>
                    
                    </div>
                </div>
            </div>
        </div>
    </div>  
       
      
   
    </body>
</html>
