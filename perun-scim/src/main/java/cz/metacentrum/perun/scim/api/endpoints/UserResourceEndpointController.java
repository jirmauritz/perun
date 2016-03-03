package cz.metacentrum.perun.scim.api.endpoints;

import cz.metacentrum.perun.core.bl.PerunBl;
import cz.metacentrum.perun.core.api.User;
import cz.metacentrum.perun.scim.api.dto.UserDto;
import cz.metacentrum.perun.core.api.PerunSession;
import cz.metacentrum.perun.core.api.exceptions.InternalErrorException;
import cz.metacentrum.perun.core.api.exceptions.UserNotExistsException;

import lombok.NonNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.Valid;
import javax.ws.rs.core.Response;

import static cz.metacentrum.perun.scim.api.SCIMDefaults.CONTENT_TYPE;

/**
 * @author Sona Mastrakova <sona.mastrakova@gmail.com>
 */
public class UserResourceEndpointController {

    private final Logger log = LoggerFactory.getLogger(UserResourceEndpointController.class);
    private final PerunSession session;
    private final PerunBl perunBl;

    public UserResourceEndpointController(PerunSession session) {
        this.session = session;
        this.perunBl = (PerunBl) session.getPerun();
    }

    public final Response createUser(@NonNull @Valid UserDto userDto) {
        return Response.status(Response.Status.METHOD_NOT_ALLOWED).build();
    }

    public final Response updateUser( @NonNull String identifier, @NonNull UserDto userDto) {
        return Response.status(Response.Status.METHOD_NOT_ALLOWED).build();
    }

    public final Response deleteUser(@NonNull String identifier) {
        return Response.status(Response.Status.METHOD_NOT_ALLOWED).build();
    }

    public final Response getUser(@NonNull String identifier) {
        log.debug("Calling SCIM REST method  getUser by id {}", identifier);

        try {
            User perunUser = perunBl.getUsersManagerBl().getUserById(session, Integer.parseInt(identifier));
            // TODO: create mapper
            // return mapper.map(perunUser, UserDto.class);
            return Response.ok().type(CONTENT_TYPE).build();
        } catch (InternalErrorException ex) {
            log.warn("Internal exception occured while getting user with id {}.", identifier);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        } catch (UserNotExistsException ex) {
            log.warn("User with id {} does not exists.", identifier);
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
