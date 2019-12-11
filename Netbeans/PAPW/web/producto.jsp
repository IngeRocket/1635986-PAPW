
<%-- 
    Document   : producto
    Created on : 2/12/2019, 11:02:39 PM
    Author     : Julio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Producto</title>
    
    </head>
    <body>
               <%@ include file = "navbar.jsp" %>
               <br>
       <p><a href="productos.jsp" class="btn btn-info" style="margin-left: 20px;" >Regresar</a><p>
   
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
                <img  class="d-block w-100" alt="IMG1" id="prod1" src=<%=ProductoFoto1.get(productoEspecifico)%> >
            </div>
            <div class="carousel-item">
                <img class="d-block w-100" alt="IMG2" id = "prod2" src=<%=ProductoFoto2.get(productoEspecifico)%>>
            </div>
            <div class="carousel-item">
                <img class="d-block w-100" alt="IMG3" id="prod3" src=<%=ProductoFoto3.get(productoEspecifico)%>>
            </div>
             <div class="carousel-item">
                 <video
                  src="<%=ProductoVideo.get(productoEspecifico)%>" height="400" width="500" controls="true">
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
                <form action="AgregarAPresupuesto" method="POST">
            <br><h2><%=NombreProducto.get(productoEspecifico) %></h2>
            <br><h5>Descripcion:</h5>
             <%=DescripcionProducto.get(productoEspecifico) %>
             <br>Precio: <%=PrecioProducto.get(productoEspecifico)%>
            <br>Cantidades en stock:
            <%=StockProducto.get(productoEspecifico) %>
            <br>
            <br>
        
            <input type="number"  class="form-control" name="presupuestar" pattern="[0-9]" min="1" minlength ="1" maxlength="5" required max=<%=StockProducto.get(productoEspecifico)%>><br>
            <center>
                <%if(nombre.compareTo("")==0){ %>
                <br>Por favor inicie sesion si desea comprar algun producto
           <% }else{ %>
           
           <button type ="submit" class="btn btn-primary" id="comprar" >Enviar Peticion</button>
           
           <%   } %>
          </form>
           <br>
            <br>
          </form>
            <a href="Comentarios?ID=<%=IDProducto.get(productoEspecifico)%>" class="btn btn-info" id="comentarios">Ver Comentarios</a>
           
            </center>     
            </div>    
        </div>        
    <br>
</body>
</html>

