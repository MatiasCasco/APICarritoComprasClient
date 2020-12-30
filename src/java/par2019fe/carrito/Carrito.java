/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package par2019fe.carrito;

import java.util.ArrayList;

/**
 *
 * @author Mauricio
 */
public class Carrito {
    
    private ArrayList<Producto> items = new ArrayList<>();

    public ArrayList<Producto> getItems() {
        return items;
    }
    
    public void addItem(Producto p) {
        items.add(p);
    }

    public void setItems(ArrayList<Producto> items) {
        this.items = items;
    }
    
    
}
