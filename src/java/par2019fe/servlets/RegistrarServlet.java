/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package par2019fe.servlets;

//import Consumir.Resteasy.UserCliente;
import Consumir.Resteasy.UserCliente;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import par2019fe.beans.User;

/**
 *
 * @author Alexis
 */
public class RegistrarServlet extends HttpServlet {

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
        String nombre,apellido,email, passwd,loginName,tp;
        int tipoCliente;
        nombre = request.getParameter("nombre");
        apellido=request.getParameter("apellido");
        email = request.getParameter("email");
        loginName = request.getParameter("loginName");
        passwd=request.getParameter("password");
        tp=request.getParameter("tipoCliente");
        tipoCliente=Integer.parseInt(tp);       
       // User nu = new User(nombre, apellido,  email, loginName,  passwd, tipoCliente);
       
        UserCliente cp=new UserCliente();
        par2019.domain.model.entity.User nu=new par2019.domain.model.entity.User(1,nombre, apellido,  email, loginName,  passwd, tipoCliente);
        par2019.domain.model.entity.User addUser = cp.addUser(nu,par2019.domain.model.entity.User.class);
        cp.close();
        request.getRequestDispatcher("cuentaCreada.jsp").forward(request, response);
        
        
        /*ClienteUsuario cp=new ClienteUsuario();
        cp.addUser(nu,User.class);*/
   
        
        
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
