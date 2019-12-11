/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Usuarios;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
/**
 *
 * @author Julio
 */
public class FotoUsuario {
    private int IdUsuario;
    private InputStream MiFoto;
    private String Nick;
    private int cantidad=0;
    byte[]imagen;
public void SetMiFoto(InputStream m){
    this.MiFoto = m;
    }
    public void SetMiFoto2(byte[] m){
    this.imagen = m;
    }

public InputStream GetMiFoto(){
    return MiFoto;
    }

    public int getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(int IdUsuario) {
        this.IdUsuario = IdUsuario;
    }

    public String getNick() {
        return Nick;
    }

    public void setNick(String Nick) {
        this.Nick = Nick;
    }

public void PreparameFoto(HttpServletResponse response) throws IOException{
   
      
InputStream entrada = MiFoto;
OutputStream salida = null; 
BufferedInputStream bufferEntrada = null;
BufferedOutputStream bufferSalida = null;
response.setContentType("/image*");
response.getOutputStream().write(imagen);

/*
bufferEntrada = new BufferedInputStream(entrada);
bufferSalida = new BufferedOutputStream(salida);
int i = 0;
    while ((i = bufferEntrada.read()) != -1 ){
    bufferSalida.write(i);
        }
 
*/

}

}
