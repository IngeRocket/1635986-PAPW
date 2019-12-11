/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Connection;


import com.Usuarios.FotoUsuario;
import com.Productos.ObtenerProductos;
import java.io.InputStream;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.CallableStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;


/**
 *
 * @author Julio
 */
public class conection {
        private String RegistrarUsuario="{call SP_RegistroUsuario(?,?,?,?,?,?,?)}";
        private String LoginCliente="{call SP_Login(?,?)}";
        private String LoginAdmin="{call SP_LoginAdmin(?,?)}";
        private String P_Nuevos="{call SP_Nuevo()}";
        private String AddStock="{call SP_AddStock(?,?)}";
        private String SubirProducto="{call SP_AddProducto(?,?,?,?,?,?,?,?,?,?)}";
        private String RegistroUsuario="{call SP_RegistroUsuario(?,?,?,?,?,?,?)}";
        private String Categoria="{call SP_VerCategoria(?)}";
        private String NuevaPeticion="{call SP_CreaPeticion(?,?,?)}";
        private String BorrarPeticion="{call SP_CancelarPeticion(?,?,?)}";
        private String ResponderPeticion="{call SP_RespondePeticion(?,?)}";
        private String CancelarRespuesta="{call SP_CancelarRespuesta(?)}";
        private String AgregarACarrito="{call SP_AgregarCarrito(?,?,?,?,?)}";
        private String CancelarCarrito="{call SP_EliminarCarrito(?,?,?)}";
        private String PagarCarrito="{call SP_PagarCarrito(?,?)}";
        private String VerMiPeticion="{call SP_MisPeticiones(?)}";
        private String SolicitudesAdmin="{call SP_CargarPeticiones()}";
        private String CargarRespuestas="{call SP_VerRespuestas()}";
        private String Carrito="{call SP_MiCarrito(?)}";
        private String Historial="{call SP_Historial(?)}";
        private String Historial2="{call SP_Historial2(?)}";
        private String Comentar="{call SP_ComentarProducto(?,?,?,?,?)}";
        private String Comentarios ="{call SP_ComentariosDeProducto(?)}";
        private String Existente="{call SP_Vigentes()}";
        private String Borrador="{call SP_Borradores()}";
        private String Eliminado="{call SP_Eliminados()}";
        private String Revivir="{call SP_Revivir(?)}"; 
        private String BajaLogica="{call SP_BajaLogica(?)}";
        private String EditProd="{call SP_EditarProducto(?,?,?,?,?,?,?,?,?,?)}";
        private String Publicar="{call SP_Publicar(?)}";
        private String Popular="{call SP_Popular()}";  
        private String ComentarioEspecifico="{call SP_(?,?)}";
        private Connection con = null;
        
        public Connection getConnection(){
    String cone = "jdbc:mysql://localhost/papw?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    String usuario = "root";
    String pass="root";
    try{
Class.forName("com.mysql.cj.jdbc.Driver");
con = DriverManager.getConnection(cone, usuario, pass);
return con;
}catch(Exception ex){
con = null;
}
 
return con;
}
    public Boolean Login(String nombre, String pass, int opcion, FotoUsuario Imagen) throws SQLException{
    //getConnection();
        Boolean respuesta = false;
        if(opcion==0){
    
            PreparedStatement llamada = null;
            llamada = con.prepareCall(this.LoginCliente);
    
               
                llamada.setString(1, nombre);
                llamada.setString(2, pass);
                
                ResultSet rs = null;
                rs=llamada.executeQuery();
                
                String nuevo = "vacio";
                while (rs.next()){
                
                 Imagen.setIdUsuario(rs.getInt(1));
                 Imagen.setNick(rs.getString(2));
                 Imagen.SetMiFoto(rs.getBinaryStream(3));
                 Imagen.SetMiFoto2(rs.getBytes(3));
                }
            nuevo = Imagen.getNick();
            if(nuevo.compareTo("vacio")== 0)
            respuesta = false;
            else
            respuesta = true;

    llamada.close();
    rs.close();
    
        
        }else{
    //si es 1 es login admin

            PreparedStatement llamada = null;
            llamada = con.prepareCall(this.LoginAdmin);
    
               
                llamada.setString(1, nombre);
                llamada.setString(2, pass);
                
                ResultSet rs = null;
                rs=llamada.executeQuery();
                
                String nuevo = "vacio";
                while (rs.next()){
                 nuevo = rs.getString("admin_nickname").toString();
                }

            if(nuevo.compareTo("vacio")== 0)
            respuesta = false;
            else
            respuesta = true;

    llamada.close();
    rs.close();
    
      }
            //CerrarConexion();
        
        con.close();
        return respuesta;
    
    }
    public void NuevoProducto(String nombre, double precio, int borrador, String descripcion, String video, String I1, String I2,String I3, int stock, int categoria ) throws SQLException{
   PreparedStatement comando = null;
            comando = con.prepareCall(this.SubirProducto);
                comando.setString(1, nombre);
                comando.setDouble(2, precio);
                comando.setInt(3, borrador);
                comando.setString(4, descripcion);
                comando.setString(5, video);
                comando.setString(6, I1);
                comando.setString(7, I2);
                comando.setString(8, I3);
                comando.setInt(9,stock);
                comando.setInt(10,categoria);
                
                ResultSet rs = null;
                rs=comando.executeQuery();
                
        con.close();
        
    }
    
