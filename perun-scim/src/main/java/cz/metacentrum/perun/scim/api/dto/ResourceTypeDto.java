package cz.metacentrum.perun.scim.api.dto;

import cz.metacentrum.perun.scim.api.entities.ResourceType;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.codehaus.jackson.annotate.JsonProperty;

import java.util.List;

/**
 *
 * @author Sona Mastrakova <sona.mastrakova@gmail.com>
 */
@EqualsAndHashCode
@ToString
public class ResourceTypeDto {

    @JsonProperty
    private Long totalResults;

    @JsonProperty
    private Long itemsPerPage;

    @JsonProperty
    private Long startIndex;

    @JsonProperty
    private List<String> schemas;

    @JsonProperty
    private List<ResourceType> resources;

}
