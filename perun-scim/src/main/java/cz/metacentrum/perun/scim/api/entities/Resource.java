package cz.metacentrum.perun.scim.api.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 *
 * @author Sona Mastrakova <sona.mastrakova@gmail.com>
 */
@EqualsAndHashCode
@ToString
@Data
public class Resource {

    @JsonProperty
    private Long id;

    @JsonProperty
    private Long externalId;

    @JsonProperty
    private Meta meta;
}
