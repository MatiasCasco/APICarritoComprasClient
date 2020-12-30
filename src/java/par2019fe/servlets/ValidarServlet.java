/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package par2019fe.servlets;

import Consumir.Resteasy.UserCliente;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//import par2019fe.beans.User;
import par2019.domain.model.entity.*;
/**
 *
 * @author Matias
 */
public class ValidarServlet extends HttpServlet {

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
         String nombre, pass;
        nombre = request.getParameter("txtNombre");
        pass = request.getParameter("txtPass");
        User us = this.Extraer(nombre, pass);
        if(us != null){
            //User usu = new User(nombre, pass, "Matias Ignacio Casco Cantero");
            HttpSession session = request.getSession();
            //session.setAttribute("usuario", usu);
            session.setAttribute("usuario",us);
            request.getRequestDispatcher("MenuServlet").forward(request, response);
        }else{
            request.getRequestDispatcher("Error.jsp").forward(request, response);
        }
        
//        if (nombre.equalsIgnoreCase("Matute")) {
//            if (pass.equalsIgnoreCase("123")) {
//                /*ok, usuario correcto*/
//                User usu = new User(nombre, pass, "Matias Ignacio Casco Cantero");
//                HttpSession session = request.getSession();
//                session.setAttribute("usuario", usu);
//                
//                request.getRequestDispatcher("MenuServlet").forward(request, response);
//            } else {
//                /*Pass incorrecto*/
//                request.getRequestDispatcher("Error.jsp").forward(request, response);
//            }
//        }else{
//            /*Usuario incorrecto*/
//            request.getRequestDispatcher("Error.jsp").forward(request, response);
//        }
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet ValidarServlet</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet ValidarServlet at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }
    }

    private par2019.domain.model.entity.User Extraer(String Nombre, String password){
        Gson json = new Gson();
        UserCliente cp=new UserCliente();

        par2019.domain.model.entity.User usuario = null;
        ArrayList value = cp.getUsers(ArrayList.class);
        for(Object pro: value){
            par2019.domain.model.entity.User us = json.fromJson(pro.toString(), par2019.domain.model.entity.User.class);
            if(Nombre.equals(us.getLoginName()) && password.equals(us.getPasswd())){
                usuario = us;
            }
                 
        }
        cp.close();
        return usuario;
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
