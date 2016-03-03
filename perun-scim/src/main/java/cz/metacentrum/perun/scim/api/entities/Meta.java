package cz.metacentrum.perun.scim.api.entities;

import org.codehaus.jackson.annotate.JsonProperty;

import java.util.Date;

/**
 * @author Sona Mastrakova <sona.mastrakova@gmail.com>
 */
public class Meta {

    @JsonProperty
    private String resourceType;

    @JsonProperty
    private Date created;

    @JsonProperty
    private Date lastModified;

    @JsonProperty
    private String location;

    @JsonProperty
    private String version;
}
