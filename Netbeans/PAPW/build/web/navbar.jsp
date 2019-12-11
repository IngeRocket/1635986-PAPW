<%-- 
    Document   : navbar
    Created on : 30/11/2019, 08:12:30 PM
    Author     : Julio
--%>

<%@page import="java.io.InputStream"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.LinkedList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.Usuarios.FotoUsuario" %>
<%@page import="com.Productos.ObtenerProductos" %>

<!DOCTYPE html>
<html>
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!--
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="css/bootstrap-grid.css">
    <link rel="stylesheet" type="text/css" href="css/bootstrap-grid.min.css">
    <link rel="stylesheet" type="text/css" href="css/bootstrap-reboot.css">
    <link rel="stylesheet" type="text/css" href="css/bootstrap-reboot.min.css">
       
   --> 
   
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
   
    <link rel="stylesheet" type="text/css" href="css/css-styles.css">
    <link rel="stylesheet" type="text/css" href="css/registro.css">
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
  
    </head>
    <body>
        <% 

            HttpSession Existente = request.getSession();
            String nombre = "";
            String categoria="";
            int IDusuario = (Integer)Existente.getAttribute("IdUsuario");
            int productoEspecifico = (Integer)Existente.getAttribute("IDEspecifico");
          
            List<String>NombreProducto = (List<String>)Existente.getAttribute("NombreProducto");
            List<String>PrecioProducto = (List<String>)Existente.getAttribute("PrecioProducto");
            List<String>DescripcionProducto = (List<String>)Existente.getAttribute("DescripcionProducto");
            List<String>StockProducto = (List<String>)Existente.getAttribute("StockProducto");
            List<String>ProductoFoto1 = (List<String>)Existente.getAttribute("ProductosFoto1");
            List<String>ProductoFoto2 = (List<String>)Existente.getAttribute("ProductosFoto2");
            List<String>ProductoFoto3 = (List<String>)Existente.getAttribute("ProductosFoto3");
            List<String>ProductoVideo = (List<String>)Existente.getAttribute("ProductosVideo");
            List<String>IDProducto= (List<String>)Existente.getAttribute("IDProductos");
            List<String>BajaProducto = (List<String>)Existente.getAttribute("BajaProducto");        
            //productos nuevos
            List<String>NuevoNombre = (List<String>)Existente.getAttribute("NuevoNombre");
            List<String>NuevoPrecio = (List<String>)Existente.getAttribute("NuevoPrecio");
            List<String>NuevoDescripcion = (List<String>)Existente.getAttribute("NuevoDescripcion");
            List<String>NuevoStock = (List<String>)Existente.getAttribute("NuevoStock");
            List<String>NuevoFoto1 = (List<String>)Existente.getAttribute("NuevoFoto1");
            List<String>NuevoFoto2 = (List<String>)Existente.getAttribute("NuevoFoto2");
            List<String>NuevoFoto3 = (List<String>)Existente.getAttribute("NuevoFoto3");
            List<String>NuevoVideo = (List<String>)Existente.getAttribute("NuevoVideo");
            List<String>NuevoIDProducto= (List<String>)Existente.getAttribute("NuevoIDProductos");  
            //PETICIONES
            List<String> PETI_ID=       (List<String>)Existente.getAttribute("PETI_ID");
            List<String> PETI_ID_Prod=  (List<String>)Existente.getAttribute("PETI_ID_Prod");
            List<String> PETI_Nombre=   (List<String>)Existente.getAttribute("PETI_Nombre");
            List<String> PETI_Cantidad= (List<String>)Existente.getAttribute("PETI_Cantidad");
            List<String> PETI_SubTotal= (List<String>)Existente.getAttribute("PETI_SubTotal");
            List<String> PETI_Estado=   (List<String>)Existente.getAttribute("PETI_Estado");
            List<String> PETI_Fecha=    (List<String>)Existente.getAttribute("PETI_Fecha");
            List<String> PETI_Foto1=    (List<String>)Existente.getAttribute("PETI_Foto1");

          FotoUsuario  MiFotoUsuario = (FotoUsuario)Existente.getAttribute("Informacion");
            //HISTORIAL / CARRITO
            
            List<String> HISTORIAL_ID =             (List<String>)Existente.getAttribute("HISTORIAL_ID");
            List<String> HISTORIAL_ID_Prod =        (List<String>)Existente.getAttribute("HISTORIAL_ID_Prod");
            List<String> HISTORIAL_Nombre =         (List<String>)Existente.getAttribute("HISTORIAL_Nombre");
            List<String> HISTORIAL_Cantidad =       (List<String>)Existente.getAttribute("HISTORIAL_Cantidad");
            List<String> HISTORIAL_Precio =         (List<String>)Existente.getAttribute("HISTORIAL_Precio");
            List<String> HISTORIAL_Estado =         (List<String>)Existente.getAttribute("HISTORIAL_Estado");
            List<String> HISTORIAL_FechaPago =      (List<String>)Existente.getAttribute("HISTORIAL_FechaPago");
            List<String> HISTORIAL_Foto1 =          (List<String>)Existente.getAttribute("HISTORIAL_Foto1");
            List<String> HISTORIAL_Comentado =      (List<String>)Existente.getAttribute("HISTORIAL_Comentado");
            List<String> HISTORIAL_Nick =           (List<String>)Existente.getAttribute("HISTORIAL_Nick");
            List<String> HISTORIAL_PAGO =           (List<String>)Existente.getAttribute("HISTORIAL_PAGO");
            //COMENTARIOS
            List<String> COMENTARIO_Texto =      (List<String>)Existente.getAttribute("COMENTARIO_Texto");
            List<String> COMENTARIO_Valor =      (List<String>)Existente.getAttribute("COMENTARIO_Valor");
            List<String> COMENTARIO_Fecha =      (List<String>)Existente.getAttribute("COMENTARIO_Fecha");
            List<String> COMENTARIO_Nick =       (List<String>)Existente.getAttribute("COMENTARIO_Nick");
            int Suma = (Integer)    Existente.getAttribute("Suma");
            int Cuenta = (Integer)  Existente.getAttribute("Cuenta");
            
