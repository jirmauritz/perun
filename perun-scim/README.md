# Perun SCIM protocol support

This module contains support for SCIM protocol v2 within Perun system. For manipulation with resources, SCIM provides REST API with a simple set of operations.

Current situation:
* we don't support neither filtering  not sorting while obtaining resources from Perun system.
* we support `GET` methods only

For more information about SCIM Protocol, please visit [this page](http://www.simplecloud.info/).

### Discovery
To simplify interoperability, SCIM provides three endpoints to discover supported features and specific attribute details.

Method|Endpoint|Result|Implemented?
:----:|--------|------|------------
`GET`|`/api/v2/ServiceProviderConfigs`|Returns specification compliance, authentication schemes, data models|No
`GET`|`/api/v2/ResourceTypes`|Returns types of available resources|No
`GET`|`/api/v2/Schemas`|Returns resources and attribute extensions|No


### Users
Users are members of the groups.

Method|Endpoint|Result|Implemented?
:----:|--------|------|------------
`POST`|`/api/v2/Users`|Creates new user|No
`GET`|`/api/v2/Users/{uid}`|Returns a single user|No
`PUT`|`/api/v2/Users/{uid}`|Updates existing user|No
`DELETE`|`/api/v2/Users/{uid}`|Deletes a single user|No


### Groups
Groups are used to model the organizationational structure of provisioned resources. Groups can contain users or other groups.

Method|Endpoint|Result|Implemented?
:----:|--------|------|------------
`POST`|`/api/v2/Groups`|Creates new group|No
`GET`|`/api/v2/Groups/{gid}`|Returns a single group|No
`PUT`|`/api/v2/Groups/{gid}`|Updates existing group|No
`DELETE`|`/api/v2/Groups/{gid}`|Deletes a single group|No

### Bulk (not supported)
An optional server feature that enables clients to send a potentially large collection of resource operations in a single request.

Method|Endpoint|Result|Implemented?
:----:|--------|------|------------
`GET`|`/api/v2/Bulk`|Massive bulk updates|No

