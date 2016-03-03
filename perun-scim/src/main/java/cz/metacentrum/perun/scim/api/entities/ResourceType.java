package cz.metacentrum.perun.scim.api.entities;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.codehaus.jackson.annotate.JsonProperty;

import java.util.List;

@EqualsAndHashCode
@ToString
public class ResourceType extends Resource {

    @JsonProperty
    private List<String> schemas;

    @JsonProperty
    private String name;

    @JsonProperty
    private String endpoint;

    @JsonProperty
    private String description;

    @JsonProperty
    private String schema;

    @JsonProperty
    private List<SchemaExtensions> schemaExtensions;

    @EqualsAndHashCode
    @ToString
    private static class SchemaExtensions {
        @JsonProperty
        private String schema;

        @JsonProperty
        private Boolean required;
    }

}
