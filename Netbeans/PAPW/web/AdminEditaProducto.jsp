<%-- 
    Document   : AdminEditaProducto
    Created on : 9/12/2019, 03:01:44 PM
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
<%@ include file="AdminNavbar.jsp" %>
<center>    </center>    
<h1>Editar Producto</h1>
<div class="container">
    
    <form id="formInput" action="ModificaProducto" method="POST">
     
            
            <div class="form-group">
            <label>Nombre del Producto</label><br>
            <input type="text"  class="form-control" pattern="[A-Z]{1}+[a-z]" minlength ="3" maxlength="60" name="NombreProducto" value="<%=ADMIN_PROD_Nombre.get(IndiceN)%>" required ><br>
      
            <label>Descripcion del Producto</label><br>
            <input type="text"  class="form-control" pattern="[A-Z]{1}+[a-z]" name="DescripcionProducto" minlength ="3" maxlength="200" value="<%=ADMIN_PROD_Descripcion.get(IndiceN)%>" required><br>
            <label>Precio del Producto</label><br>
            <input type="number"  class="form-control" name="PrecioProducto" pattern="[0-9]+.[0-9]{2}" minlength ="1" maxlength="10" min="0" value="<%=ADMIN_PROD_Precio.get(IndiceN)%>" required><br>
            <label>Cantidad de productos en Stock</label><br>
            <input type="number"  class="form-control" name="StockProducto" pattern="[0-9]" min="1" minlength ="1" maxlength="5" value="<%=ADMIN_PROD_Stock.get(IndiceN)%>" required><br>
            <label>Categoria del producto</label> 
            <select name="SelectCategoria" class="form-control" default="Belleza">
                <option value="Automotriz" >Automotriz</option>
                <option value="Belleza">Belleza</option>
                <option value="Consolas">Consolas</option>
                <option value="Electrodomesticos">Electrodomesticos</option>
                <option value="Hardware">Hardware</option>
                <option value="HerramientasYFerreteria">HerramientasYFerreteria</option>
                <option value="Jardin">Jardin</option>
                <option value="Software">Software</option>
            
            </select><br>
            Los campos siguientes NO son obligatorios:<br>
            <label>Foto 1:</label><br>
            <input type="file"  class="form-control" name="Foto1Producto" accept=".pdf,.jpg,.png" minlength="5" value="<%=ADMIN_PROD_Foto1.get(IndiceN)%>"><br>
            <label>Foto 2:</label><br>
            <input type="file"  class="form-control" name="Foto2Producto" accept=".pdf,.jpg,.png" minlength="5" value="<%=ADMIN_PROD_Foto2.get(IndiceN)%>" ><br>
            <label>Foto 3:</label><br>
            <input type="file"  class="form-control" name="Foto3Producto" accept=".pdf,.jpg,.png" minlength="5" value="<%=ADMIN_PROD_Foto3.get(IndiceN)%>" ><br>
            <label>Video:</label><br>
            <input type="file"   class="form-control" name="VideoProducto"accept=".avi,.wav,.mp4" minlength="5" value="<%=ADMIN_PROD_Video.get(IndiceN)%>" ><br>
            
            <br>
            <br>
            <button type="Submit" name="envio" class="btn btn-success">Guardar Cambios</button>
     </div>        
            <a href="BotonCancelar?Opcion=<%=Origen%>" class="btn btn-secondary">Cancelar</a>
            </form>
       
    </div>
</center>    
</body>
</html>
