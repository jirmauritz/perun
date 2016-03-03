package cz.metacentrum.perun.scim.api.endpoints;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.ws.rs.core.Response;

/**
 * @author Sona Mastrakova <sona.mastrakova@gmail.com>
 */
public class ResourceTypesEndpointController {

    private final static Logger log = LoggerFactory.getLogger(ResourceTypesEndpointController.class);

    public final Response getResourceTypes() {
        // type(MediaType.APPLICATION_JSON_VALUE)
        return Response.status(Response.Status.METHOD_NOT_ALLOWED).build();
    }
}
