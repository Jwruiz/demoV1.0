package com.appLogin.demo.controller;

import com.appLogin.demo.model.User.User;
import com.appLogin.demo.model.User.UserLoginRequestDto;
import com.appLogin.demo.security.JWTTokenDto;
import com.appLogin.demo.security.JWTTokenService;
import lombok.AllArgsConstructor;
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
    @RequestMapping("/login")
    @AllArgsConstructor
    public class LoginController {

        private final AuthenticationManager authenticationManager;
        private final JWTTokenService tokenService;

        @PostMapping
        public ResponseEntity<JWTTokenDto> autenticarUsuario(@RequestBody @Valid UserLoginRequestDto request) {
            System.out.println("REQUEST=" + request);
            try {
                Authentication authToken = new UsernamePasswordAuthenticationToken(request.username(), request.password());
                System.out.println("authToken=" + authToken);
                var usuarioAutenticado = authenticationManager.authenticate(authToken);
                System.out.println("usuarioAutenticado=" + usuarioAutenticado);
                var JWTtoken = tokenService.createToken((User) usuarioAutenticado.getPrincipal());
                System.out.println("TOKEN=" + JWTtoken);
                return ResponseEntity.ok(new JWTTokenDto(JWTtoken));
            } catch (AuthenticationException e) {
                System.out.println("Authentication failed: " + e.getMessage());
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            }
        }
    }

