package com.ankang.drugs.gateway.request;

import lombok.Data;

@Data
public class RefreshRequest {

    private String userId;

    private String refreshToken;
}
