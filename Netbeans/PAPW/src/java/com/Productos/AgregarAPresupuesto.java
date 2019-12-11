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
import java.sql.SQLException;
import java.util.ArrayList;
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
@WebServlet(name = "AgregarAPresupuesto", urlPatterns = {"/AgregarAPresupuesto"})
public class AgregarAPresupuesto extends HttpServlet {

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
            out.println("<title>Servlet AgregarAPresupuesto</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AgregarAPresupuesto at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
 

    
    
    }
 @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        processRequest(request, response);
    HttpSession session = request.getSession(true);
    int valor = (Integer) session.getAttribute("IDEspecifico");
    int cantidadProductos = Integer.parseInt(request.getParameter("presupuestar"));
   int MYID = (Integer) session.getAttribute("IdUsuario");
    List<String> ElementosID = (List<String>) session.getAttribute("IDProductos");    
   
    
    
    
    List<String> Stock = (List<String>) session.getAttribute("StockProducto");
    int idReal = Integer.parseInt(ElementosID.get(valor));
    int ViejoStock = Integer.parseInt(Stock.get(valor));
    ViejoStock= ViejoStock - cantidadProductos;
    String  NuevoStock = "";
    NuevoStock = Integer.toString(ViejoStock);

    Stock.set(valor, NuevoStock);

    
        try {
    
            conection con = new conection();
            con.getConnection();
            con.CrearPeticion(MYID,idReal,cantidadProductos);
    
        } catch (Exception ex) {
            Logger.getLogger(SubirUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }

    
    
    
    
    
    request.getSession().setAttribute("StockProducto",Stock);
    RequestDispatcher rd;
    rd = request.getRequestDispatcher("/producto.jsp");
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
