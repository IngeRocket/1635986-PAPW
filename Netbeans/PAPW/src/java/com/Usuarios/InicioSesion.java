/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Usuarios;

import com.Connection.conection;
import com.Usuarios.FotoUsuario;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;


//import java.sql.Connection;
//import com.mysql.jdbc.Connection;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Julio
 */
@WebServlet(name = "InicioSesion", urlPatterns = {"/InicioSesion"})
public class InicioSesion extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       FotoUsuario n = null;
    n = (FotoUsuario)request.getSession().getAttribute("Informacion");
    n.PreparameFoto(response);
   //FotoUsuario n = new FotoUsuario();
//InputStream Imagen = (InputStream)request.getSession().getAttribute("LaFoto");  


n.PreparameFoto(response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
  
  String nick = request.getParameter("my_nombre");
  String pass = request.getParameter("my_pass");
  String estado = request.getParameter("Estado");

    FotoUsuario Mifoto = new FotoUsuario();
 
//inicio
  if(estado.compareTo("Administrador")==0){
Boolean verdad = false;
try{
conection con = new conection();
con.getConnection();
verdad = con.Login(nick,pass,1, Mifoto);
}catch(Exception ex){

}
if(verdad){
   
    request.getSession().setAttribute("Nombre",nick);

RequestDispatcher rd;
rd = request.getRequestDispatcher("/Administrador.jsp");
rd.forward(request,response);

}else{
    
RequestDispatcher rd;
rd = request.getRequestDispatcher("/login.jsp");
rd.forward(request,response);

}


//fin  
  }else{
Boolean verdad = false;
try{
conection con = new conection();
con.getConnection();
verdad = con.Login(nick,pass,0,Mifoto);
}catch(Exception ex){

}
if(verdad){
//Mifoto.PreparameFoto(response);
int numero = Mifoto.getIdUsuario();
request.getSession().setAttribute("Nombre",Mifoto.getNick());
request.getSession().setAttribute("IdUsuario",numero);
request.getSession().setAttribute("Informacion",Mifoto);
InputStream nuevoDato = Mifoto.GetMiFoto();
request.getSession().setAttribute("LaFoto",nuevoDato);
RequestDispatcher rd;
rd = request.getRequestDispatcher("/index.jsp");
rd.forward(request,response);

}else{
RequestDispatcher rd;
rd = request.getRequestDispatcher("/login.jsp");
rd.forward(request,response);

}
  
  }
  
  
//if(estado!=null){
//no intenta hacer login como administrados (el null es solo el valor del checkbox convertido a String)
//Comando = new com.Connection.conection();




//response.sendRedirect("/PAPW/index.jsp");
//}else{
//RequestDispatcher rd;
//rd = request.getRequestDispatcher("/Administrador.jsp");

//}



    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
