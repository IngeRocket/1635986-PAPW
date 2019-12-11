/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Usuarios;

import com.Connection.conection;
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
@WebServlet(name = "Comentar", urlPatterns = {"/Comentar"})
public class Comentar extends HttpServlet {

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
            out.println("<title>Servlet Comentar</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Comentar at " + request.getContextPath() + "</h1>");
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
    int idProducto = Integer.parseInt(request.getParameter("ID"));
    request.getSession().setAttribute("IDEspecifico",idProducto);
    
            RequestDispatcher rd;
            rd = request.getRequestDispatcher("/Comentar.jsp");
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
String Comentario = request.getParameter("MiOpinion");
String voto = request.getParameter("Voto");
int Elvoto = 0;
if(voto.compareTo("Positiva")==0){
Elvoto=1;
}
  HttpSession session = request.getSession(true);
   int MYID = (Integer) session.getAttribute("IdUsuario");
   int Posicion =(Integer) session.getAttribute("IDEspecifico");
        
   
        
            List<String> HISTORIAL_ID =             (List<String>)session.getAttribute("HISTORIAL_ID");
            List<String> HISTORIAL_ID_Prod =        (List<String>)session.getAttribute("HISTORIAL_ID_Prod");
            List<String> HISTORIAL_Nombre =         (List<String>)session.getAttribute("HISTORIAL_Nombre");
            List<String> HISTORIAL_Cantidad =       (List<String>)session.getAttribute("HISTORIAL_Cantidad");
            List<String> HISTORIAL_Precio =         (List<String>)session.getAttribute("HISTORIAL_Precio");
            List<String> HISTORIAL_Estado =         (List<String>)session.getAttribute("HISTORIAL_Estado");
            List<String> HISTORIAL_FechaPago =      (List<String>)session.getAttribute("HISTORIAL_FechaPago");
            List<String> HISTORIAL_Foto1 =          (List<String>)session.getAttribute("HISTORIAL_Foto1");
            List<String> HISTORIAL_Comentado =      (List<String>)session.getAttribute("HISTORIAL_Comentado");
            List<String> HISTORIAL_Nick =           (List<String>)session.getAttribute("HISTORIAL_Nick");
            
        int IDCompra = Integer.parseInt(HISTORIAL_ID.get(Posicion));
        int ElProducto = Integer.parseInt(HISTORIAL_ID_Prod.get(Posicion));
         try {
    
            conection con = new conection();
            con.getConnection();
        con.SubirComentario(IDCompra, MYID, Comentario, Elvoto, ElProducto);
        } catch (Exception ex) {
            Logger.getLogger(SubirUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }

   
   HISTORIAL_Comentado.set(Posicion,"1");
        RequestDispatcher rd;
            rd = request.getRequestDispatcher("/historial.jsp");
            rd.forward(request,response);


    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
