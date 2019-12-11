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
public class NumeroPago {
    private int valor = 0;

public int GetValor(String n){
switch(n){
               
            case "Efectivo":{                                       this.valor=1;     break;}      
            case "Tarjeta Debito":{                                 this.valor=2; 	break;}
            case "Tarjeta Credito":{                                this.valor=3; 	break;}
            case "PayPal":{                                         this.valor=4; 	break;}
            case "OXXO":{                                           this.valor=5; 	break;}
            case "Puntos Infonavit":{                               this.valor=6; 	break;}
            case "Titulo de propiedad":{                            this.valor=7; 	break;}
            case "Mercado Pago":{                                   this.valor=8;     break;}

            }

return valor;
}

}
