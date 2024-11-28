package com.techie.learn.auth.service;

import com.techie.learn.auth.AuthenticationRequest;
import com.techie.learn.auth.AuthenticationResponse;
import com.techie.learn.auth.RegisterRequest;
import com.techie.learn.enums.ERole;
import com.techie.learn.model.User;
import com.techie.learn.repo.UserRepository;
import com.techie.learn.service.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticateService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final JwtService jwtService;
    public AuthenticationResponse register(RegisterRequest request) {
        var user = User.builder()
                .firstName(request.getFirstname())
                .lastName(request.getLastname())
                .email(request.getEmail())
                .pass(passwordEncoder.encode(request.getPassword()))
                .role(ERole.USER)
                .build();
        userRepository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder().token(jwtToken).build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        return AuthenticationResponse.builder().build();
    }
}
