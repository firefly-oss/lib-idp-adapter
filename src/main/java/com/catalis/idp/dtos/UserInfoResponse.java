package com.catalis.idp.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoResponse {
    private String sub;
    private String email;
    private Boolean emailVerified;
    private String name;
    private String preferredUsername;
    private String givenName;
    private String familyName;
}
