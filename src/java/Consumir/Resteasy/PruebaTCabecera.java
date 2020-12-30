/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Consumir.Resteasy;

import com.google.gson.Gson;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import par2019.domain.model.entity.Transacciones_cab;

/**
 *
 * @author Matias
 */
public class PruebaTCabecera {
    public static void main(String[] args) throws ParseException {
//        Gson json = new Gson();
//        Date fecha = new Date();
//        SeTransaccion cab = new SeTransaccion();
//        Transacciones_cab a;
//        Transacciones_cab tc = new Transacciones_cab(1, fecha, 6, 50000, "Esquina club Olimpia", 1, 12345, "p");        
//        a = cab.addTransacciones_cab(json.toJson(tc), Transacciones_cab.class);
//        System.out.println(a.toString());
//        cab.close();
  
                    Gson json = new Gson();                    
                    SeTransaccion cab = new SeTransaccion();
                    
                    ArrayList value = cab.getTransaccionesCab(ArrayList.class);
                    System.out.println(value.toString());
                
                    for(Object pro: value){
                        //System.out.println(pro.toString());
                     
                        //Transacciones_cab t = json.fromJson(pro.toString(), Transacciones_cab.class);
                       String a = "{id_transaccion=33, fecha=2019-11-30, id_cliente=6, total=1700, direccion_envio=San Miguel, id_medio_pago=3, nro_tarjeta=11111, estado=P}";
                        //System.out.println(t.toString());
                        Transacciones_cab t = json.fromJson(a, Transacciones_cab.class);
                        System.out.println(t.getTotal());
                        //if(17 == t.getId_cliente()){
//                           lista.add(t);
//                            System.out.println(t.toString());
//                       } 
                       
                        
                    }
                    
                    cab.close();
                  
    }
   

}
