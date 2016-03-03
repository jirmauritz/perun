package cz.metacentrum.perun.scim.api.endpoints;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.ws.rs.core.Response;

/**
 * @author Sona Mastrakova <sona.mastrakova@gmail.com>
 */
public class ServiceProviderConfigsEndpointController {

    private final Logger log = LoggerFactory.getLogger(ServiceProviderConfigsEndpointController.class);

    public final Response getServiceProviderConfigs() {
        //type(CONTENT_TYPE)
        return Response.status(Response.Status.METHOD_NOT_ALLOWED).build();
    }
}
