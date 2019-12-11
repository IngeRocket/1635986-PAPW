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
@WebServlet(name = "EliminarProducto", urlPatterns = {"/EliminarProducto"})
public class EliminarProducto extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EliminarProducto</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EliminarProducto at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(true);
          int ID = Integer.parseInt(request.getParameter("ID"));
          
   List<String> ADMIN_PROD_ID_Prod=(List<String>)session.getAttribute("ADMIN_PROD_ID_Prod");
   List<String> ADMIN_PROD_Nombre=(List<String>)session.getAttribute("ADMIN_PROD_Nombre");
   List<String> ADMIN_PROD_Stock=(List<String>)session.getAttribute("ADMIN_PROD_Stock");
   List<String> ADMIN_PROD_Precio=(List<String>)session.getAttribute("ADMIN_PROD_Precio");
   List<String> ADMIN_PROD_Borrador=(List<String>)session.getAttribute("ADMIN_PROD_Borrador");
   List<String> ADMIN_PROD_Baja=(List<String>)session.getAttribute("ADMIN_PROD_Baja");
   List<String> ADMIN_PROD_Foto1=(List<String>)session.getAttribute("ADMIN_PROD_Foto1");
   List<String> ADMIN_PROD_Foto2=(List<String>)session.getAttribute("ADMIN_PROD_Foto2");
   List<String> ADMIN_PROD_Foto3=(List<String>)session.getAttribute("ADMIN_PROD_Foto3");
   List<String> ADMIN_PROD_Descripcion=(List<String>)session.getAttribute("ADMIN_PROD_Descripcion");    
   List<String> ADMIN_PROD_Video=(List<String>)session.getAttribute("ADMIN_PROD_Video");
   List<String> ADMIN_PROD_Categoria=(List<String>)session.getAttribute("ADMIN_PROD_Categoria");
   
          int IDReal = Integer.parseInt(ADMIN_PROD_ID_Prod.get(ID));
          
             try {
            conection con = new conection();
            con.getConnection();
            con.Sacrificar(IDReal);
            } catch (Exception ex) {
            Logger.getLogger(SubirUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
   
                    
    ADMIN_PROD_ID_Prod.remove(ID);
    ADMIN_PROD_Nombre.remove(ID);
    ADMIN_PROD_Stock.remove(ID);
    ADMIN_PROD_Precio.remove(ID);
    ADMIN_PROD_Borrador.remove(ID);
    ADMIN_PROD_Baja.remove(ID);
    ADMIN_PROD_Foto1.remove(ID);
    ADMIN_PROD_Foto2.remove(ID);
    ADMIN_PROD_Foto3.remove(ID);
    ADMIN_PROD_Descripcion.remove(ID);  
    ADMIN_PROD_Video.remove(ID);
    ADMIN_PROD_Categoria.remove(ID);
   
          
    String Origen=request.getParameter("Origen");
    switch(Origen){
        case "Borradores":{
                RequestDispatcher rd;
    rd = request.getRequestDispatcher("/AdminBorradores.jsp");
    rd.forward(request,response);
            break;}
        case "Cementerio":{
                RequestDispatcher rd;
    rd = request.getRequestDispatcher("/AdminCementerio.jsp");
    rd.forward(request,response);
            break;}
        case "Vigentes":{
    RequestDispatcher rd;
    rd = request.getRequestDispatcher("/AdminTodoProductos.jsp");
    rd.forward(request,response);            
            break;}
    }


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
