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
@WebServlet(name = "RespondePeticion", urlPatterns = {"/RespondePeticion"})
public class RespondePeticion extends HttpServlet {

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
            out.println("<title>Servlet RespondePeticion</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RespondePeticion at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
  int numero = Integer.parseInt(request.getParameter("ID"));
    request.getSession().setAttribute("IndiceN", numero);
    
    RequestDispatcher rd;
    rd = request.getRequestDispatcher("/AdminPeticionEspecifica.jsp");
    rd.forward(request,response);    

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        processRequest(request, response);

  HttpSession session = request.getSession(true);
    
    int numero = (Integer)session.getAttribute("IndiceN");
    double precio = Double.parseDouble(request.getParameter("PrecioProducto"));
   List<String> PETICION_ID =(List<String>) session.getAttribute("PETICION_ID");
   List<String> PETICION_ID_Prod=(List<String>)session.getAttribute("PETICION_ID_Prod");
   List<String> PETICION_Nombre=(List<String>)session.getAttribute("PETICION_Nombre");
   List<String> PETICION_Cantidad=(List<String>)session.getAttribute("PETICION_Cantidad");
   List<String> PETICION_Sugerido=(List<String>)session.getAttribute("PETICION_Sugerido");
   List<String> PETICION_Estado=(List<String>)session.getAttribute("PETICION_Estado");
   List<String> PETICION_Fecha=(List<String>)session.getAttribute("PETICION_Fecha");
   List<String> PETICION_Foto=(List<String>)session.getAttribute("PETICION_Foto");
   List<String> PETICION_Nick=(List<String>)session.getAttribute("PETICION_Nick");    
    int ID_Peticion = Integer.parseInt(PETICION_ID.get(numero));

            try {
            conection con = new conection();
            con.getConnection();
            con.AdminResponderPeticion(ID_Peticion, precio);
        } catch (Exception ex) {
            Logger.getLogger(SubirUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
PETICION_ID.remove(numero);
PETICION_ID_Prod.remove(numero);
PETICION_Nombre.remove(numero);
PETICION_Cantidad.remove(numero);
PETICION_Sugerido.remove(numero);
PETICION_Estado.remove(numero);
PETICION_Fecha.remove(numero);
PETICION_Foto.remove(numero);
PETICION_Nick.remove(numero);
        
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
