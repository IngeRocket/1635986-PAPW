/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Usuarios;

import com.Connection.conection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.List;
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
@WebServlet(name = "EliminarCarrito", urlPatterns = {"/EliminarCarrito"})
public class EliminarCarrito extends HttpServlet {

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
            out.println("<title>Servlet EliminarCarrito</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EliminarCarrito at " + request.getContextPath() + "</h1>");
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
//        processRequest(request, response);
  int indiceSeleccion = Integer.parseInt(request.getParameter("ID"));
    
   HttpSession session = request.getSession(true);
    session.getAttribute("IdUsuario");
  
   
    int MYID = (Integer)session.getAttribute("IdUsuario");
    
            List<String> HISTORIAL_ID =         (List<String>)session.getAttribute("HISTORIAL_ID");
            List<String> HISTORIAL_ID_Prod =    (List<String>)session.getAttribute("HISTORIAL_ID_Prod");
            List<String> HISTORIAL_Nombre =     (List<String>)session.getAttribute("HISTORIAL_Nombre");
            List<String> HISTORIAL_Cantidad =   (List<String>)session.getAttribute("HISTORIAL_Cantidad");
            List<String> HISTORIAL_Precio =         (List<String>)session.getAttribute("HISTORIAL_Precio");
            List<String> HISTORIAL_Estado =         (List<String>)session.getAttribute("HISTORIAL_Estado");
            List<String> HISTORIAL_FechaPago =      (List<String>)session.getAttribute("HISTORIAL_FechaPago");
            List<String> HISTORIAL_Foto1 =          (List<String>)session.getAttribute("HISTORIAL_Foto1");
            List<String> HISTORIAL_Comentado =      (List<String>)session.getAttribute("HISTORIAL_Comentado");
            List<String> HISTORIAL_Nick =           (List<String>)session.getAttribute("HISTORIAL_Nick");
            List<String>HISTORIAL_PAGO =(List<String>)session.getAttribute("HISTORIAL_PAGO");
    
        int CarritoID = Integer.parseInt(HISTORIAL_ID.get(indiceSeleccion));
        int producto = Integer.parseInt(HISTORIAL_ID_Prod.get(indiceSeleccion));
        int cantidad = Integer.parseInt(HISTORIAL_Cantidad.get(indiceSeleccion));
    
   conection comando = new conection();
  try{
        comando.getConnection();
        comando.EliminarDeCarrito(CarritoID, producto, cantidad);
        
                }catch(Exception EX){
        //nada haha
        }
        
        HISTORIAL_ID.remove(indiceSeleccion);    
        HISTORIAL_ID_Prod.remove(indiceSeleccion);
        HISTORIAL_Nombre.remove(indiceSeleccion);
        HISTORIAL_Cantidad.remove(indiceSeleccion);
        HISTORIAL_Precio.remove(indiceSeleccion);
        HISTORIAL_Estado.remove(indiceSeleccion);
        HISTORIAL_FechaPago.remove(indiceSeleccion);
        HISTORIAL_Foto1.remove(indiceSeleccion);
        HISTORIAL_Comentado.remove(indiceSeleccion);
        HISTORIAL_Nick.remove(indiceSeleccion);
        HISTORIAL_PAGO.remove(indiceSeleccion);
  
        RequestDispatcher rd;
        rd = request.getRequestDispatcher("/carrito.jsp");
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
