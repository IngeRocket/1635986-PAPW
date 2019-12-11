/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Usuarios;

import com.Connection.conection;
import com.categorias.NumeroPago;
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
@WebServlet(name = "PagarCarrito", urlPatterns = {"/PagarCarrito"})
public class PagarCarrito extends HttpServlet {

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
            out.println("<title>Servlet PagarCarrito</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PagarCarrito at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
          int indiceSeleccion = Integer.parseInt(request.getParameter("ID"));
           request.getSession().setAttribute("IDEspecifico", indiceSeleccion);
           
        RequestDispatcher rd;
        rd = request.getRequestDispatcher("/CarritoEspecifico.jsp");
        rd.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    NumeroPago Metodo = new NumeroPago();
    String FormaPago = request.getParameter("SelectPago");
    int valor = Metodo.GetValor(FormaPago);
    int PosicionEspecifica = (Integer) request.getSession().getAttribute("IDEspecifico");
     HttpSession session = request.getSession(true);
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
            List<String> HISTORIAL_PAGO =           (List<String>)session.getAttribute("HISTORIAL_PAGO");
    
        int CarritoID = Integer.parseInt(HISTORIAL_ID.get(PosicionEspecifica));

        //conexion a base de datos
              try {
    
            conection con = new conection();
            con.getConnection();
         con.PagarElCarrito(CarritoID, valor);
    
        } catch (Exception ex) {
            Logger.getLogger(SubirUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }

        
        
    //borrar de la lista y guardar
        HISTORIAL_ID.remove(PosicionEspecifica);    
        HISTORIAL_ID_Prod.remove(PosicionEspecifica);
        HISTORIAL_Nombre.remove(PosicionEspecifica);
        HISTORIAL_Cantidad.remove(PosicionEspecifica);
        HISTORIAL_Precio.remove(PosicionEspecifica);
        HISTORIAL_Estado.remove(PosicionEspecifica);
        HISTORIAL_FechaPago.remove(PosicionEspecifica);
        HISTORIAL_Foto1.remove(PosicionEspecifica);
        HISTORIAL_Comentado.remove(PosicionEspecifica);
        HISTORIAL_Nick.remove(PosicionEspecifica);
//        HISTORIAL_PAGO.remove(PosicionEspecifica);
        RequestDispatcher rd;
        rd = request.getRequestDispatcher("/carrito.jsp");
        rd.forward(request,response);
    
    
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
