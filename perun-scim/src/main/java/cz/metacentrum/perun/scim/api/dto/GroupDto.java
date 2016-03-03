package cz.metacentrum.perun.scim.api.dto;

import cz.metacentrum.perun.scim.api.entities.Resource;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.codehaus.jackson.annotate.JsonProperty;

import java.util.List;

import static cz.metacentrum.perun.scim.api.SCIMDefaults.URN_GROUP;
import lombok.Data;

/**
 *
 * @author Sona Mastrakova <sona.mastrakova@gmail.com>
 */
@EqualsAndHashCode
@ToString
@Data
public class GroupDto extends Resource {

    @JsonProperty
    private String schema = URN_GROUP;

    @JsonProperty
    private String displayName;

    @JsonProperty
    private List<Member> members;

    public void setMembers(List<UserDto> users){
        // TODO: mapper.map(users, members);
    }

    @EqualsAndHashCode
    @ToString
    @Data
    private static class Member {
        @JsonProperty
        private String value;

        @JsonProperty("$ref")
        private String ref;

        @JsonProperty
        private String display;
    }
}
