package cz.metacentrum.perun.scim.api.dto;

import cz.metacentrum.perun.scim.api.entities.Resource;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.codehaus.jackson.annotate.JsonProperty;

import java.util.List;

import static cz.metacentrum.perun.scim.api.SCIMDefaults.URN_USER;
import lombok.Data;

/**
 *
 * @author Sona Mastrakova <sona.mastrakova@gmail.com>
 */
@EqualsAndHashCode
@ToString
@Data
public class UserDto extends Resource {

    @JsonProperty
    private String schema = URN_USER;

    @JsonProperty
    private String userName;

    @JsonProperty
    private Name name;

    @JsonProperty
    private String displayName;

    @JsonProperty
    private String nickName;

    @JsonProperty
    private String profileUrl;

    @JsonProperty
    private String locale;

    @JsonProperty
    private String timezone;

    @JsonProperty
    private Boolean active;

    @JsonProperty
    private String password;

    @JsonProperty
    private List<Email> emails;

    @JsonProperty
    private List<PhoneNumber> phoneNumbers;

    @JsonProperty
    private List<Address> addresses;

    @JsonProperty
    private List<GroupDto> groups;

    @JsonProperty
    private List<X509Certificate> x509Certificates;

    @EqualsAndHashCode
    @ToString
    private static class Name {
        @JsonProperty
        private String formatted;

        @JsonProperty
        private String familyName;

        @JsonProperty
        private String givenName;

        @JsonProperty
        private String middleName;

        @JsonProperty
        private String honorificPrefix;

        @JsonProperty
        private String honorificSuffix;
    }

    @EqualsAndHashCode
    @ToString
    private static class Email {
        @JsonProperty
        private String type;

        @JsonProperty
        private String value;

        @JsonProperty
        private Boolean primary;
    }

    @EqualsAndHashCode
    @ToString
    private static class PhoneNumber {
        @JsonProperty
        private String type;

        @JsonProperty
        private String value;

        @JsonProperty
        private Boolean primary;
    }

    @EqualsAndHashCode
    @ToString
    private static class Address {
        @JsonProperty
        private String type;

        @JsonProperty
        private String formatted;

        @JsonProperty
        private String streetAddress;

        @JsonProperty
        private String locality;

        @JsonProperty
        private String region;

        @JsonProperty
        private String postalCode;

        @JsonProperty
        private String country;

        @JsonProperty
        private Boolean primary;
    }

    @EqualsAndHashCode
    @ToString
    private static class X509Certificate {
        @JsonProperty
        private String type;

        @JsonProperty
        private String value;

        @JsonProperty
        private Boolean primary;
    }
}
