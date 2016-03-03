package cz.metacentrum.perun.scim;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static cz.metacentrum.perun.scim.api.SCIMDefaults.*;
import javax.ws.rs.core.Response;

/**
 * REST Controller for SCIM.
 *
 * @author Sona Mastrakova <sona.mastrakova@gmail.com>
 */
public class SCIMController {

    private final Logger log = LoggerFactory.getLogger(SCIMController.class);

    public final Response getResources() {
        Map<String, String> resourcesMap = new HashMap<>();

        log.debug("Calling SCIM REST method getResources()");
        resourcesMap.put("users", BASE_PATH + USERS_PATH);
        resourcesMap.put("groups", BASE_PATH + GROUPS_PATH);
        resourcesMap.put("schemas", BASE_PATH + SCHEMAS_PATH);
        resourcesMap.put("resource_types", BASE_PATH + RESOURCE_TYPES_PATH);
        resourcesMap.put("service_provider_configs", BASE_PATH + SERVICE_PROVIDER_CONFIGS_PATH);
        log.debug("Returned {} resources", resourcesMap.size());

        return Response.ok(Collections.unmodifiableMap(resourcesMap)).type(MediaType.APPLICATION_JSON_VALUE).build();
    }
}
