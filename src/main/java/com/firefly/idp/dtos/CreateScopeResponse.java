package com.firefly.idp.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

/**
 * Response containing the created scope information.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateScopeResponse {
    private String id;
    private String name;
    private Instant createdAt;
}