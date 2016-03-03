package cz.metacentrum.perun.scim.api.endpoints;

import cz.metacentrum.perun.scim.AbstractSCIMTest;
import cz.metacentrum.perun.scim.SCIM;
import static cz.metacentrum.perun.scim.api.SCIMDefaults.BASE_PATH;
import static cz.metacentrum.perun.scim.api.SCIMDefaults.GROUPS_PATH;
import cz.metacentrum.perun.scim.api.dto.GroupDto;
import cz.metacentrum.perun.scim.api.exceptions.SCIMException;
import javax.ws.rs.core.Response;
import static junit.framework.TestCase.assertEquals;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class GroupResourceEndpointControllerTest extends AbstractSCIMTest {

    @Autowired
    SCIM restApi;

    @Test
    public void testCreateGroup() throws SCIMException {
        Response result = restApi.process(session, "POST", BASE_PATH + GROUPS_PATH, null, new GroupDto());

        assertEquals("api should return HTTP status 405", 405, result.getStatus());
    }

    @Test(expected = NullPointerException.class)
    public void testCreateNullGroup() throws SCIMException {
        restApi.process(session, "POST", BASE_PATH + GROUPS_PATH, null, null);
    }

    @Test
    public void testUpdateGroup() throws SCIMException {
        Response result = restApi.process(session, "PUT", BASE_PATH + GROUPS_PATH, "8", new GroupDto());

        assertEquals("api should return HTTP status 405", 405, result.getStatus());
    }

    @Test(expected = NullPointerException.class)
    public void testUpdateNullGroup() throws SCIMException {
        restApi.process(session, "POST", BASE_PATH + GROUPS_PATH, "8", null);
    }

    @Test
    public void testDeleteGroup() throws SCIMException {
        Response result = restApi.process(session, "DELETE", BASE_PATH + GROUPS_PATH, "8", null);

        assertEquals("api should return HTTP status 405", 405, result.getStatus());
    }

    @Test
    public void testGetGroup() throws Exception {
//        createVos();
//        createGroups();
    }
}
