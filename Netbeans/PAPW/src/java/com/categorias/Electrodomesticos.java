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
@WebServlet(name = "Electrodomesticos", urlPatterns = {"/Electrodomesticos"})
public class Electrodomesticos extends HttpServlet {

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
            out.println("<title>Servlet Electrodomesticos</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Electrodomesticos at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
     protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
          NumeroCategoria N = new NumeroCategoria();
            int numero = N.GetCategoria("Electrodomesticos");
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
            request.getSession().setAttribute("Categoria","Electrodomesticos");

            RequestDispatcher rd;
            rd = request.getRequestDispatcher("/productos.jsp");
            rd.forward(request,response);
            //request.getRequestDispatcher("/productos.jsp").forward(request,response);


    
    
    
        
        
        //fin de copiado por seguridad
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
