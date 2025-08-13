package com.catalis.idp.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MfaChallengeResponse {
    private String challengeId;
    private String deliveryMethod; // e.g., SMS, EMAIL, TOTP
    private String destination;    // e.g., masked phone/email
    private Instant expiresAt;
}