package com.catalis.idp.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Request to assign or remove roles from a user.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AssignRolesRequest {
    private String userId;
    private List<String> roleNames;
}