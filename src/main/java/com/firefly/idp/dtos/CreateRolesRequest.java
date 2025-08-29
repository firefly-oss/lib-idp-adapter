package com.firefly.idp.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Request to create one or more roles in the IdP/realm.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateRolesRequest {
    /** Optional client or realm context, provider-specific. */
    private String context;

    /** Names of the roles to create. */
    private List<String> roleNames;

    /** Optional description applied to all roles, provider permitting. */
    private String description;
}