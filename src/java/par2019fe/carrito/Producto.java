/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package par2019fe.carrito;

/**
 *
 * @author Mauricio
 */
public class Producto {
    private Integer id;
    private String descripcion;
    private Integer cantidad;
    private Integer precio;
    //private String imagen;
    public Producto() {
//        this.id = 1;
//        this.descripcion = "te";
//        this.cantidad = 3;
//        this.precio = 2;
    }

    public Producto(Integer id, String descripcion, Integer cantidad, Integer precio) {
        this.id = id;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }
}
