package com.appLogin.demo.controller;

import com.appLogin.demo.model.User.RegisterRequestDto;
import com.appLogin.demo.model.User.User;
import com.appLogin.demo.model.User.UserLoginRequestDto;
import com.appLogin.demo.security.JWTTokenDto;
import com.appLogin.demo.security.JWTTokenService;
import com.appLogin.demo.service.AuthService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JWTTokenService tokenService;
    private final AuthService authService;

    // Endpoint para login
    @PostMapping("/login")
    public ResponseEntity<JWTTokenDto> autenticarUsuario(@RequestBody @Valid UserLoginRequestDto request) {
        try {
            Authentication authToken = new UsernamePasswordAuthenticationToken(
                    request.username(), request.password()
            );
            var usuarioAutenticado = authenticationManager.authenticate(authToken);
            var JWTtoken = tokenService.createToken((User) usuarioAutenticado.getPrincipal());
            return ResponseEntity.ok(new JWTTokenDto(JWTtoken));
        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    // Endpoint para registro
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody @Valid RegisterRequestDto request) {
        authService.register(request);
        return ResponseEntity.ok("Usuario registrado con éxito");
    }
}


