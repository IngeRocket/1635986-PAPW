/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Productos;

import com.Connection.conection;
import com.Usuarios.SubirUsuario;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "CompraDestacados", urlPatterns = {"/CompraDestacados"})
public class CompraDestacados extends HttpServlet {

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
            out.println("<title>Servlet CompraDestacados</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CompraDestacados at " + request.getContextPath() + "</h1>");
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
        //processRequest(request, response);
        
 
      HttpSession session = request.getSession(true);
    int valor = (Integer) session.getAttribute("IDEspecifico");
    int MYID = (Integer) session.getAttribute("IdUsuario");
    int cantidadDeCompra = Integer.parseInt(request.getParameter("presupuestar"));
    List<String> Stock = (List<String>) session.getAttribute("NuevoStock");
    int ViejoStock = Integer.parseInt(Stock.get(valor));
    String  NuevoStock = "";
    NuevoStock = Integer.toString(ViejoStock - cantidadDeCompra);
     
    Stock.set(valor, NuevoStock);

      List<String> ProdID = (List<String>) session.getAttribute("NuevoIDProductos");
      int idReal = Integer.parseInt(ProdID.get(valor));
      
      try {
    
            conection con = new conection();
            con.getConnection();
            con.CrearPeticion(MYID,idReal,cantidadDeCompra);
    
        } catch (Exception ex) {
            Logger.getLogger(SubirUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }

    
    
    
    
    
    request.getSession().setAttribute("NuevoStock",Stock);
    RequestDispatcher rd;
    rd = request.getRequestDispatcher("/Principales.jsp");
    rd.forward(request,response);
    
  
    
    
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
