/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Consumir.Resteasy;

import com.google.gson.Gson;
import java.util.ArrayList;
import par2019.domain.model.entity.Transacciones_det;

/**
 *
 * @author Matias
 */
public class PruebaTDetalle {
    public static void main(String[] args) {
        Gson json = new Gson();
        ArrayList<Transacciones_det> list = new ArrayList();
        SeTransaccionD det = new SeTransaccionD();
        Transacciones_det d = new Transacciones_det(16,3, 3,4,2000,8000); 
         Transacciones_det de = new Transacciones_det(16,4, 5,6,4000,5000);
         list.add(de);
         list.add(d);
         
        Transacciones_det detalle;
        for (Transacciones_det e: list){
            detalle = det.addTDet(json.toJson(e), Transacciones_det.class);
            System.out.println(detalle.toString());
        }
        
        
        det.close();
    }
}
