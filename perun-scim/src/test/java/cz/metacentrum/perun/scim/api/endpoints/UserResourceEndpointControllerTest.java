package cz.metacentrum.perun.scim.api.endpoints;

import cz.metacentrum.perun.scim.AbstractSCIMTest;
import cz.metacentrum.perun.scim.SCIM;
import cz.metacentrum.perun.scim.api.dto.UserDto;
import cz.metacentrum.perun.scim.api.exceptions.SCIMException;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static cz.metacentrum.perun.scim.api.SCIMDefaults.BASE_PATH;
import static cz.metacentrum.perun.scim.api.SCIMDefaults.USERS_PATH;
import cz.metacentrum.perun.scim.api.mapper.SCIMMapper;
import javax.ws.rs.core.Response;
import static junit.framework.TestCase.assertEquals;

public class UserResourceEndpointControllerTest extends AbstractSCIMTest {

    @Autowired
    SCIM restApi;

    @Autowired
    SCIMMapper mapper;

    @Test
    public void testCreateUser() throws SCIMException {
        Response result = restApi.process(session, "POST", BASE_PATH + USERS_PATH, null, new UserDto());

        assertEquals("api should return HTTP status 405", 405, result.getStatus());
    }

    @Test(expected = NullPointerException.class)
    public void testCreateNullUser() throws SCIMException {
        restApi.process(session, "POST", BASE_PATH + USERS_PATH, null, null);
    }

    @Test
    public void testUpdateUser() throws SCIMException {
        Response result = restApi.process(session, "PUT", BASE_PATH + USERS_PATH, "5", new UserDto());

        assertEquals("api should return HTTP status 405", 405, result.getStatus());
    }

    @Test(expected = NullPointerException.class)
    public void testUpdateNullUser() throws SCIMException {
        restApi.process(session, "PUT", BASE_PATH + USERS_PATH, "5", null);
    }

    @Test
    public void testDeleteUser() throws SCIMException {
        Response result = restApi.process(session, "DELETE", BASE_PATH + USERS_PATH, "5", null);

        assertEquals("api should return HTTP status 405", 405, result.getStatus());
    }

    @Test
    public void testGetUser() throws Exception {
//        createUsers();

        Response result = restApi.process(session, "GET", BASE_PATH + USERS_PATH, "2", null);

        // TODO
        UserDto expectedUser = new UserDto();
        expectedUser.setDisplayName(user2.getDisplayName());
        expectedUser.setId(Long.valueOf(user2.getId()));
        
        UserDto actualUser = (UserDto) result.getEntity();
        assertEquals("users should equal", expectedUser, actualUser);
    }

}
