package com.appLogin.demo.model.User;

import jakarta.validation.constraints.NotBlank;

public record UserLoginRequestDto(
        @NotBlank
        String username,
        @NotBlank
        String password) {

}