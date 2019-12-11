<%-- 
    Document   : Comentar
    Created on : 9/12/2019, 04:20:38 AM
    Author     : Julio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Comentar</title>
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
                        </p>
                            <form action="Comentar" method="POST">

                            <center>
                                              
            <select name="Voto" class="form-control">
                <option value="Positiva" >Positiva</option>
                <option value="Nagativa">Negativa</option>
            </select>
                                <br>
                <input type="text" class="form-control"  name="MiOpinion" min-lenght ="5" required>                  
                   <br>
                            <button class="btn btn-success" type="submit">Enviar Comentario</button>
                            </center>
                        </form>
                    
    </div>  
      
   
    </body>
</html>
