package com.itvillage.cshopper.dto.response;

public class JwtResponse {

    private String token;
    private String type = "Bearer";
    private final String id;

    public JwtResponse(String accessToken, final String id) {
        this.token = accessToken;
        this.id = id;
    }

    public String getAccessToken() {
        return token;
    }

    public void setAccessToken(String accessToken) {
        this.token = accessToken;
    }

    public String getTokenType() {
        return type;
    }

    public void setTokenType(String tokenType) {
        this.type = tokenType;
    }

    public String getId() {
        return id;
    }


}
