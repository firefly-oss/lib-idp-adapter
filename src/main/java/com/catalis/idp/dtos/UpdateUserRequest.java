package com.catalis.idp.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

/**
 * Payload to update an existing user in the IdP.
 * Fields left as null should be treated by implementations as "do not modify".
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateUserRequest {
    /** Provider-specific unique identifier of the user to update. */
    private String userId;
    private String email;
    private String givenName;
    private String familyName;
    private Boolean enabled;
    private Map<String, List<String>> attributes;
}
