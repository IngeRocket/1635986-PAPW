<%-- 
    Document   : index
    Created on : 30/11/2019, 05:32:24 PM
    Author     : Julio

  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
   
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <!-- 
   -->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" type="text/css" href="css/css-styles.css">
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="css/bootstrap-grid.css">
    <link rel="stylesheet" type="text/css" href="css/bootstrap-reboot.css">
    <link rel="stylesheet" type="text/css" href="css/registro.css">
   


</head>
<title>
    Inicio
</title>


<body>

    <%@ include file ="navbar.jsp"  %>
       <div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
        <ol class="carousel-indicators">
            <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
            <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
            <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
        </ol>

        <div class="carousel-inner" style="max-height:400px">
            <div class="carousel-item active">
                <img src="carousel/N2.jpeg" class="d-block w-100" alt="IMG1">
            </div>
            <div class="carousel-item">
                <img src="carousel/N3.jpg" class="d-block w-100" alt="IMG2">
            </div>
            <div class="carousel-item">
                <img src="carousel/N1.jpg" class="d-block w-100" alt="IMG3">
            </div>
        </div>
        <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
        </a>
        <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
        </a>
    </div>
    <br>
    <!-- PRODUCTOS destacados  -->
    <div class="titulo justify-content-center justify-content-md-center">
        <h1 class="display-4">Productos destacados</h1>
        <br>
   <% if(NuevoFoto1 != null ){ %>
        <div class="container">
            <div class="row justify-content-center justify-content-md-center">

                <div class="card col-6 col-md-2">
                    <img src=<%=NuevoFoto1.get(8)%>  class="card-img-top" alt="Producto01">
                    <div class="card-body">
                        <h5 class="card-title"><%=NuevoNombre.get(8)%></h5>
                        <p class="card-text">
                       <%=NuevoDescripcion.get(8)%>
                       <br>Precio: <label style=" color:orangered;"><%=NuevoPrecio.get(8)%></label>
                        </p>
                    <center>
                    <a href="Principales?ID=8" class="btn btn-info">Ver Producto</a>
                    </center>    
                    </div>
                </div>
                <div class="card col-6 col-md-2">
                    <img src=<%=NuevoFoto1.get(9)%>  class="card-img-top" alt="Producto01">
                    <div class="card-body">
                        <h5 class="card-title"><%=NuevoNombre.get(9)%></h5>
                        <p class="card-text">
                       <%=NuevoDescripcion.get(9)%>
                       <br>Precio: <label style=" color:orangered;"><%=NuevoPrecio.get(9)%></label>
                        </p>
                    <center>
                    <a href="Principales?ID=9" class="btn btn-info">Ver Producto</a>
                    </center>    
                    </div>
                </div>
                <div class="card col-6 col-md-2">
                    <img src=<%=NuevoFoto1.get(10)%>  class="card-img-top" alt="Producto01">
                    <div class="card-body">
                        <h5 class="card-title"><%=NuevoNombre.get(10)%></h5>
                        <p class="card-text">
                       <%=NuevoDescripcion.get(10)%>
                       <br>Precio: <label style=" color:orangered;"><%=NuevoPrecio.get(10)%></label>
                        </p>
                    <center>
                    <a href="Principales?ID=10" class="btn btn-info">Ver Producto</a>
                    </center>    
                    </div>
                </div>
                <div class="card col-6 col-md-2">
                    <img src=<%=NuevoFoto1.get(11)%>  class="card-img-top" alt="Producto01">
                    <div class="card-body">
                        <h5 class="card-title"><%=NuevoNombre.get(11)%></h5>
                        <p class="card-text">
                       <%=NuevoDescripcion.get(11)%>
                       <br>Precio: <label style=" color:orangered;"><%=NuevoPrecio.get(11)%></label>
                        </p>
                    <center>
                    <a href="Principales?ID=11" class="btn btn-info">Ver Producto</a>
                    </center>    
                    </div>
                </div>
                <div class="card col-6 col-md-2">
                    <img src=<%=NuevoFoto1.get(12)%>  class="card-img-top" alt="Producto01">
                    <div class="card-body">
                        <h5 class="card-title"><%=NuevoNombre.get(12)%></h5>
                        <p class="card-text">
                       <%=NuevoDescripcion.get(12)%>
                       <br>Precio: <label style=" color:orangered;"><%=NuevoPrecio.get(12)%></label>
                        </p>
                    <center>
                    <a href="Principales?ID=12" class="btn btn-info">Ver Producto</a>
                    </center>    
                    </div>
                </div>
                <div class="card col-6 col-md-2">
                    <img src=<%=NuevoFoto1.get(13)%>  class="card-img-top" alt="Producto01">
                    <div class="card-body">
                        <h5 class="card-title"><%=NuevoNombre.get(13)%></h5>
                        <p class="card-text">
                       <%=NuevoDescripcion.get(13)%>
                       <br>Precio: <label style=" color:orangered;"><%=NuevoPrecio.get(13)%></label>
                        </p>
                    <center>
                    <a href="Principales?ID=13" class="btn btn-info">Ver Producto</a>
                    </center>    
                    </div>
                </div>
             
            </div>
        </div>

    </div>
        <% } %>
    <!-- PRODUCTOS   -->
   <h1 class="display-4">Productos nuevos</h1>
   <% if(NuevoFoto1 != null){ %>
    <div class="container">
        <div class="row justify-content-center justify-content-md-center">

            <div class="card col-6 col-md-3" style="width: 18rem;">
                <img src=<%=NuevoFoto1.get(0)%> class="card-img-top" alt="Producto01">
                <div class="card-body">
                    <h5 class="card-title"><%=NuevoNombre.get(0)%></h5>
                    <p class="card-text">
                       <%=NuevoDescripcion.get(0)%>
                       <br>Precio: <label style=" color:orangered;"><%=NuevoPrecio.get(0)%></label>
                    </p>
                    <center>
                    <a href="Principales?ID=0" class="btn btn-info">Ver Producto</a>
                </center>
                </div>
            </div>
            <div class="card col-6 col-md-3">
                <img src=<%=NuevoFoto1.get(1)%>  class="card-img-top" alt="Producto02">
                <div class="card-body">
                    <h5 class="card-title"><%=NuevoNombre.get(1)%></h5>
                    <p class="card-text">
                        <%=NuevoDescripcion.get(1)%>
                     <br>Precio: <label style=" color:orangered;"><%=NuevoPrecio.get(1)%></label>
                    </p>
                  <center>
                    <a href="Principales?ID=1" class="btn btn-info">Ver Producto</a>
                </center>  
                </div>
            </div>

            <div class="card col-6 col-md-3">
                <img src=<%=NuevoFoto1.get(2)%>  class="card-img-top" alt="Producto03">
                <div class="card-body">
                    <h5 class="card-title"><%=NuevoNombre.get(2)%></h5>
                    <p class="card-text">
                       <%=NuevoDescripcion.get(2)%>
                        <br>Precio: <label style=" color:orangered;"><%=NuevoPrecio.get(2)%></label>
                    </p>
                  <center>
                    <a href="Principales?ID=2" class="btn btn-info">Ver Producto</a>
                </center>
                </div>
            </div>

            <div class="card col-6 col-md-3">
                <img src=<%=NuevoFoto1.get(3)%>  class="card-img-top" alt="Producto04">
                <div class="card-body">
                    <h5 class="card-title"><%=NuevoNombre.get(3)%></h5>
                    <p class="card-text">
                       <%=NuevoDescripcion.get(3)%>
                        <br>Precio: <label style=" color:orangered;"><%=NuevoPrecio.get(3)%></label>
                    </p>
                  <center>
                    <a href="Principales?ID=3" class="btn btn-info">Ver Producto</a>
                </center>
                </div>
            </div>

            <div class="card col-6 col-md-3">
                <img src=<%=NuevoFoto1.get(4)%>  class="card-img-top" alt="Producto05">
                <div class="card-body">
                    <h5 class="card-title"><%=NuevoNombre.get(4)%></h5>
                    <p class="card-text">
                        <%=NuevoDescripcion.get(4)%>
                         <br>Precio: <label style=" color:orangered;"><%=NuevoPrecio.get(4)%></label>
                    </p>
                  <center>
                    <a href="Principales?ID=4" class="btn btn-info">Ver Producto</a>
                </center>
                </div>
            </div>
            <div class="card col-6 col-md-3">
                <img src=<%=NuevoFoto1.get(5)%>  class="card-img-top" alt="Producto06">
                <div class="card-body">
                    <h5 class="card-title"><%=NuevoNombre.get(5)%></h5>
                  
                    <p class="card-text">
                        <%=NuevoNombre.get(5)%>
                     <br>Precio: <label style=" color:orangered;"><%=NuevoPrecio.get(5)%></label>
                    </p>
                  <center>
                    <a href="Principales?ID=5" class="btn btn-info">Ver Producto</a>
                </center>
                </div>
            </div>
            <div class="card col-6 col-md-3">
                <img src=<%=NuevoFoto1.get(6)%>  class="card-img-top" alt="Producto07">
                <div class="card-body">
                    <h5 class="card-title"><%=NuevoNombre.get(6)%></h5>
                    <p class="card-text">
                      <%=NuevoNombre.get(6)%>
                       <br>Precio: <label style=" color:orangered;"><%=NuevoPrecio.get(6)%></label>
                    </p>
                  <center>
                    <a href="Principales?ID=6" class="btn btn-info">Ver Producto</a>
                </center>
                </div>
            </div>
            <div class="card col-6 col-md-3">
                <img src=<%=NuevoFoto1.get(7)%>  class="card-img-top" alt="Producto08">
                <div class="card-body">
                    <h5 class="card-title"><%=NuevoNombre.get(7)%></h5>
                    <p class="card-text">
                       <%=NuevoDescripcion.get(7)%>
                        <br>Precio: <label style=" color:orangered;"><%=NuevoPrecio.get(7)%></label>
                    </p>
                  <center>
                    <a href="Principales?ID=7" class="btn btn-info">Ver Producto</a>
                </center>
                </div>
            </div>


        </div>

    </div>
                    
                    <% } %>
</body>

</html>