    public void AdminEditarStock(int IDProducto, int cantidad) throws SQLException{
    PreparedStatement comando = null;
                comando = con.prepareCall(this.AddStock);
                comando.setInt(1, IDProducto);
                comando.setInt(2, cantidad);
                ResultSet rs = null;
                rs=comando.executeQuery();
        con.close(); 
    
    }
    public void AdminBajaLogica(int IDProducto) throws SQLException{
    PreparedStatement comando = null;
                comando = con.prepareCall(this.BajaLogica);
                comando.setInt(1, IDProducto);
                ResultSet rs = null;
                rs=comando.executeQuery();
        con.close(); 
    
    }
    
    public void VerCategoria(int numero, List<String>ID,List<String>Nombre,List<String>Descripcion,List<String>Precio,List<String>Stock,List<String>Foto1,List<String>Foto2,List<String>Foto3,List<String>Video,List<String>Baja) throws SQLException{

                PreparedStatement comando = null;
                comando = con.prepareCall(this.Categoria);
                comando.setInt(1, numero);
                ResultSet rs = null;
                rs=comando.executeQuery();
                
                while(rs.next()){
                   
                               
                ID.add(rs.getString(1));
                Nombre.add(rs.getString(2));
                Descripcion.add(rs.getString(3));
                Precio.add(rs.getString(4));
                Stock.add(rs.getString(5));
                Foto1.add(rs.getString(6));
                Foto2.add(rs.getString(7));
                Foto3.add(rs.getString(8));
                Video.add(rs.getString(9));
                Baja.add(rs.getString(10));
                
                }
            


    con.close();
//    return nueva;
    }
    public void VerNuevo(List<String>ID,List<String>Nombre,List<String>Descripcion,List<String>Precio,List<String>Stock,List<String>Foto1,List<String>Foto2,List<String>Foto3,List<String>Video,List<String>Baja) throws SQLException{

                PreparedStatement comando = null;
                comando = con.prepareCall(this.P_Nuevos);
             
                ResultSet rs = null;
                rs=comando.executeQuery();
                
                while(rs.next()){
                   
                               
                ID.add(rs.getString(1));
                Nombre.add(rs.getString(2));
                Descripcion.add(rs.getString(3));
                Precio.add(rs.getString(4));
                Stock.add(rs.getString(5));
                Foto1.add(rs.getString(6));
                Foto2.add(rs.getString(7));
                Foto3.add(rs.getString(8));
                Video.add(rs.getString(9));
                Baja.add(rs.getString(10));
                
                }
            


    rs.close();
    comando.close();
    con.close();
//    return nueva;
    }

