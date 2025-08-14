package com.catalis.idp.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Request to create a new scope (e.g., OAuth2 scope / Keycloak client scope).
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateScopeRequest {
    /** Optional client or realm context, provider-specific. */
    private String context;

    private String name;
    private String description;
}