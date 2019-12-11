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
@WebServlet(name = "Comentarios", urlPatterns = {"/Comentarios"})
public class Comentarios extends HttpServlet {

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
            out.println("<title>Servlet Comentarios</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Comentarios at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    //    processRequest(request, response);
            List<String> COMENTARIO_Texto = new ArrayList<>();
            List<String> COMENTARIO_Valor = new ArrayList<>();
            List<String> COMENTARIO_Fecha = new ArrayList<>();
            List<String> COMENTARIO_Nick =  new ArrayList<>();
            List<String> COMENTARIO_Suma = new ArrayList<>();
            List<String> COMENTARIO_Cuenta =  new ArrayList<>();
            COMENTARIO_Suma.add("0");
            COMENTARIO_Cuenta.add("0");
            
    
   int id = Integer.parseInt (request.getParameter("ID"));
      try {
    
            conection con = new conection();
            con.getConnection();
            con.ComentariosDeProducto(id, COMENTARIO_Nick, COMENTARIO_Texto, COMENTARIO_Fecha, COMENTARIO_Valor, COMENTARIO_Suma, COMENTARIO_Cuenta);
        //con;
        } catch (Exception ex) {
            Logger.getLogger(SubirUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
     int Suma = 0;
if(COMENTARIO_Suma.get(0) != null){
           Suma = Integer.parseInt(COMENTARIO_Suma.get(0));
}   
            int Cuenta = Integer.parseInt(COMENTARIO_Cuenta.get(0));
if(Cuenta==0){
COMENTARIO_Texto.clear();
COMENTARIO_Fecha.clear();
COMENTARIO_Nick.clear();
COMENTARIO_Valor.clear();
}



            request.getSession().setAttribute("Suma",Suma);
            request.getSession().setAttribute("Cuenta",Cuenta);
            request.getSession().setAttribute("COMENTARIO_Texto",COMENTARIO_Texto);
            request.getSession().setAttribute("COMENTARIO_Fecha",COMENTARIO_Fecha);
            request.getSession().setAttribute("COMENTARIO_Nick",COMENTARIO_Nick);
            request.getSession().setAttribute("COMENTARIO_Valor",COMENTARIO_Valor);
      
   
   //         request.getSession().setAttribute("IDEspecifico",id);
            RequestDispatcher rd;
            rd = request.getRequestDispatcher("/Comentarios.jsp");
            rd.forward(request,response);
         //response.sendRedirect("/PAPW/producto.jsp");
    //aqui cargar codifo para comentarios de productos
    
    
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
