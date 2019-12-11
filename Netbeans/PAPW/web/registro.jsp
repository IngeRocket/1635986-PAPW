<%-- 
    Document   : registro
    Created on : 30/11/2019, 08:31:58 PM
    Author     : Julio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro</title>
    
    </head>
    <body>
        <script type="text/javascript" >
        
    
    function Robar(){
            var direccion = document.getElementById("My_photo").value;
            var nuevo = direccion.slice(12);
        
        document.getElementById("My_photo").src= nuevo;
alert(nuevo);

        }
        </script>
        <%@include file = "navbar.jsp"  %>
         <div class="container">
            <br>
            <form id="formInput" method="POST" action="SubirUsuario" enctype="multipart/form-data">
                <div class="form-group">
                    <label for="exampleUser">Nombres</label>
                    <input type="user" pattern="[A-Z]{1}+[a-z]" class="form-control" name="My_user" aria-describedby="emailHelp" placeholder="Nombres" required>
                    <small  class="form-text text-muted">Escribir ambos nombres en caso de tener ambos.</small>
              
               
                    <label for="exampleUser">Apellido Paterno</label>
                    <input type="user" pattern="[A-Z]{1}+[a-z]" class="form-control" name="My_AP" aria-describedby="emailHelp" placeholder="Apellido Paterno" required>
                    <small  class="form-text text-muted">Escribir apellido paterno.</small>
            
                    <label for="exampleUser">Apellido Materno</label>
                    <input type="user" pattern="[A-Z]{1}+[a-z]" class="form-control" name="My_AM" aria-describedby="emailHelp" placeholder="Apellido Materno" required>
                    <small  class="form-text text-muted">Escribir apellido materno.</small>
                    <label for="exampleInputEmail1">Email</label>
                    <input type="text" pattern="[a-zA-Z0-9_.]+@[a-zA-Z0-9]+.com(.mx)?" name="My_email" class="form-control" required id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="correo@dominio.com">
                    <small  class="form-text text-muted">Direcci&oacuten de correo electr&oacutenico</small>
               
                    <label for="exampleUser">Nickname</label>
                    <input type="text" name="My_alias" class="form-control"  aria-describedby="emailHelp" placeholder="Alias" required>
                    <small  class="form-text text-muted">*Alias, este nombre sera mostrado en los comentarios que realices y en las paginas de este sitio web</small>
               
                    <label for="exampleInputPassword1">Contrase&ntildea</label>
                    <input type="password"  minlength="8" class="form-control" name="My_password" placeholder="Clave de acceso" required>
               
                    <label for="exampleUser">Foto</label>
                    <input type="file"  minlength="5" class="form-control" name="My_photo" accept=".jpg,.png,.jpeg,.bmp" required>
                    </div>
                <button type="submit"  class="btn btn-primary">Registrame!</button>
            </form>
        </div>
    </body>
</html>
