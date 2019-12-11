/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Productos;

import java.io.InputStream;

/**
 *
 * @author Julio
 */
public class ClaseSubida {
    private InputStream foto1;
    private InputStream foto2;
    private InputStream foto3;
    private InputStream video;
    
    public void SetFoto1(InputStream f1){
    this.foto1=f1;
    }
    public void SetFoto2(InputStream f2){
    this.foto2=f2;
    }
    public void SetFoto3(InputStream f3){
    this.foto3=f3;
    }
    public void SetVideo(InputStream V1){
    this.video = V1;
    }
}