    public void CrearPeticion(int persona, int producto ,int cantidad) throws SQLException{
                PreparedStatement comando = null;
                comando = con.prepareCall(this.NuevaPeticion);
                comando.setInt(1, persona);
                comando.setInt(2, producto);
                comando.setInt(3, cantidad);
                ResultSet rs = null;
                rs=comando.executeQuery();
                
        con.close();        
        
    }
    public void CancelarPeticion(int peticion, int producto, int cantidad) throws SQLException{
    PreparedStatement comando = null;
                comando = con.prepareCall(this.BorrarPeticion);
                comando.setInt(1, peticion);
                comando.setInt(2, producto);
                comando.setInt(3, cantidad);
                ResultSet rs = null;
                rs=comando.executeQuery();
                
        con.close();        
        
    }
    public void AgregarCarrito(int IDPeticion, int IDProducto, int Persona, int Cantidad, double precio) throws SQLException{
    PreparedStatement comando = null;
                comando = con.prepareCall(this.AgregarACarrito);
                comando.setInt(1, IDPeticion);
                comando.setInt(2, IDProducto);
                comando.setInt(3, Persona);
                comando.setInt(4, Cantidad);
                comando.setDouble(5, precio);
              
                
                ResultSet rs = null;
                rs=comando.executeQuery();
                
        con.close();        
        
    }
    public void PagarElCarrito(int ID,int FormaPago) throws SQLException{
    PreparedStatement comando = null;
                comando = con.prepareCall(this.PagarCarrito);
                comando.setInt(1, ID);
                comando.setInt(2, FormaPago);
                      
                ResultSet rs = null;
                rs=comando.executeQuery();
                
        con.close();        
    
    }
    public void EliminarDeCarrito(int ID, int producto, int cantidad) throws SQLException{
       PreparedStatement comando = null;
                comando = con.prepareCall(this.CancelarCarrito);
                comando.setInt(1, ID);
                comando.setInt(2, producto);
                comando.setInt(3, cantidad);
               
                      
                ResultSet rs = null;
                rs=comando.executeQuery();
                
        con.close();   
    }

    public void AdminResponderPeticion(int idPeticion, double precio) throws SQLException{
     PreparedStatement comando = null;
                comando = con.prepareCall(this.ResponderPeticion);
                comando.setInt(1, idPeticion);
                comando.setDouble(2, precio);                      
                ResultSet rs = null;
                rs=comando.executeQuery();
                
        con.close();   
    }
    public void AdminCancelarRespuesta(int idPeticion) throws SQLException{
        PreparedStatement comando = null;
                comando = con.prepareCall(this.CancelarRespuesta);
                comando.setInt(1, idPeticion);
                ResultSet rs = null;
                rs=comando.executeQuery();
        con.close(); 
    }
    public void AdminCargarPeticiones(List<String>ID, List<String>ID_Prod,List<String>Nombre,List<String>Cantidad,List<String>Sugerido,List<String>Estado,List<String>Fecha,List<String>Foto,List<String>Nick) throws SQLException{
        PreparedStatement comando = null;
                comando = con.prepareCall(this.SolicitudesAdmin);
              
                ResultSet rs = null;
                
                rs=comando.executeQuery();
                    while(rs.next()){
                ID.add(rs.getString(1));
                ID_Prod.add(rs.getString(2));
                Nombre.add(rs.getString(3));
                Cantidad.add(rs.getString(4));
                Sugerido.add(rs.getString(5));
                Estado.add(rs.getString(6));
                Fecha.add(rs.getString(7));
                Foto.add(rs.getString(8));
                Nick.add(rs.getString(9));
                    }
                comando.close();
                rs.close();
                con.close(); 
       
    }
    
