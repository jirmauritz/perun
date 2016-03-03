package cz.metacentrum.perun.scim.api.endpoints;

import cz.metacentrum.perun.scim.AbstractSCIMTest;
import cz.metacentrum.perun.scim.SCIM;
import static cz.metacentrum.perun.scim.api.SCIMDefaults.BASE_PATH;
import static cz.metacentrum.perun.scim.api.SCIMDefaults.SERVICE_PROVIDER_CONFIGS_PATH;
import javax.ws.rs.core.Response;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ServiceProviderConfigsEndpointControllerTest extends AbstractSCIMTest {

    @Autowired
    SCIM restApi;

    @Test
    public void testGetServiceProviderConfigs() throws Exception {
        Response result = restApi.process(session, "GET", BASE_PATH + SERVICE_PROVIDER_CONFIGS_PATH, null, null);

        String expectedJson = "";
        assertEquals("expected service provider configs should equal with result obtained from SCIM REST API",
                expectedJson, result.getEntity().toString());
    }

}
