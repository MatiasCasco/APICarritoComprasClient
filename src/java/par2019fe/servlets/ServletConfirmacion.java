/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package par2019fe.servlets;

import Consumir.Resteasy.SeTransaccion;
import Consumir.Resteasy.SeTransaccionD;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import par2019.domain.model.entity.Transacciones_cab;
import par2019.domain.model.entity.Transacciones_det;
import par2019.domain.model.entity.User;
import par2019fe.carrito.Carrito;
import par2019fe.carrito.Producto;

/**
 *
 * @author Matias
 */
public class ServletConfirmacion extends HttpServlet {

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
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet ServletConfirmacion</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet ServletConfirmacion at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }
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
       if(accion.equals("Confirmar")) {
            this.Autenticacion(request, response);
        }
       if(accion.equals("Cabecera")){
           this.Insertar(request, response);
       }
    }
    
    private void Autenticacion(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        request.getRequestDispatcher("Cabecera.jsp").forward(request, response);
    }
    
    private void Insertar(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        Gson json = new Gson();
        HttpSession session = request.getSession();
        User usu = (User) session.getAttribute("usuario");
        
        Date fecha = new Date();
        SeTransaccion cab = new SeTransaccion();
        Transacciones_cab a;
        Transacciones_cab tc = null;
        Integer Monto = this.MontoTotal(request, response);
        try {
            tc = new Transacciones_cab(1, fecha, usu.getId(), Monto, request.getParameter("Ubicacion"), Integer.valueOf(request.getParameter("MedioPago")), Integer.valueOf(request.getParameter("NroTarjeta")), "P");
        } catch (ParseException ex) {
            Logger.getLogger(ServletConfirmacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        a = cab.addTransacciones_cab(json.toJson(tc), Transacciones_cab.class);
       this.InsertarD(request, response);
        
        cab.close();
        
    }

    private Integer MontoTotal(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        Integer Calculo= 0;
        Carrito c = (Carrito) request.getSession().getAttribute("carrito");
        ArrayList<Producto> carrito = new ArrayList();
        try{ 
         carrito = c.getItems();
        }catch(Exception e){
        }
        for(Producto p: carrito){
            Calculo = Calculo + (p.getPrecio()*p.getCantidad());
        }
        return Calculo;
    }
    
    private void InsertarD(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        
        Gson json = new Gson();
        SeTransaccionD det = new SeTransaccionD();
        
        Carrito c = (Carrito) request.getSession().getAttribute("carrito");
        ArrayList<Producto> carrito = new ArrayList();
        
        try{ 
         carrito = c.getItems();
        }catch(Exception e){
        }
        Transacciones_det detalle = new Transacciones_det();
        Transacciones_det d = new Transacciones_det();
       
        for(Producto p: carrito){  
             d = new Transacciones_det(1, 1, p.getId(), p.getCantidad(), p.getPrecio(), (p.getCantidad()*p.getPrecio()));        
             detalle = det.addTDet(json.toJson(d), Transacciones_det.class); 
        } 
                
        c = new Carrito();
        request.getSession().setAttribute("carrito", c);
        det.close();
        request.getRequestDispatcher("MenuServlet").forward(request, response);
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
