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
@WebServlet(name = "AgregarACarrito", urlPatterns = {"/AgregarACarrito"})
public class AgregarACarrito extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AgregarACarrito</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AgregarACarrito at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
    int IDParametro =Integer.parseInt(request.getParameter("ID"));
            HttpSession session = request.getSession(true);
  
            List<String> PETI_ID=       (List<String>)session.getAttribute("PETI_ID");
            List<String> PETI_ID_Prod=  (List<String>)session.getAttribute("PETI_ID_Prod");
            List<String> PETI_Nombre=   (List<String>)session.getAttribute("PETI_Nombre");
            List<String> PETI_Cantidad= (List<String>)session.getAttribute("PETI_Cantidad");
            List<String> PETI_SubTotal= (List<String>)session.getAttribute("PETI_SubTotal");
            List<String> PETI_Estado=   (List<String>)session.getAttribute("PETI_Estado");
            List<String> PETI_Fecha=    (List<String>)session.getAttribute("PETI_Fecha");
            List<String> PETI_Foto1=    (List<String>)session.getAttribute("PETI_Foto1");
            //primero es eliminar el elemento de la base de datos
        int IDElemento= Integer.parseInt(PETI_ID.get(IDParametro));
        int IDProducto = Integer.parseInt(PETI_ID_Prod.get(IDParametro));
        int CantidadProductos = Integer.parseInt(PETI_Cantidad.get(IDParametro));
        double precio = Double.parseDouble(PETI_SubTotal.get(IDParametro));
        int MYID = (Integer)session.getAttribute("IdUsuario");
        try {
    
            conection con = new conection();
            con.getConnection();
           con.AgregarCarrito(IDElemento, IDProducto, MYID, CantidadProductos, precio);
        } catch (Exception ex) {
            Logger.getLogger(SubirUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
//conexion a la base de datos 
        

//despues borrar el elemento de cada lista
  
  PETI_ID.remove(IDParametro);
  PETI_ID_Prod.remove(IDParametro);
  PETI_Nombre.remove(IDParametro);
  PETI_Cantidad.remove(IDParametro);
  PETI_SubTotal.remove(IDParametro);
  PETI_Estado.remove(IDParametro);
  PETI_Fecha.remove(IDParametro);
  PETI_Foto1.remove(IDParametro);
  
  //guardar lista en session y regresar a peticiones.jsp
  
request.getSession().setAttribute("PETI_ID",PETI_ID);
request.getSession().setAttribute("PETI_ID_Prod",PETI_ID_Prod);
request.getSession().setAttribute("PETI_Nombre",PETI_Nombre);
request.getSession().setAttribute("PETI_Cantidad",PETI_Cantidad);
request.getSession().setAttribute("PETI_SubTotal",PETI_SubTotal);
request.getSession().setAttribute("PETI_Estado",PETI_Estado);
request.getSession().setAttribute("PETI_Fecha",PETI_Fecha);
request.getSession().setAttribute("PETI_Foto1",PETI_Foto1);    
    
    RequestDispatcher rd;
    rd = request.getRequestDispatcher("/peticiones.jsp");
    rd.forward(request,response);

    
//fin
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
