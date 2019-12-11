/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.categorias;


import com.Connection.conection;
import com.Productos.ObtenerProductos;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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
@WebServlet(name = "Consolas", urlPatterns = {"/Consolas"})
public class Consolas extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Consolas</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Consolas at " + request.getContextPath() + "</h1>");
            out.println("<h2>Entraste al get baboso</h2></body>");
            out.println("</html>");
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
          NumeroCategoria N = new NumeroCategoria();
            int numero = N.GetCategoria("Consolas");
            conection comando = new conection();
            comando.getConnection();
         
            List <String> BajaProducto = new ArrayList<>();
             List<String> IDProducto = new ArrayList<>();
            List <String> NombreProducto = new ArrayList<>();
            List <String> PrecioProducto = new ArrayList<>();
            List <String> DescripcionProducto = new ArrayList<>();
            List <String> StockProducto = new ArrayList<>();
            List <String> ProductoFoto1 = new ArrayList<>();
            List <String> ProductoFoto2 = new ArrayList<>();
            List <String> ProductoFoto3 = new ArrayList<>();
            List <String> ProductoVideo = new ArrayList<>();        
            
            
    try{
        comando.VerCategoria(numero,IDProducto,NombreProducto,DescripcionProducto,PrecioProducto,StockProducto,ProductoFoto1,ProductoFoto2,ProductoFoto3,ProductoVideo,BajaProducto);
        }catch(Exception EX){
        //nada haha
        }
         
         
            
            request.getSession().setAttribute("IDProductos",IDProducto);
            request.getSession().setAttribute("NombreProducto",NombreProducto);
            request.getSession().setAttribute("DescripcionProducto",DescripcionProducto);
            request.getSession().setAttribute("PrecioProducto",PrecioProducto);
            request.getSession().setAttribute("StockProducto",StockProducto);
            request.getSession().setAttribute("ProductosFoto1",ProductoFoto1);
            request.getSession().setAttribute("ProductosFoto2",ProductoFoto2);
            request.getSession().setAttribute("ProductosFoto3",ProductoFoto3);
            request.getSession().setAttribute("ProductosVideo",ProductoVideo);
            request.getSession().setAttribute("BajaProductos",BajaProducto);
            request.getSession().setAttribute("Categoria","Consolas");

            RequestDispatcher rd;
            rd = request.getRequestDispatcher("/productos.jsp");
            rd.forward(request,response);
            //request.getRequestDispatcher("/productos.jsp").forward(request,response);


    
    
    
        
        
        //fin de copiado por seguridad
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    
    }
    
   

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
