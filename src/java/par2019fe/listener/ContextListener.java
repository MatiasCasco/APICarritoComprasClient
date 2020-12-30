/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package par2019fe.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 *
 * @author Mauricio
 */
public class ContextListener implements ServletContextListener {
    
    @Override
    public void contextInitialized(ServletContextEvent event) {
        event.getServletContext().log("Aplicacion par2019fe iniciada...");
    }
    
    @Override
    public void contextDestroyed(ServletContextEvent event) {
        event.getServletContext().log("Aplicacion par2019fe detenida...");
    }
}
