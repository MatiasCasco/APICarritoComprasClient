/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package par2019fe.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import par2019fe.carrito.Carrito;
import par2019fe.carrito.Producto;
/**
 *
 * @author Matias
 */
public class ServletCarrito extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        String accion = request.getParameter("accion");
        if(accion =="" || accion == null ) {
            this.defau(request, response);
        }
        if(accion.equals("Buscar")) {
            this.buscar(request, response);
        }
          
            
       
    }

    private void defau(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
        Carrito c = (Carrito) request.getSession().getAttribute("carrito");
        
        if (c != null) {
            request.getRequestDispatcher("Carrito.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("CarritoVacio.jsp").forward(request, response);
        }
    }
    
       private void buscar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
           request.getRequestDispatcher("Busquedad.jsp").forward(request, response);
       }
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        String accion = request.getParameter("accion");
        if(accion.equals("AgregarCarrito")) {
           this.agregar(request, response);
         }
        if(accion.equals("Borrar")){
            this.borrar(request, response);
        }
        //} else {
          //  request.getRequestDispatcher("añadirCarrito.jsp").forward(request, response);
        //}
      // request.getSession().invalidate(); // aparte para invalidar la session
      
    }
   
    private void agregar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        
            Integer id = Integer.valueOf(request.getParameter("idProd"));
            String descripcion = request.getParameter("descripcion");
            Integer cantidad = Integer.valueOf(request.getParameter("cantidad"));
            Integer precio = Integer.valueOf(request.getParameter("precio"));

            Producto p = new Producto(id, descripcion, cantidad, precio);//cargar constructor
            Carrito c = (Carrito) request.getSession().getAttribute("carrito");
            int bandera = 0;
//            if (cantidad > 0) {
                if(c != null){ 
                    ArrayList<Producto> carrito = c.getItems();
                    for(Producto p1: carrito){
                        if(p1.getId() == id){
                            p1.setCantidad(p1.getCantidad()+cantidad);
                            bandera = 1;
                        }
                    }
                    if(bandera == 0){
                        c.addItem(p);
                    }
                } else {
                    c = new Carrito();
                    c.addItem(p);
                    request.getSession().setAttribute("carrito", c);
                }
                request.getRequestDispatcher("Menu Principal.jsp").forward(request, response);
//            }else{
//                //request.getSession().setAttribute("param", "5");
//                request.getRequestDispatcher("añadirCarrito.jsp").forward(request, response);
//
//            }     
    }
    //Prueba
     private void borrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
          response.setContentType("text/html; charset=UTF-8");
        
        Integer id = Integer.valueOf(request.getParameter("idProd"));
        Carrito c = (Carrito) request.getSession().getAttribute("carrito");
        
        
        ArrayList<Producto> carrito = c.getItems();
        if(c != null) {
            for(Producto p: carrito) {
                 if(p.getId() == id){             
                     carrito.remove(p);
                     request.getRequestDispatcher("Carrito.jsp").forward(request, response);                  
                 } 
            }
       }else {
              request.getRequestDispatcher("CarritoVacio.jsp").forward(request, response);   
       } 
     }
     
    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            response.setContentType("text/html; charset=UTF-8");
        
        Integer id = Integer.valueOf(request.getParameter("idProd"));
        Carrito c = (Carrito) request.getSession().getAttribute("carrito");
        
        
        ArrayList<Producto> carrito = c.getItems();
        if(c!=null) {
            for(Producto p: carrito) {
                 if(p.getId() == id){             
                     carrito.remove(p);
                     break;                    
                 } 
            }
       } //else{
//            request.getRequestDispatcher("CarritoVacio.jsp").forward(request, response);         
//        }
      
    }
     
      
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
