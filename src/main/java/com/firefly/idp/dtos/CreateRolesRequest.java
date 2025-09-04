/*
 * Copyright 2025 Firefly Software Solutions Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


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