/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Administrador;

import com.Connection.conection;
import com.Usuarios.SubirUsuario;
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

/**
 *
 * @author Julio
 */
@WebServlet(name = "CargarRespuestas", urlPatterns = {"/CargarRespuestas"})
public class CargarRespuestas extends HttpServlet {

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
            out.println("<title>Servlet CargarRespuestas</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CargarRespuestas at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
           List<String>ID=new ArrayList<>();
           List<String>ID_Prod=new ArrayList<>();
           List<String>Nombre=new ArrayList<>();
           List<String>Cantidad=new ArrayList<>();
           List<String>SubTotal=new ArrayList<>();
           List<String>Estado=new ArrayList<>();
           List<String>Fecha=new ArrayList<>();
           List<String>Foto=new ArrayList<>();
           List<String>Nick=new ArrayList<>();
        try {
    
            conection con = new conection();
            con.getConnection();
            con.AdminCargarRespuestas(ID, ID_Prod, Nombre, Cantidad, SubTotal, Estado, Fecha, Foto, Nick);
    
        } catch (Exception ex) {
            Logger.getLogger(SubirUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }

   request.getSession().setAttribute("PETICION_ID",ID);
   request.getSession().setAttribute("PETICION_ID_Prod",ID_Prod);
   request.getSession().setAttribute("PETICION_Nombre",Nombre);
   request.getSession().setAttribute("PETICION_Cantidad",Cantidad);
   request.getSession().setAttribute("PETICION_Sugerido",SubTotal);
   request.getSession().setAttribute("PETICION_Estado",Estado);
   request.getSession().setAttribute("PETICION_Fecha",Fecha);
   request.getSession().setAttribute("PETICION_Foto",Foto);
   request.getSession().setAttribute("PETICION_Nick",Nick);
    
    RequestDispatcher rd;
    rd = request.getRequestDispatcher("/AdminRespuestas.jsp");
    rd.forward(request,response);
 
        
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
