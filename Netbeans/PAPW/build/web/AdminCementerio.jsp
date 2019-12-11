<%-- 
    Document   : AdminCementerio
    Created on : 9/12/2019, 03:13:10 PM
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
        <br>
         <h1 class="display-4">Cementerio</h1>
    
    <% if(ADMIN_PROD_ID_Prod!= null){
        for(int i = 0; i< ADMIN_PROD_ID_Prod.size();i++){
   
    %> 
  
        <div class="container-fluid">
        <div class="card mb-3" style=" width:80%; margin: auto;">
            <div class="row no-gutters">
                <div class="col-md-2">
                    <img src=<%=ADMIN_PROD_Foto1.get(i)%> class="card-img" alt="producto" height="150" >
                </div>
                <div class="col-md-8">
                    <div class="card-body">
                        <h5 class="card-title">Producto: <%=ADMIN_PROD_Nombre.get(i) %></h5>
                        <p class="card-text">Descripcion: <%=ADMIN_PROD_Descripcion.get(i) %><br>
                       
                            Stock: <%=ADMIN_PROD_Stock.get(i)%><br>
                            Precio: <%= ADMIN_PROD_Precio.get(i) %>
                            <a href="RevivirProducto?ID=<%=i%>&Origen=Cementerio" class="btn btn-info" style="float:right;"> Revivir</a>
                            
                        </p>
                    
                    </div>
                </div>
            </div>
        </div>
    </div>  
        <%
                    }
                }
            %>
    </body>
</html>
