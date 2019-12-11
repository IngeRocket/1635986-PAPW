/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Productos;

/**
 *Son los produtos de una categotia en especifico
 * @author Julio
 */
public class ObtenerProductos {
    int ID;
    String foto1;
    String foto2;
    String foto3;
    String nombre;
    String Descripcion;
    String Video;
    int baja;
    int Stock;
    double costo;

    public int getID() {
        return ID;
    }

    public String getFoto1() {
        return foto1;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public double getCosto() {
        return costo;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setFoto1(String foto) {
        this.foto1 = foto;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public String getFoto2() {
        return foto2;
    }

    public void setFoto2(String foto2) {
        this.foto2 = foto2;
    }

    public String getFoto3() {
        return foto3;
    }

    public void setFoto3(String foto3) {
        this.foto3 = foto3;
    }

    public int getStock() {
        return Stock;
    }

    public void setStock(int Stock) {
        this.Stock = Stock;
    }

    public String getVideo() {
        return Video;
    }

    public void setVideo(String Video) {
        this.Video = Video;
    }

    public int getBaja() {
        return baja;
    }

    public void setBaja(int baja) {
        this.baja = baja;
    }

    public String YO(){
    return nombre+foto1;
    }
}
