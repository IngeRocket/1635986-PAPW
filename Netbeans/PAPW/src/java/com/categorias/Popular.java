/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.categorias;

import com.Connection.conection;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
@WebServlet(name = "Popular", urlPatterns = {"/Popular"})
public class Popular extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Popular</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Popular at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
         List<String>   NombreProducto = (List<String>)   request.getSession().getAttribute("NuevoNombre");
         List<String>   PrecioProducto = (List<String>) request.getSession().getAttribute("NuevoPrecio");
         List<String>   DescripcionProducto = (List<String>)  request.getSession().getAttribute("NuevoDescripcion");
         List<String>   StockProducto = (List<String>) request.getSession().getAttribute("NuevoStock");
         List<String>   ProductoFoto1 = (List<String>)request.getSession().getAttribute("NuevoFoto1");
         List<String>   ProductoFoto2 = (List<String>)request.getSession().getAttribute("NuevoFoto2");
         List<String>   ProductoFoto3 = (List<String>) request.getSession().getAttribute("NuevoFoto3");
         List<String>   ProductoVideo= (List<String>) request.getSession().getAttribute("NuevoVideo");
         List<String>   IDProducto = (List<String>)request.getSession().getAttribute("NuevoIDProductos");
        List <String> BajaProducto = new ArrayList<>();   
        
           try{
        conection comando = new conection();
        comando.getConnection();
        comando.ProductosPopulares(IDProducto,NombreProducto,DescripcionProducto,PrecioProducto,StockProducto,ProductoFoto1,ProductoFoto2,ProductoFoto3,ProductoVideo,BajaProducto);
        }catch(Exception EX){
        //nada haha
        }
      
        
           //RequestDispatcher rd;
            //rd = request.getRequestDispatcher("/index.jsp");
            //rd.forward(request,response);
            response.sendRedirect("/PAPW/index.jsp");   
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        
    }
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
