package com.appLogin.demo.service;

import com.appLogin.demo.model.User.RegisterRequestDto;
import com.appLogin.demo.model.User.User;
import com.appLogin.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void register(RegisterRequestDto request) {
        System.out.println("Email recibido: " + request.email());

        // Validar si ya existe un usuario con el mismo email
        if (userRepository.existsByEmail(request.email())) {
            throw new RuntimeException("El correo electrónico ya está registrado.");
        }

        User user = new User();
        user.setUsername(request.username());
        user.setEmail(request.email());
        user.setPassword(passwordEncoder.encode(request.password()));

        userRepository.save(user);
    }
}