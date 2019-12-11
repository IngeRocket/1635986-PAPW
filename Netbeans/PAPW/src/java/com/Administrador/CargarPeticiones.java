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
@WebServlet(name = "CargarPeticiones", urlPatterns = {"/CargarPeticiones"})
public class CargarPeticiones extends HttpServlet {

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
            out.println("<title>Servlet CargarPeticiones</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CargarPeticiones at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        List<String> PETICION_ID=new ArrayList<String>();    
        List<String> PETICION_ID_Prod=new ArrayList<String>();
        List<String> PETICION_Nombre=new ArrayList<String>();
        List<String> PETICION_Cantidad=new ArrayList<String>();
        List<String> PETICION_Sugerido=new ArrayList<String>();
        List<String> PETICION_Estado=new ArrayList<String>();
        List<String> PETICION_Fecha=new ArrayList<String>();
        List<String> PETICION_Foto=new ArrayList<String>();
        List<String> PETICION_Nick=new ArrayList<String>();
        try {
    
            conection con = new conection();
            con.getConnection();
            con.AdminCargarPeticiones(PETICION_ID,PETICION_ID_Prod,PETICION_Nombre,PETICION_Cantidad,PETICION_Sugerido,PETICION_Estado,PETICION_Fecha,PETICION_Foto,PETICION_Nick);
    
        } catch (Exception ex) {
            Logger.getLogger(SubirUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }

   request.getSession().setAttribute("PETICION_ID",PETICION_ID);
   request.getSession().setAttribute("PETICION_ID_Prod",PETICION_ID_Prod);
   request.getSession().setAttribute("PETICION_Nombre",PETICION_Nombre);
   request.getSession().setAttribute("PETICION_Cantidad",PETICION_Cantidad);
   request.getSession().setAttribute("PETICION_Sugerido",PETICION_Sugerido);
   request.getSession().setAttribute("PETICION_Estado",PETICION_Estado);
   request.getSession().setAttribute("PETICION_Fecha",PETICION_Fecha);
   request.getSession().setAttribute("PETICION_Foto",PETICION_Foto);
   request.getSession().setAttribute("PETICION_Nick",PETICION_Nick);
    
    RequestDispatcher rd;
    rd = request.getRequestDispatcher("/AdminPeticiones.jsp");
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
