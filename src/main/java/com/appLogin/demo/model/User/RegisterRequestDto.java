package com.appLogin.demo.model.User;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RegisterRequestDto(@NotBlank(message = "El nombre de usuario es obligatorio")
                                     String username,

                                 @NotBlank(message = "El email es obligatorio")
                                     @Email(message = "El email no es válido")
                                     String email,

                                 @NotBlank(message = "La contraseña es obligatoria")
                                     @Size(min = 6, message = "La contraseña debe tener al menos 6 caracteres")
                                     String password) {
}
