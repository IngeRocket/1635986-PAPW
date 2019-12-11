/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.Productos;

import com.Connection.conection;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author Julio
 */
@WebServlet(name = "SubirProducto", urlPatterns = {"/SubirProducto"})
public class SubirProducto extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SubirProducto</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SubirProducto at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      //  processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            //    processRequest(request, response);
            String Raiz="productos/";
            String NombreProducto = request.getParameter("NombreProducto");
            String Descripcion= request.getParameter("DescripcionProducto");
            String Categoria= request.getParameter("SelectCategoria");
            String OpcionSubida=request.getParameter("OpcionProducto");
            String Precio= request.getParameter("PrecioProducto");
            String Stock= request.getParameter("StockProducto");
            
            String Video= request.getParameter("VideoProducto");
            String Foto1= request.getParameter("Foto1Producto");
            String Foto2= request.getParameter("Foto2Producto");
            String Foto3= request.getParameter("Foto3Producto");
            Foto1= Raiz + Foto1;
            Foto2= Raiz + Foto2;
            Foto3= Raiz + Foto3;
            Video= Raiz + Video;
            int numeroCategoria = 0;
            switch(Categoria){
               
case "Automotriz":{                     numeroCategoria=1;	break;}      
case "Belleza":{                        numeroCategoria=2; 	break;}
case "Consolas":{                       numeroCategoria=3; 	break;}
case "Electrodomesticos":{              numeroCategoria=4; 	break;}
case "Hardware":{                       numeroCategoria=5; 	break;}
case "HerramientasYFerreteria":{	numeroCategoria=6; 	break;}
case "Jardin":{                         numeroCategoria=7; 	break;}
case "Software":{                       numeroCategoria=8;      break;}
            
            
            }
            int Opc = 0;
            double Costo = 0.00;
            int CantidadStock = 0;
            if(OpcionSubida.compareTo("Agregar a Borrador")==0)
                Opc = 1;
            
            Costo = Double.parseDouble(Precio);
            CantidadStock=Integer.parseInt(Stock);
            
           
        try {
            conection comando = new conection();
            comando.getConnection();
            comando.NuevoProducto(NombreProducto,Costo,Opc,Descripcion,Video,Foto1,Foto2,Foto3,CantidadStock,numeroCategoria);
            
           
        } catch (SQLException ex) {
            Logger.getLogger(SubirProducto.class.getName()).log(Level.SEVERE, null, ex);
        }
         
            
            RequestDispatcher rd;
            rd = request.getRequestDispatcher("/AgregarProducto.jsp");
            rd.forward(request,response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
