package com.murat.backend.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class LoginRequest {

    @Email(message = "Please provide a correct email")
    private String email;

    @NotNull(message = "Please provide a password")
    private String password;


}

