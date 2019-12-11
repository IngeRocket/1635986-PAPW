/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Administrador;

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
@WebServlet(name = "CargarBorradores", urlPatterns = {"/CargarBorradores"})
public class CargarBorradores extends HttpServlet {

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
            out.println("<title>Servlet CargarBorradores</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CargarBorradores at " + request.getContextPath() + "</h1>");
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
         
   List<String> ADMIN_PROD_ID_Prod = new ArrayList();
   List<String> ADMIN_PROD_Nombre = new ArrayList();
   List<String> ADMIN_PROD_Stock = new ArrayList();
   List<String> ADMIN_PROD_Precio = new ArrayList();
   List<String> ADMIN_PROD_Borrador = new ArrayList();
   List<String> ADMIN_PROD_Baja = new ArrayList();
   List<String> ADMIN_PROD_Foto1 = new ArrayList();
   List<String> ADMIN_PROD_Foto2 = new ArrayList();
   List<String> ADMIN_PROD_Foto3 = new ArrayList();
   List<String> ADMIN_PROD_Descripcion = new ArrayList();   
   List<String> ADMIN_PROD_Video = new ArrayList();
   List<String> ADMIN_PROD_Categoria = new ArrayList();
        
        
    try{
        conection comando = new conection();
            comando.getConnection();
    comando.CargaBorradores(ADMIN_PROD_ID_Prod,ADMIN_PROD_Nombre,ADMIN_PROD_Stock,ADMIN_PROD_Precio,ADMIN_PROD_Borrador,ADMIN_PROD_Baja,ADMIN_PROD_Foto1,ADMIN_PROD_Foto2,ADMIN_PROD_Foto3,ADMIN_PROD_Video,ADMIN_PROD_Descripcion,ADMIN_PROD_Categoria);
    }catch(Exception EX){
        //nada haha
        }
   
    request.getSession().setAttribute("ADMIN_PROD_ID_Prod",ADMIN_PROD_ID_Prod);
    request.getSession().setAttribute("ADMIN_PROD_Nombre",ADMIN_PROD_Nombre);
    request.getSession().setAttribute("ADMIN_PROD_Stock",ADMIN_PROD_Stock);
    request.getSession().setAttribute("ADMIN_PROD_Precio",ADMIN_PROD_Precio);
    request.getSession().setAttribute("ADMIN_PROD_Borrador",ADMIN_PROD_Borrador);
    request.getSession().setAttribute("ADMIN_PROD_Baja",ADMIN_PROD_Baja);
    request.getSession().setAttribute("ADMIN_PROD_Foto1",ADMIN_PROD_Foto1);
    request.getSession().setAttribute("ADMIN_PROD_Foto2",ADMIN_PROD_Foto2);
    request.getSession().setAttribute("ADMIN_PROD_Foto3",ADMIN_PROD_Foto3);
    request.getSession().setAttribute("ADMIN_PROD_Video",ADMIN_PROD_Video);
    request.getSession().setAttribute("ADMIN_PROD_Categoria",ADMIN_PROD_Categoria);
    request.getSession().setAttribute("ADMIN_PROD_Descripcion",ADMIN_PROD_Descripcion);
    
    
    
    
    
    
         RequestDispatcher rd;
            rd = request.getRequestDispatcher("/AdminBorradores.jsp");
            rd.forward(request,response);
            //request.getRequestDispatcher("/productos.jsp").forward(request,response);

   
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
