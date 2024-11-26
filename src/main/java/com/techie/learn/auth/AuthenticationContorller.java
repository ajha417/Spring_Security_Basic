package com.techie.learn.auth;

import com.techie.learn.auth.service.AuthenticateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthenticationContorller {

    private AuthenticateService service;
    @PostMapping("register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody AuthenticationRequest request) {

        //TODO some code here regarding register
        return ResponseEntity.ok(service.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(service.autheticate(request));
    }


}
