package com.catalis.idp.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IntrospectionResponse {
    private boolean active;
    private String scope;
    private String username;
    private Long exp;
    private Long iat;
    private String sub;
    private List<String> aud;
    private String iss;
    private String jti;
    private String clientId;
}
