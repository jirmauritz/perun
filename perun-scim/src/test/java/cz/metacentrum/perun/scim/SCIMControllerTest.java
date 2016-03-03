package cz.metacentrum.perun.scim;

import org.junit.Test;

import java.util.Map;
import javax.ws.rs.core.Response;

import static cz.metacentrum.perun.scim.api.SCIMDefaults.BASE_PATH;
import static org.junit.Assert.assertEquals;
import org.springframework.beans.factory.annotation.Autowired;

public class SCIMControllerTest extends AbstractSCIMTest {

    @Autowired
    SCIM restApi;
    
    @Test
    public void testGetResources() throws Exception {
        Response result = restApi.process(session, "GET", BASE_PATH, null, null);
        Map<String, String> resultMap = (Map) result.getEntity();

        assertEquals("controller should return 5 endpoints", 5, resultMap.size());
    }
}