//productos destacados
//en el caso de que yo ya haya hecho logIn
    
//FORMAS PAGO EN COMPRAS

List<String> CARRITO_Comentario =(List<String>)Existente.getAttribute("CARRITO_Comentario");
InputStream LaFoto = (InputStream) Existente.getAttribute("LaFoto");
            
//COMENTARIO SOBRE COMPRA

            if(Existente.getAttribute("Categoria")!=null){
            categoria = Existente.getAttribute("Categoria").toString();
         
            
        
            }
            if(Existente.getAttribute("Nombre") != null){
            Existente.setAttribute("Bandera","alguien");
            nombre = Existente.getAttribute("Nombre").toString();
           
            }
           //en caso de que este visitando una categoria de productos
            if(Existente.getAttribute("Categoria")!=null){
            categoria = Existente.getAttribute("Categoria").toString();
            
            }
           

%>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <a class="navbar-brand" href="Principal">LOGO</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="index.jsp">Inicio<span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="Automotriz">Automotr&iacutez</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="Belleza">Belleza</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="Jardin">Jard&iacuten</a>
                </li>

                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                               M&aacutes Categorias
                            </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">

                        <a class="dropdown-item" href="Consolas">Consolas</a>

                          <a class="dropdown-item" href="Electrodomesticos">Electrodomesticos</a>
                        
                        <a class="dropdown-item" href="Hardware">Hardware</a>

                        <a class="dropdown-item" href="HerramientasYFerreteria">Herraminetas y Ferreteria</a>

                        <a class="dropdown-item" href="Software">Software</a>

                    </div>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Ayuda</a>
                </li>
            </ul>
            <ul class="navbar-nav align-self-end">
                <form class="form-inline my-2 my-lg-0">
                    <input class="form-control mr-sm-2" type="text" placeholder="Buscar...">
                    <a href="#" class="btn btn-info"><img src="navbar/lupa_blanco.png" alt ="carrito" width="20px" height="20px"></img>
                    </a>
                </form>

                <% if (nombre=="") { %>
                <form class="form-inline my-2 my-lg-0">
                    <a href="login.jsp" class="btn btn-success"> Inicia Sesion </a>
                    <a href="registro.jsp" class="btn btn-primary">Registrate</a>

                </form>
  <% }else{ %>

                <form class="form-inline my-2 my-lg-0">
                    <a href="#" class="btn btn-primary"><img src="InicioSesion?1" class="avatar"  name="My_foto"> <%=nombre %> </a>
                    <a href="LogOut" class="btn btn-danger">Salir</a>

                </form>
                       <li class="nav-item ">
                    <a class="navbar-brand" href="Carrito"> <img src="navbar/carro_blanco.png" class="icono"></img></a>
                    <a class="navbar-brand" href="PeticionUsuario"> <img src="navbar/megafono512.png" class="icono"></img></a>
                    <a class="navbar-brand" href="CargaHistorial"> <img src="navbar/historial.png" class="icono"></img></a>
                </li>
  <% } %>
                 
 
            </ul>
            <!--
                    <form class="form-inline my-2 my-lg-0">
                        <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                    </form>
                    -->
        </div>
    </nav>

 
    </body>
</html>

