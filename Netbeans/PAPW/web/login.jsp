<%-- 
    Document   : login
    Created on : 2/12/2019, 10:54:05 AM
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
     <div class="container">
            <br>
            <form id="formInput" method="POST" action="InicioSesion">
                   <div class="form-group">
                    <label for="exampleInputEmail1">Email o Nickname</label>
                    <input type="text" class="form-control" id="exampleInputEmail1" name ="my_nombre" placeholder="Cuenta">
                    <small id="My_email" class="form-text text-muted">Direcci&oacuten de correo electr&oacutenico</small>
                </div>
                
                <div class="form-group">
                    <label for="exampleInputPassword1">Contrase&ntildea</label>
            
                    <input type="password" pattern="[a-zA-Z0-9?*_!?]+" minlength="8" class="form-control" name="my_pass" placeholder="Clave de acceso">
             <br> 
             <center>
                <label>Tipo Usuario</label>
            <select name="Estado" class="form-control">
            <option name="Cliente">Cliente</option>
            <option name="Administrador">Administrador</option>
            </select>
            
             </center>
            
                </div>
                          
               <center>
                <button type="submit" class="btn btn-primary">Login</button>
            </center>
            </form>
        </div>
   
    </body>
</html>
