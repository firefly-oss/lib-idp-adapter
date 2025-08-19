package com.catalis.idp.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Request payload for logging out / revoking tokens.
 * Contains both access and refresh tokens so providers can invalidate both
 * sessions according to their capabilities.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LogoutRequest {
    private String accessToken;
    private String refreshToken;
}
