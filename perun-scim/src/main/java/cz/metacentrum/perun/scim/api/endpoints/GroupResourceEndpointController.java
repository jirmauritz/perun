package cz.metacentrum.perun.scim.api.endpoints;

import cz.metacentrum.perun.core.api.Group;
import cz.metacentrum.perun.scim.api.dto.GroupDto;
import cz.metacentrum.perun.core.api.PerunSession;
import cz.metacentrum.perun.core.api.exceptions.GroupNotExistsException;
import cz.metacentrum.perun.core.api.exceptions.InternalErrorException;
import cz.metacentrum.perun.core.bl.PerunBl;

import lombok.NonNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.Valid;
import javax.ws.rs.core.Response;
import static cz.metacentrum.perun.scim.api.SCIMDefaults.CONTENT_TYPE;

/**
 * @author Sona Mastrakova <sona.mastrakova@gmail.com>
 */
public class GroupResourceEndpointController {

    private final Logger log = LoggerFactory.getLogger(GroupResourceEndpointController.class);
    private final PerunSession session;
    private final PerunBl perunBl;

    public GroupResourceEndpointController(PerunSession session) {
        this.session = session;
        this.perunBl = (PerunBl) session.getPerun();
    }
    
    public Response createGroup(@NonNull @Valid GroupDto groupDto) {
        return Response.status(Response.Status.METHOD_NOT_ALLOWED).build();
    }

    public Response updateGroup(@NonNull String identifier, @NonNull @Valid GroupDto groupDto) {
        return Response.status(Response.Status.METHOD_NOT_ALLOWED).build();
    }

    public Response deleteGroup(@NonNull String identifier) {
        return Response.status(Response.Status.METHOD_NOT_ALLOWED).build();
    }

    public Response getGroup(@NonNull String identifier) {
        log.debug("Calling SCIM REST method getGroup by id {}", identifier);
        
        try {
            Group perunGroup = perunBl.getGroupsManagerBl().getGroupById(session, Integer.parseInt(identifier));
            // TODO: create mapper
            // return mapper.map(perunGroup, GroupDto.class);
            return Response.ok().type(CONTENT_TYPE).build();
        } catch (InternalErrorException ex) {
            log.warn("Internal exception occured while getting group with id {}.", identifier);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        } catch (GroupNotExistsException ex) {
            log.warn("Group with id {} does not exists.", identifier);
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
