package com.itvillage.cshopper.dto.response.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class IdentityRequest {
    private String id;
}
