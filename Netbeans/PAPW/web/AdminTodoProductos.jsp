<%-- 
    Document   : AdminTodoProductos
    Created on : 9/12/2019, 12:59:11 PM
    Author     : Julio
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modificar</title>
    </head>
   <body>
        <%@ include file="AdminNavbar.jsp" %>
        <br>
         <h1 class="display-4">Modificar Producto</h1>
    
    <% if(ADMIN_PROD_ID_Prod!= null){
        for(int i = 0; i< ADMIN_PROD_ID_Prod.size();i++){
   String miAux = "";
if(ADMIN_PROD_Categoria.get(i).compareTo("1")==0)
    miAux ="Automotriz"; 
if(ADMIN_PROD_Categoria.get(i).compareTo("2")==0)
       miAux ="Belleza"; 
if(ADMIN_PROD_Categoria.get(i).compareTo("3")==0)
        miAux ="Consolas"; 
if(ADMIN_PROD_Categoria.get(i).compareTo("4")==0)
        miAux ="Electrodomesticos";
if(ADMIN_PROD_Categoria.get(i).compareTo("5")==0)
        miAux ="Hardware";
if(ADMIN_PROD_Categoria.get(i).compareTo("6")==0)
      miAux ="HerramientasYFerreteria";
if(ADMIN_PROD_Categoria.get(i).compareTo("7")==0)
       miAux ="Jardin"; 
 if(ADMIN_PROD_Categoria.get(i).compareTo("8")==0)
       miAux ="Software"; 

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
                            Categoria: <%=miAux%><br>
                            Stock: <%=ADMIN_PROD_Stock.get(i)%><br>
                            Precio: <%= ADMIN_PROD_Precio.get(i) %>
                            <a href="ModificaProducto?ID=<%=i%>&Origen=Vigentes" class="btn btn-info" style="float:right;"> Editar producto</a>
                            <a href="EliminarProducto?ID=<%=i%>&Origen=Vigentes" class="btn btn-danger" style="float:right;"> Borrar producto</a>
                            
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
