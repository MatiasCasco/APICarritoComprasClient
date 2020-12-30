/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Consumir.Resteasy;

import com.google.gson.Gson;
import java.util.ArrayList;
import par2019.domain.model.entity.Product;

/**
 *
 * @author Matias
 */
public class SProduct {
    public static void main(String[] args) {
        Gson json = new Gson();
        SeProduct prod = new SeProduct();
        Product p = prod.getProduct(Product.class, "1");
      //  ArrayList value = prod.getProducts(ArrayList.class);
       // ArrayList value = prod.getProductc(ArrayList.class, "c");
       ArrayList value = prod.getProductXC(ArrayList.class, "sp", "2"); 
       for(Object pro: value){
            //System.out.println(pro.toString());
            //Product product = (Product) pro;
            Product product = json.fromJson(pro.toString(), Product.class);
            System.out.println(pro.toString());
            System.out.println(product.getNombre());
           // System.out.println(produ.toString());
        }
        
        
        //System.out.println(p.toString());
      
        System.out.println(value);
        prod.close();
    }
    
}
