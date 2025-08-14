package com.catalis.idp.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Response containing the roles created by the IdP.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateRolesResponse {
    private List<String> createdRoleNames;
}