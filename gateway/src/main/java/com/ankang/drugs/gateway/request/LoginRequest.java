package com.ankang.drugs.gateway.request;


import lombok.Data;

@Data
public class LoginRequest {

    private String username;

    private String password;
}
