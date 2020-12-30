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
 * Jersey REST client generated for REST resource:TDetRestService [/tdapi]<br>
 * USAGE:
 * <pre>
 *        SeTransaccionD client = new SeTransaccionD();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author Matias
 */
public class SeTransaccionD {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/paronlineapi/rest";

    public SeTransaccionD() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("tdapi");
    }

    public <T> T getTDet(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("transacciones_det");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void updateTDet(Object requestEntity) throws ClientErrorException {
        webTarget.path("transacciones_det").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public <T> T addTDet(Object requestEntity, Class<T> responseType) throws ClientErrorException {
        return webTarget.path("transacciones_det").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON), responseType);
    }

    public void removeTDet(String id, String item) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("transacciones_det/{0}/nitem/{1}", new Object[]{id, item})).request().delete();
    }

    public <T> T getTransacciones_det(Class<T> responseType, String id, String item) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("transacciones_det/{0}/nitem/{1}", new Object[]{id, item}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void close() {
        client.close();
    }
    
}
