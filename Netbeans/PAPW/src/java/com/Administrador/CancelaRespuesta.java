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
@WebServlet(name = "CancelaRespuesta", urlPatterns = {"/CancelaRespuesta"})
public class CancelaRespuesta extends HttpServlet {

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
            out.println("<title>Servlet CancelaRespuesta</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CancelaRespuesta at " + request.getContextPath() + "</h1>");
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
       // processRequest(request, response);
       
        HttpSession session = request.getSession(true);
        int ID = Integer.parseInt(request.getParameter("ID"));
   
   List<String> PETICION_ID =(List<String>) session.getAttribute("PETICION_ID");
   List<String> PETICION_ID_Prod=(List<String>)session.getAttribute("PETICION_ID_Prod");
   List<String> PETICION_Nombre=(List<String>)session.getAttribute("PETICION_Nombre");
   List<String> PETICION_Cantidad=(List<String>)session.getAttribute("PETICION_Cantidad");
   List<String> PETICION_Sugerido=(List<String>)session.getAttribute("PETICION_Sugerido");
   List<String> PETICION_Estado=(List<String>)session.getAttribute("PETICION_Estado");
   List<String> PETICION_Fecha=(List<String>)session.getAttribute("PETICION_Fecha");
   List<String> PETICION_Foto=(List<String>)session.getAttribute("PETICION_Foto");
   List<String> PETICION_Nick=(List<String>)session.getAttribute("PETICION_Nick");    
    int ID_Peticion = Integer.parseInt(PETICION_ID.get(ID));

   try {
    
            conection con = new conection();
            con.getConnection();
            con.AdminCancelarRespuesta(ID_Peticion);
    
        } catch (Exception ex) {
            Logger.getLogger(SubirUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    
PETICION_ID.remove(ID);
PETICION_ID_Prod.remove(ID);
PETICION_Nombre.remove(ID);
PETICION_Cantidad.remove(ID);
PETICION_Sugerido.remove(ID);
PETICION_Estado.remove(ID);
PETICION_Fecha.remove(ID);
PETICION_Foto.remove(ID);
PETICION_Nick.remove(ID);
        
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