    public void MisPeticiones(int IDUsuario, List<String>ID,List<String>ID_Prod,List<String>Nombre,List<String>Cantidad,List<String>SubTotal,List<String>Estado,List<String>Fecha,List<String>Foto1) throws SQLException{
     PreparedStatement comando = null;
                comando = con.prepareCall(this.VerMiPeticion);
                comando.setInt(1, IDUsuario);
                ResultSet rs = null;
                
                rs=comando.executeQuery();
                    while(rs.next()){
                ID.add(rs.getString(1));
                ID_Prod.add(rs.getString(2));
                Nombre.add(rs.getString(3));
                Cantidad.add(rs.getString(4));
                SubTotal.add(rs.getString(5));
                Estado.add(rs.getString(6));
                Fecha.add(rs.getString(7));
                Foto1.add(rs.getString(8));
                    }
                comando.close();
                rs.close();
                con.close(); 
    }
    public void MiCarrito(int MIID, List<String>ID, List<String>ID_Prod, List<String>Cantidad, List<String>Total, List<String>Estado, List<String>FechaPago, List<String>TipoPago, List<String>Nick, List<String>Foto1, List<String>Comentado,List<String>Nombre,List<String>FormaPago) throws SQLException{
    PreparedStatement comando = null;
                comando = con.prepareCall(this.Carrito);
                comando.setInt(1,MIID);
                ResultSet rs = null;
                rs=comando.executeQuery();
                while(rs.next()){
                ID.add(rs.getString(1));
                ID_Prod.add(rs.getString(2));
                Nombre.add(rs.getString(3));
                Cantidad.add(rs.getString(4));
                Total.add(rs.getString(5));
                Estado.add(rs.getString(6));
                FechaPago.add(rs.getString(7));
                TipoPago.add(rs.getString(8));
                Nick.add(rs.getString(9));
                Foto1.add(rs.getString(10));
                Comentado.add(rs.getString(11));
                FormaPago.add(rs.getString(12));
                }
                
                rs.close();
                comando.close();
                con.close();
                
    }
    public void NuevoUsuario(String nombre, String AP, String AM, String Correo, String pass,InputStream Foto,String Nick) throws SQLException{
        PreparedStatement comando = null;
                comando = con.prepareCall(this.RegistrarUsuario);
                comando.setString(1,nombre);
                comando.setString(2,AP);
                comando.setString(3,AM);
                comando.setBlob(4,Foto);
                comando.setString(5,Nick);
                comando.setString(6,Correo);
                comando.setString(7,pass);
                ResultSet rs = null;
                rs=comando.executeQuery();
                rs.close();
                comando.close();
        con.close(); 
    }

    public void AdminCargarRespuestas(List<String>ID,List<String>ID_Prod,List<String>Nombre,List<String>Cantidad,List<String>SubTotal,List<String>Estado,List<String>Fecha,List<String>Foto,List<String>Nick) throws SQLException{
 PreparedStatement comando = null;
                comando = con.prepareCall(this.CargarRespuestas);            
                ResultSet rs = null;
                rs=comando.executeQuery();
                
                    while(rs.next()){
                ID.add(rs.getString(1));
                ID_Prod.add(rs.getString(2));
                Nombre.add(rs.getString(3));
                Cantidad.add(rs.getString(4));
                SubTotal.add(rs.getString(5));
                Estado.add(rs.getString(6));
                Fecha.add(rs.getString(7));
                Foto.add(rs.getString(8));
                Nick.add(rs.getString(9));
                    }
                comando.close();
                rs.close();
                con.close(); 
   
    }
    
    public void MiHistorial(int MIID, List<String>ID, List<String>ID_Prod, List<String>Cantidad, List<String>Total, List<String>Estado, List<String>FechaPago, List<String>TipoPago, List<String>Nick, List<String>Foto1, List<String>Comentado,List<String>Nombre) throws SQLException{
    PreparedStatement comando = null;
                comando = con.prepareCall(this.Historial);
                comando.setInt(1,MIID);
                ResultSet rs = null;
                rs=comando.executeQuery();
                while(rs.next()){
                ID.add(rs.getString(1));
                ID_Prod.add(rs.getString(2));
                Nombre.add(rs.getString(3));
                Cantidad.add(rs.getString(4));
                Total.add(rs.getString(5));
                Estado.add(rs.getString(6));
                FechaPago.add(rs.getString(7));
                TipoPago.add(rs.getString(8));
                Nick.add(rs.getString(9));
                Foto1.add(rs.getString(10));
                Comentado.add(rs.getString(11));
                }
                
                rs.close();
                comando.close();
                con.close();
                
    }
    
