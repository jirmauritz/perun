package cz.metacentrum.perun.scim.api.dto;

import cz.metacentrum.perun.scim.api.enums.Mutability;
import cz.metacentrum.perun.scim.api.entities.Resource;
import cz.metacentrum.perun.scim.api.enums.Uniqueness;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.codehaus.jackson.annotate.JsonProperty;

import java.util.List;

/**
 * @author Sona Mastrakova <sona.mastrakova@gmail.com>
 */
@EqualsAndHashCode
@ToString
public class SchemaDto extends Resource {

    @JsonProperty
    private String name;

    @JsonProperty
    private String description;

    @JsonProperty
    private List<Attribute> attributes;

    @EqualsAndHashCode
    @ToString
    private static class Attribute {

        @JsonProperty
        private String name;

        @JsonProperty
        private String type;

        @JsonProperty
        private Boolean multivalued;

        @JsonProperty
        private String description;

        @JsonProperty
        private Boolean required;

        @JsonProperty
        private Boolean caseExact;

        @JsonProperty
        private Mutability mutability;

        @JsonProperty
        // always, never, request, default
        private String returned;

        @JsonProperty
        private Uniqueness uniqueness;

        @JsonProperty
        List<Attribute> subAttributes;

        @JsonProperty
        List<String> referenceTypes;

        @JsonProperty
        List<String> canonicalValues;
    }
}
