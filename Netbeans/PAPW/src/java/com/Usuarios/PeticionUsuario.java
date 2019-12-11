/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Usuarios;

import com.Connection.conection;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "PeticionUsuario", urlPatterns = {"/PeticionUsuario"})
public class PeticionUsuario extends HttpServlet {

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
            out.println("<title>Servlet PeticionUsuario</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PeticionUsuario at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
   HttpSession session = request.getSession(true);
   int MYID = (Integer) session.getAttribute("IdUsuario");
   

List<String> ID= new ArrayList<>();
List<String> ID_Prod= new ArrayList<>();
List<String> Nombre= new ArrayList<>();
List<String> Cantidad= new ArrayList<>();
List<String> SubTotal= new ArrayList<>();
List<String> Estado= new ArrayList<>();
List<String> Fecha= new ArrayList<>();
List<String> Foto1= new ArrayList<>();   
        try {
    
            conection con = new conection();
            con.getConnection();
            con.MisPeticiones(MYID, ID, ID_Prod, Nombre, Cantidad, SubTotal, Estado, Fecha,Foto1);
    
        } catch (Exception ex) {
            Logger.getLogger(SubirUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }

    
request.getSession().setAttribute("PETI_ID",ID);
request.getSession().setAttribute("PETI_ID_Prod",ID_Prod);
request.getSession().setAttribute("PETI_Nombre",Nombre);
request.getSession().setAttribute("PETI_Cantidad",Cantidad);
request.getSession().setAttribute("PETI_SubTotal",SubTotal);
request.getSession().setAttribute("PETI_Estado",Estado);
request.getSession().setAttribute("PETI_Fecha",Fecha);
request.getSession().setAttribute("PETI_Foto1",Foto1);    
    
    RequestDispatcher rd;
    rd = request.getRequestDispatcher("/peticiones.jsp");
    rd.forward(request,response);



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
