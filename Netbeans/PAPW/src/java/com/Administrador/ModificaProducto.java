/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Administrador;

import com.Connection.conection;
import com.Usuarios.SubirUsuario;
import com.categorias.NumeroCategoria;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Julio
 */
@WebServlet(name = "ModificaProducto", urlPatterns = {"/ModificaProducto"})
public class ModificaProducto extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ModificaProducto</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ModificaProducto at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      int ID = Integer.parseInt(request.getParameter("ID"));
      String Origen = request.getParameter("Origen");
      request.getSession().setAttribute("Origen", Origen);
      request.getSession().setAttribute("IndiceN",ID);
    RequestDispatcher rd;
    rd = request.getRequestDispatcher("/AdminEditaProducto.jsp");
    rd.forward(request,response);
        
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      //recoger TODA LA INFORMACION QUE PUEDE SER MODIFICABLE
        NumeroCategoria consulta = new NumeroCategoria();
      
        String Nombre = request.getParameter("NombreProducto");
        String Descripcion = request.getParameter("DescripcionProducto");
        String Precio = request.getParameter("PrecioProducto");
        String Stock = request.getParameter("StockProducto");
        String Categoria = request.getParameter("SelectCategoria");
        String Foto1 = request.getParameter("Foto1Producto");
        String Foto2 = request.getParameter("Foto2Producto");
        String Foto3 = request.getParameter("Foto3Producto");
        String Video = request.getParameter("VideoProducto");
        
        HttpSession session = request.getSession(true);
        int Indice = (Integer) session.getAttribute("IndiceN");
        List<String>PROD_FOTO1 =(List<String>) session.getAttribute("ADMIN_PROD_Foto1");
        List<String>PROD_FOTO2 = (List<String>) session.getAttribute("ADMIN_PROD_Foto2");
        List<String>PROD_FOTO3 = (List<String>) session.getAttribute("ADMIN_PROD_Foto3");
        List<String>PROD_Video = (List<String>) session.getAttribute("ADMIN_PROD_Video");
        
        String ruta="productos/";
        if(Foto1.length() == 0){
        Foto1 = PROD_FOTO1.get(Indice);
        }else{
        Foto1=ruta + Foto1;
        PROD_FOTO1.set(Indice,Foto1);
        }
        
        if(Foto2.length() == 0){
            Foto2 = PROD_FOTO2.get(Indice);
        }else{
        Foto2=ruta + Foto2;
        PROD_FOTO2.set(Indice,Foto2);
        }
        
        if(Foto3.length() == 0){
            Foto3 = PROD_FOTO3.get(Indice);
        }else{
        Foto3=ruta + Foto3;
        PROD_FOTO3.set(Indice,Foto3);
        }
        
        if(Video.length() == 0){
            Video = PROD_Video.get(Indice);       
        }else{
        Video = ruta + Video;
        PROD_FOTO1.set(Indice,Video);        
        }
        
   List<String> ADMIN_PROD_ID_Prod=(List<String>)session.getAttribute("ADMIN_PROD_ID_Prod");
   List<String> ADMIN_PROD_Nombre=(List<String>)session.getAttribute("ADMIN_PROD_Nombre");
   List<String> ADMIN_PROD_Stock=(List<String>)session.getAttribute("ADMIN_PROD_Stock");
   List<String> ADMIN_PROD_Precio=(List<String>)session.getAttribute("ADMIN_PROD_Precio");
   List<String> ADMIN_PROD_Descripcion=(List<String>)session.getAttribute("ADMIN_PROD_Descripcion");    
   List<String> ADMIN_PROD_Categoria=(List<String>)session.getAttribute("ADMIN_PROD_Categoria");
        
        
        
       int idCategoria = consulta.GetCategoria(Categoria);
       //inicio de conexion a base de datos
       int IDaCambiar = Integer.parseInt(ADMIN_PROD_ID_Prod.get(Indice));
       double aux = Double.parseDouble(Precio);
       int NNStock = Integer.parseInt(Stock);
           try {
    
            conection con = new conection();
            con.getConnection();
          con.CambiarDatos(IDaCambiar,Nombre,Descripcion, aux, NNStock, Video, Foto1, Foto2, Foto3, idCategoria);
    
        } catch (Exception ex) {
            Logger.getLogger(SubirUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
       //fin de comando
       
        ADMIN_PROD_Nombre.set(Indice,Nombre);
        ADMIN_PROD_Stock.set(Indice,Stock);
        ADMIN_PROD_Precio.set(Indice,Precio);
        ADMIN_PROD_Descripcion.set(Indice,Descripcion);
        ADMIN_PROD_Categoria.set(Indice,Integer.toString(idCategoria));
           
           
       //inicio de redireccion
       String Origen = (String)request.getSession().getAttribute("Origen");
      switch(Origen){
        case "Borradores":{
                RequestDispatcher rd;
    rd = request.getRequestDispatcher("/AdminBorradores.jsp");
    rd.forward(request,response);
            break;}
        case "Cementerio":{
                RequestDispatcher rd;
    rd = request.getRequestDispatcher("/AdminCementerio.jsp");
    rd.forward(request,response);
            break;}
        case "Vigentes":{
    RequestDispatcher rd;
    rd = request.getRequestDispatcher("/AdminTodoProductos.jsp");
    rd.forward(request,response);            
            break;}
    }
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
