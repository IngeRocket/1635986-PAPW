/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.categorias;

/**
 *
 * @author Julio
 */
public class NumeroCategoria {
    private int numeroCategoria;
    public int GetCategoria(String Categoria){
        switch(Categoria){
               
            case "Automotriz":{                     this.numeroCategoria=1;     break;}      
            case "Belleza":{                        this.numeroCategoria=2; 	break;}
            case "Consolas":{                       this.numeroCategoria=3; 	break;}
            case "Electrodomesticos":{              this.numeroCategoria=4; 	break;}
            case "Hardware":{                       this.numeroCategoria=5; 	break;}
            case "HerramientasYFerreteria":{        this.numeroCategoria=6; 	break;}
            case "Jardin":{                         this.numeroCategoria=7; 	break;}
            case "Software":{                       this.numeroCategoria=8;     break;}

            }
    return this.numeroCategoria;
    }
}
