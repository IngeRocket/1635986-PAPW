<%-- 
    Document   : AgregarProducto
    Created on : 4/12/2019, 09:36:35 PM
    Author     : Julio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nuevo Producto</title>
    </head>
    <body>
<%@ include file="AdminNavbar.jsp" %>
<center>    </center>    
<h1>Nuevo Producto</h1>
<div class="container">
    
    <form id="formInput" action="SubirProducto" method="POST">
     
            
            <div class="form-group">
            <label>Nombre del Producto</label><br>
            <input type="text"  class="form-control" pattern="[A-Z]{1}+[a-z]" minlength ="3" maxlength="60" name="NombreProducto" required ><br>
      
            <label>Descripcion del Producto</label><br>
            <input type="text"  class="form-control" pattern="[A-Z]{1}+[a-z]" name="DescripcionProducto" minlength ="3" maxlength="200" required><br>
            <label>Precio del Producto</label><br>
            <input type="number"  class="form-control" name="PrecioProducto" pattern="[0-9]+.[0-9]{2}" minlength ="1" maxlength="10" min="0" required><br>
            <label>Cantidad de productos en Stock</label><br>
            <input type="number"  class="form-control" name="StockProducto" pattern="[0-9]" min="1" minlength ="1" maxlength="5" required><br>
            <label>Categoria del producto</label> 
            <select name="SelectCategoria" class="form-control">
                <option value="Automotriz" >Automotriz</option>
                <option value="Belleza">Belleza</option>
                <option value="Consolas">Consolas</option>
                <option value="Electrodomesticos">Electrodomesticos</option>
                <option value="Hardware">Hardware</option>
                <option value="HerramientasYFerreteria">HerramientasYFerreteria</option>
                <option value="Jardin">Jardin</option>
                <option value="Software">Software</option>
            
            </select><br>
            <label>Foto 1:</label><br>
            <input type="file"  class="form-control" name="Foto1Producto" accept=".pdf,.jpg,.png" minlength="5" required><br>
            <label>Foto 2:</label><br>
            <input type="file"  class="form-control" name="Foto2Producto" accept=".pdf,.jpg,.png" minlength="5" required><br>
            <label>Foto 3:</label><br>
            <input type="file"  class="form-control" name="Foto3Producto" accept=".pdf,.jpg,.png" minlength="5" required><br>
            <label>Video:</label><br>
            <input type="file"   class="form-control" name="VideoProducto"accept=".avi,.wav,.mp4" minlength="5" required><br>
            <label>Opcion de producto</label>
            <select name="OpcionProducto" class="form-control">
            <option name="Agregar">Agregar a Productos</option>
            <option name="Borrador">Agregar a Borrador </option>
            </select>
            <br>
            <br>
            <button type="Submit" name="envio" class="btn btn-success">Enviar Solicitud</button>
     </div>        
            </form>
       
    </div>
</center>    
</body>
</html>