    public void SubirComentario(int Carrito, int usuario, String Comentario, int voto, int producto) throws SQLException{
    PreparedStatement comando = null;
                comando = con.prepareCall(this.Comentar);
                comando.setInt(1,Carrito);
                comando.setInt(2,usuario);
                comando.setString(3,Comentario);
                comando.setInt(4,voto);
                comando.setInt(5,producto);
                
                ResultSet rs = null;
                rs=comando.executeQuery();
        
                rs.close();
                comando.close();
                con.close();
    }

    public void ComentariosDeProducto(int prod,List<String>Usuario,List<String>Comentario,List<String>Fecha,List<String>valor, List<String>  Suma, List<String> Cuenta) throws SQLException{
    PreparedStatement comando = null;
                comando = con.prepareCall(this.Comentarios);
                comando.setInt(1,prod);
                
                ResultSet rs = null;
                rs=comando.executeQuery();
                
                while(rs.next()){
                    
                    Comentario.add(rs.getString(1));
                    valor.add(rs.getString(2));
                    Fecha.add(rs.getString(3));
                    Usuario.add(rs.getString(4));
                    Suma.set(0, rs.getString(5));
                    Cuenta.set(0, rs.getString(6));
                }
                rs.close();
                comando.close();
                con.close();
    }

    public void CargaExistentes( List<String>ID_Prod, List<String>Nombre, List<String>Stock, List<String>Precio, List<String>Borrador, List<String>Baja, List<String>Foto1, List<String>Foto2, List<String>Foto3, List<String>Video, List<String>Descripcion, List<String>Categoria) throws SQLException{
            PreparedStatement comando = null;
                comando = con.prepareCall(this.Existente);
                
                ResultSet rs = null;
                rs=comando.executeQuery();
                while(rs.next()){
                ID_Prod.add(rs.getString(1));
                Nombre.add(rs.getString(2));
                Precio.add(rs.getString(3));
                Baja.add(rs.getString(4));
                Borrador.add(rs.getString(5));
                Descripcion.add(rs.getString(6));
                Video.add(rs.getString(7));
                Stock.add(rs.getString(8));
                Foto1.add(rs.getString(9));
                Foto2.add(rs.getString(10));
                Foto3.add(rs.getString(11));
                Categoria.add(rs.getString(12));
          
                }
                rs.close();
                comando.close();
                con.close();
               
    }
    public void CargaBorradores(List<String>ID_Prod, List<String>Nombre, List<String>Stock, List<String>Precio, List<String>Borrador, List<String>Baja, List<String>Foto1, List<String>Foto2, List<String>Foto3, List<String>Video, List<String>Descripcion, List<String>Categoria) throws SQLException{
    PreparedStatement comando = null;
                comando = con.prepareCall(this.Borrador);
                
                ResultSet rs = null;
                rs=comando.executeQuery();
                while(rs.next()){
                
                ID_Prod.add(rs.getString(1));
                Nombre.add(rs.getString(2));
                Precio.add(rs.getString(3));
                Baja.add(rs.getString(4));
                Borrador.add(rs.getString(5));
                Descripcion.add(rs.getString(6));
                Video.add(rs.getString(7));
                Stock.add(rs.getString(8));
                Foto1.add(rs.getString(9));
                Foto2.add(rs.getString(10));
                Foto3.add(rs.getString(11));
                Categoria.add(rs.getString(12));
          
                }
                rs.close();
                comando.close();
                con.close();
   
    }
    public void CargaEliminados(List<String>ID_Prod, List<String>Nombre, List<String>Stock, List<String>Precio, List<String>Borrador, List<String>Baja, List<String>Foto1, List<String>Foto2, List<String>Foto3, List<String>Video, List<String>Descripcion, List<String>Categoria) throws SQLException{
    PreparedStatement comando = null;
                comando = con.prepareCall(this.Eliminado);
                
                ResultSet rs = null;
                rs=comando.executeQuery();
                while(rs.next()){
                
                ID_Prod.add(rs.getString(1));
                Nombre.add(rs.getString(2));
                Precio.add(rs.getString(3));
                Baja.add(rs.getString(4));
                Borrador.add(rs.getString(5));
                Descripcion.add(rs.getString(6));
                Video.add(rs.getString(7));
                Stock.add(rs.getString(8));
                Foto1.add(rs.getString(9));
                Foto2.add(rs.getString(10));
                Foto3.add(rs.getString(11));
                Categoria.add(rs.getString(12));
          
                }
                rs.close();
                comando.close();
                con.close();
   
    }
    
