/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package par2019fe.modelo;

import java.util.ArrayList;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import par2019fe.beans.User;

/**
 *
 * @author Mauricio
 */
public class UsuarioModelo {
    public ArrayList<User> getUsuarios() {
        ResteasyClient client = new ResteasyClientBuilder().build();
        ResteasyWebTarget target = client.target("http://localhost:8080/par2019/rest/userapi/users");
        Response response = target.request().get();
        GenericType<ArrayList<User>> genericType = new GenericType<ArrayList<User>>() {};
        ArrayList<User> values = response.readEntity(genericType);
//        User values = response.readEntity(User.class);
        response.close();
        return values;
    }
}
