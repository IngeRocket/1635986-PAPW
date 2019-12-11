<%-- 
    Document   : navbar
    Created on : 30/11/2019, 08:12:30 PM
    Author     : Julio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
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
            
            //en el caso de que yo ya haya hecho logIn
           int IndiceN = (Integer)Existente.getAttribute("IndiceN");
            if(Existente.getAttribute("Nombre") != null){
            nombre = Existente.getAttribute("Nombre").toString();
            }
   int Posicion = (Integer) Existente.getAttribute("Posicion");
  //PETICIONES Y SOLICITUD DE PETICIONES
   List<String> PETICION_ID =(List<String>) Existente.getAttribute("PETICION_ID");
   List<String> PETICION_ID_Prod=(List<String>)Existente.getAttribute("PETICION_ID_Prod");
   List<String> PETICION_Nombre=(List<String>)Existente.getAttribute("PETICION_Nombre");
   List<String> PETICION_Cantidad=(List<String>)Existente.getAttribute("PETICION_Cantidad");
   List<String> PETICION_Sugerido=(List<String>)Existente.getAttribute("PETICION_Sugerido");
   List<String> PETICION_Estado=(List<String>)Existente.getAttribute("PETICION_Estado");
   List<String> PETICION_Fecha=(List<String>)Existente.getAttribute("PETICION_Fecha");
   List<String> PETICION_Foto=(List<String>)Existente.getAttribute("PETICION_Foto");
   List<String> PETICION_Nick=(List<String>)Existente.getAttribute("PETICION_Nick");    
//PRODUCTOS
   List<String> ADMIN_PROD_ID_Prod=(List<String>)Existente.getAttribute("ADMIN_PROD_ID_Prod");
   List<String> ADMIN_PROD_Nombre=(List<String>)Existente.getAttribute("ADMIN_PROD_Nombre");
   List<String> ADMIN_PROD_Stock=(List<String>)Existente.getAttribute("ADMIN_PROD_Stock");
   List<String> ADMIN_PROD_Precio=(List<String>)Existente.getAttribute("ADMIN_PROD_Precio");
   List<String> ADMIN_PROD_Borrador=(List<String>)Existente.getAttribute("ADMIN_PROD_Borrador");
   List<String> ADMIN_PROD_Baja=(List<String>)Existente.getAttribute("ADMIN_PROD_Baja");
   List<String> ADMIN_PROD_Foto1=(List<String>)Existente.getAttribute("ADMIN_PROD_Foto1");
   List<String> ADMIN_PROD_Foto2=(List<String>)Existente.getAttribute("ADMIN_PROD_Foto2");
   List<String> ADMIN_PROD_Foto3=(List<String>)Existente.getAttribute("ADMIN_PROD_Foto3");
   List<String> ADMIN_PROD_Descripcion=(List<String>)Existente.getAttribute("ADMIN_PROD_Descripcion");    
   List<String> ADMIN_PROD_Video=(List<String>)Existente.getAttribute("ADMIN_PROD_Video");
   List<String> ADMIN_PROD_Categoria=(List<String>)Existente.getAttribute("ADMIN_PROD_Categoria");
   
        String Origen = (String) Existente.getAttribute("Origen");
        
        %>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <a class="navbar-brand" href="Administrador.jsp">LOGO</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="Administrador.jsp">Inicio<span class="sr-only">(current)</span></a>
                </li>
                
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                               Productos
                            </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">

                        <a class="dropdown-item" href="AgregarProducto.jsp">Agregar Productos</a>

                        <a class="dropdown-item" href="CargarExistentes">Modificar Productos</a>
                        <a class="dropdown-item" href="CargarBorradores">Ver Borrador</a>
                        <a class="dropdown-item" href="CargarEliminados">Visitar Cementerio</a>
                    </div>
                </li>
                 <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                               Peticiones de Usuarios
                            </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <a class="dropdown-item" href="CargarPeticiones">Ver Peticiones</a>
                        <a class="dropdown-item" href="CargarRespuestas">Cancelar Respuesta</a>
                    </div>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Ayuda</a>
                </li>
            </ul>
            <ul class="navbar-nav align-self-end">
           

                <% if (nombre=="") { %>
                <form class="form-inline my-2 my-lg-0">
                    <a href="login.jsp" class="btn btn-success"><img src="navbar/user1.png" class="avatar" alt="avatar" name="My_foto"> Inicia Sesion </a>
                    <a href="registro.jsp" class="btn btn-primary">Registrate</a>

                </form>
  <% }else{ %>

                <form class="form-inline my-2 my-lg-0">
                    <a href="#" class="btn btn-primary"><img src="navbar/user1.png" class="avatar" alt="avatar" name="My_foto"> <%=nombre %> </a>
                    <a href="LogOut" class="btn btn-danger">Salir</a>

                </form> 
                    
                <% } %>
                 
 
            </ul>
            
        </div>
    </nav>

 
    </body>
</html>