    public void RevivirProducto(int id_prod) throws SQLException{
    PreparedStatement comando = null;
                comando = con.prepareCall(this.Revivir);
                comando.setInt(1,id_prod);
                ResultSet rs = null;
                rs=comando.executeQuery();
   
                rs.close();
                comando.close();
                con.close();
   
   
    }
    public void Sacrificar(int id_prod) throws SQLException{
     PreparedStatement comando = null;
                comando = con.prepareCall(this.BajaLogica);
                comando.setInt(1,id_prod);
                ResultSet rs = null;
                rs=comando.executeQuery();
   
                rs.close();
                comando.close();
                con.close();
   
   
    }
    public void Publicacion(int id_prod)throws SQLException{
    PreparedStatement comando = null;
                comando = con.prepareCall(this.Publicar);
                comando.setInt(1,id_prod);
                ResultSet rs = null;
                rs=comando.executeQuery();
   
                rs.close();
                comando.close();
                con.close();
    }

    public void CambiarDatos(int id_prod,String Nombre, String Descripcion, double Precio, int Stock, String V, String F1, String F2, String F3, int Categoria) throws SQLException{
                PreparedStatement comando = null;
                comando = con.prepareCall(this.EditProd);
                comando.setInt(1,id_prod);
                comando.setString(2,Nombre);
                comando.setDouble(3,Precio);
                comando.setString(4,Descripcion);
                comando.setString(5,V);
                comando.setInt(6,Stock);
                comando.setString(7,F1);
                comando.setString(8,F2);
                comando.setString(9,F3);
                comando.setInt(10,Categoria);
                                        
                ResultSet rs = null;
                rs=comando.executeQuery();
   
                rs.close();
                comando.close();
                con.close();
    }
   
    public void MiComentarioEspecifico(int numeroCompra){
    }
    public void ProductosPopulares(List<String>ID,List<String>Nombre,List<String>Descripcion,List<String>Precio,List<String>Stock,List<String>Foto1,List<String>Foto2,List<String>Foto3,List<String>Video,List<String>Baja) throws SQLException{
    PreparedStatement comando = null;
                comando = con.prepareCall(this.Popular);
             
                ResultSet rs = null;
                rs=comando.executeQuery();
                String nomas;
                while(rs.next()){
                                                
                ID.add(rs.getString(1));
                Nombre.add(rs.getString(2));
                Descripcion.add(rs.getString(3));
                Precio.add(rs.getString(4));
                Stock.add(rs.getString(5));
                Foto1.add(rs.getString(6));
                Foto2.add(rs.getString(7));
                Foto3.add(rs.getString(8));
                Video.add(rs.getString(9));
                Baja.add(rs.getString(10));
                nomas=(rs.getString(11));
                }
            
rs.close();
comando.close();
    con.close();

        }

   public void MiHistoriall(int MIID, List<String>ID, List<String>ID_Prod, List<String>Cantidad, List<String>Total, List<String>Estado, List<String>FechaPago, List<String>TipoPago, List<String>Nick, List<String>Foto1, List<String>Comentado,List<String>Nombre, List<String>FormaPago) throws SQLException{
    PreparedStatement comando = null;
                comando = con.prepareCall(this.Historial2);
                comando.setInt(1,MIID);
                ResultSet rs = null;
                rs=comando.executeQuery();
                while(rs.next()){
                ID.add(rs.getString(1));
                ID_Prod.add(rs.getString(2));
                Nombre.add(rs.getString(3));
                Cantidad.add(rs.getString(4));
                Total.add(rs.getString(5));
                Estado.add(rs.getString(6));
                FechaPago.add(rs.getString(7));
                TipoPago.add(rs.getString(8));
                Nick.add(rs.getString(9));
                Foto1.add(rs.getString(10));
                Comentado.add(rs.getString(11));
                FormaPago.add(rs.getString(12));
                }
                
                rs.close();
                comando.close();
                con.close();
                
    }
    
}
