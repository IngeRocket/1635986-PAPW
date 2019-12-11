<%-- 
    Document   : productos
    Created on : 30/11/2019, 08:43:22 PM
    Author     : Julio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Productos</title>
    </head>
    <body>
        <%@ include file="navbar.jsp" %>
        <br>
         <h1 class="display-4"><%= categoria %></h1>
    
    <% if(IDProducto!= null){
        for(int i = 0; i< IDProducto.size();i++){
   
    %> 
  
        <div class="container-fluid">
        <div class="card mb-3" style=" width:80%; margin: auto;">
            <div class="row no-gutters">
                <div class="col-md-2">
                    <img src=<%=ProductoFoto1.get(i)%> class="card-img" alt="producto" height="150" >
                </div>
                <div class="col-md-8">
                    <div class="card-body">
                        <h5 class="card-title"><%=NombreProducto.get(i) %></h5>
                        <p class="card-text"><%=DescripcionProducto.get(i) %></p>
                       
                        <p class="card-text">
                            <%= PrecioProducto.get(i) %>
                            <a href="Especifico?ID=<%=i%>" class="btn btn-success" style="float:right;"> Ver producto</a>
                        
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
