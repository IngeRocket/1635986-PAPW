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
@WebServlet(name = "Principal", urlPatterns = {"/Principal"})
public class Principal extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Principal</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Principal at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        processRequest(request, response);
         
        
            List<String> IDProducto = new ArrayList<>();
            List <String> NombreProducto = new ArrayList<>();
            List <String> PrecioProducto = new ArrayList<>();
            List <String> DescripcionProducto = new ArrayList<>();
            List <String> StockProducto = new ArrayList<>();
            List <String> ProductoFoto1 = new ArrayList<>();
            List <String> ProductoFoto2 = new ArrayList<>();
            List <String> ProductoFoto3 = new ArrayList<>();
            List <String> ProductoVideo = new ArrayList<>();        
            List <String> BajaProducto = new ArrayList<>();    
            //consulta de nuevos
    try{
        conection comando = new conection();
        comando.getConnection();      
        comando.VerNuevo(IDProducto,NombreProducto,DescripcionProducto,PrecioProducto,StockProducto,ProductoFoto1,ProductoFoto2,ProductoFoto3,ProductoVideo,BajaProducto);
        
            
    }catch(Exception EX){
        //nada haha
        }
    
    //guardar
            request.getSession().setAttribute("NuevoNombre",NombreProducto);
            request.getSession().setAttribute("NuevoPrecio",PrecioProducto);
            request.getSession().setAttribute("NuevoDescripcion",DescripcionProducto);
            request.getSession().setAttribute("NuevoStock",StockProducto);
            request.getSession().setAttribute("NuevoFoto1",ProductoFoto1);
            request.getSession().setAttribute("NuevoFoto2",ProductoFoto2);
            request.getSession().setAttribute("NuevoFoto3",ProductoFoto3);
            request.getSession().setAttribute("NuevoVideo",ProductoVideo);
            request.getSession().setAttribute("NuevoIDProductos",IDProducto);
               
            RequestDispatcher rd;
            rd = request.getRequestDispatcher("Popular");
            rd.forward(request,response);
          //response.sendRedirect("/PAPW/index.jsp");            
               
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
