package cz.metacentrum.perun.scim;

import cz.metacentrum.perun.core.api.PerunSession;

import static cz.metacentrum.perun.scim.api.SCIMDefaults.BASE_PATH;
import static cz.metacentrum.perun.scim.api.SCIMDefaults.GROUPS_PATH;
import static cz.metacentrum.perun.scim.api.SCIMDefaults.RESOURCE_TYPES_PATH;
import static cz.metacentrum.perun.scim.api.SCIMDefaults.SCHEMAS_PATH;
import static cz.metacentrum.perun.scim.api.SCIMDefaults.SERVICE_PROVIDER_CONFIGS_PATH;
import static cz.metacentrum.perun.scim.api.SCIMDefaults.USERS_PATH;

import cz.metacentrum.perun.scim.api.dto.GroupDto;
import cz.metacentrum.perun.scim.api.dto.UserDto;

import cz.metacentrum.perun.scim.api.exceptions.SCIMException;
import cz.metacentrum.perun.scim.api.endpoints.GroupResourceEndpointController;
import cz.metacentrum.perun.scim.api.endpoints.ResourceTypesEndpointController;
import cz.metacentrum.perun.scim.api.endpoints.SchemasEndpointController;
import cz.metacentrum.perun.scim.api.endpoints.ServiceProviderConfigsEndpointController;
import cz.metacentrum.perun.scim.api.endpoints.UserResourceEndpointController;

import javax.ws.rs.core.Response;
import org.springframework.stereotype.Component;

/**
 * SCIM protocol
 *
 * SCIM (System for Cross-domain Identity Management) is a protocol for
 * cross-domain access to information about users and groups. With SCIM protocol
 * it is possible to create/update/get/delete resources.
 *
 * @author Sona Mastrakova <sona.mastrakova@gmail.com>
 */
@Component
public class SCIM {

    public Response process(PerunSession session, String methodType, String path,
            String pathVariable, Object requestBody) throws SCIMException {

        if (session.getPerunPrincipal().getUser() == null) {
            throw new SCIMException("invalid_user");
        }

        if (path.contains(BASE_PATH + USERS_PATH)) {
            // TODO: mapper.map(requestBody, UserDto.class)

            UserResourceEndpointController controller
                    = new UserResourceEndpointController(session);

            switch (methodType) {
                case "POST":
                    UserDto createdUser = (UserDto) requestBody;
                    return controller.createUser(createdUser);
                case "GET":
                    return controller.getUser(pathVariable);
                case "PUT":
                    UserDto updatedUser = (UserDto) requestBody;
                    return controller.updateUser(pathVariable, updatedUser);
                case "DELETE":
                    return controller.deleteUser(pathVariable);
            }
        }

        if (path.contains(BASE_PATH + GROUPS_PATH)) {
            // TODO: mapper.map(requestBody, GroupDto.class)

            GroupResourceEndpointController controller
                    = new GroupResourceEndpointController(session);

            switch (methodType) {
                case "POST":
                    GroupDto createdGroup = (GroupDto) requestBody;
                    return controller.createGroup(createdGroup);
                case "GET":
                    return controller.getGroup(pathVariable);
                case "PUT":
                    GroupDto updatedGroup = (GroupDto) requestBody;
                    return controller.updateGroup(pathVariable, updatedGroup);
                case "DELETE":
                    return controller.deleteGroup(pathVariable);
            }

        } else {
            process(methodType, path);
        }

        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    private Response process(String methodType, String path) {

        if (BASE_PATH.equals(path) && methodType.equals("GET")) {
            return new SCIMController().getResources();
        }

        if (path.contains(BASE_PATH + SCHEMAS_PATH) && methodType.equals("GET")) {
            return new SchemasEndpointController().getSchemas();
        }

        if (path.contains(BASE_PATH + RESOURCE_TYPES_PATH) && methodType.equals("GET")) {
            return new ResourceTypesEndpointController().getResourceTypes();
        }

        if (path.contains(BASE_PATH + SERVICE_PROVIDER_CONFIGS_PATH) && methodType.equals("GET")) {
            return new ServiceProviderConfigsEndpointController().getServiceProviderConfigs();
        }
        return Response.status(Response.Status.BAD_REQUEST).build();
    }
}
