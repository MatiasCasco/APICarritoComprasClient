/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Consumir.Resteasy;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

/**
 * Jersey REST client generated for REST resource:TransaccionCabRestService
 * [/tcapi]<br>
 * USAGE:
 * <pre>
 *        SeTransaccion client = new SeTransaccion();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author Matias
 */
public class SeTransaccion {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/paronlineapi/rest";

    public SeTransaccion() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("tcapi");
    }

    public void removeTransacciones_cab(String id) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("tcabs/{0}", new Object[]{id})).request().delete();
    }

    public <T> T getTransaccionesCab(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("tcabs");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void updateTransacciones_cab(Object requestEntity) throws ClientErrorException {
        webTarget.path("tcabs").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public <T> T addTransacciones_cab(Object requestEntity, Class<T> responseType) throws ClientErrorException {
        return webTarget.path("tcabs").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), responseType);
    }

    public <T> T getTransacciones_cab(Class<T> responseType, String id) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("tcabs/{0}", new Object[]{id}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void close() {
        client.close();
    }
    
}
