<%-- 
    Document   : Populares
    Created on : 7/12/2019, 08:45:37 PM
    Author     : Julio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Portada</title>
    </head>
   <body>

        <%@ include file = "navbar.jsp" %>
      
   
        <div id="principal" style="
    width:1300px;
    height:550px;
    margin-top:10px;
    margin-left:20px;
   
             ">
            <div id="izquierda" style="
    margin-top:40px;
    margin-left:10px;
    float:left;
    width:500px;
    height:400px;
   
                 ">
       
 <div id="carouselExampleIndicators" class="carousel" >
        <ol class="carousel-indicators" style="background-color:background;">
            <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
            <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
            <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
            <li data-target="#carouselExampleIndicators" data-slide-to="3"></li>
                   </ol>

        <div class="carousel-inner" style=" max-height:400px; max-width: 500px; ">
            <div class="carousel-item active">
                <img  class="d-block w-100" alt="IMG1" id="prod1" src=<%=NuevoFoto1.get(productoEspecifico)%> >
            </div>
            <div class="carousel-item">
                <img class="d-block w-100" alt="IMG2" id = "prod2" src=<%=NuevoFoto2.get(productoEspecifico)%>>
            </div>
            <div class="carousel-item">
                <img class="d-block w-100" alt="IMG3" id="prod3" src=<%=NuevoFoto3.get(productoEspecifico)%>>
            </div>
             <div class="carousel-item">
                 <video
                  src="<%=NuevoVideo.get(productoEspecifico)%>" height="400" width="500" controls="true">
      </video>   
             </div>
        </div>
 
    </div>    
            </div>
            
            <div id="derecha" style="
    margin-top:40px;
    float:right;
    margin-right:80px;
    width:700px;
    height:500px;
                 ">
          
            <br><h2><%=NuevoNombre.get(productoEspecifico) %></h2>
            <br><h5>Descripcion:</h5>
             <%=NuevoDescripcion.get(productoEspecifico) %>
             <br>Precio: <%=NuevoPrecio.get(productoEspecifico) %>
            <br>Cantidades en stock:
            <%=NuevoStock.get(productoEspecifico) %>
            <br>
            <br>
           <form method="POST" action="CompraDestacados">
            <input type="number"  class="form-control" name="presupuestar" pattern="[0-9]" min="1" minlength ="1" maxlength="5" required max=<%=NuevoStock.get(productoEspecifico)%>><br>
            <center>
                <%if(nombre.compareTo("")==0){ %>
                <br>Por favor inicie sesion si desea comprar algun producto
           <% }else{ %>
           
           <button class="btn btn-primary" id="comprar">Comprar</button>
                <%   } %>
            </form>
                <br>
            <br>
            <a href="Comentarios?ID=<%=NuevoIDProducto.get(productoEspecifico)%>" class="btn btn-info" id="comentarios">Ver Comentarios</a>
            </center>     
            </div>    
        </div>        
    <br>
</body>
</html>
