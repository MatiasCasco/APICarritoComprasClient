/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Consumir.Resteasy;

import com.google.gson.Gson;
import java.util.ArrayList;
import par2019.domain.model.entity.User;

/**
 *
 * @author Alexis
 */
public class pruebaUser {
    
    public static void main(String[] args) {
        
       Gson json = new Gson();
        UserCliente cp=new UserCliente();
        User usuario = null;
        ArrayList value = cp.getUsers(ArrayList.class);
        for(Object pro: value){
            User us = json.fromJson(pro.toString(), User.class);
            if("Matu".equals(us.getLoginName()) && "54321".equals(us.getPasswd())){
                usuario = us;
                System.out.println("Existe");
                System.out.println(usuario.getLoginName());
            }
                 
        }
        if(usuario==null){
            System.out.println("No existe");
        }
        cp.close();
        
        
    }
    
    
    
    
}
