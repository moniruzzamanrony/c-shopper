package com.itvillage.ecommaz.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class IdentityRequest {
    private String id;
}
