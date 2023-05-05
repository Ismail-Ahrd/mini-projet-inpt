package com.example.miniprojetasedsinpt.controllers;

import com.example.miniprojetasedsinpt.dtos.PersonneDTO;
import com.example.miniprojetasedsinpt.security.AuthService;
import com.example.miniprojetasedsinpt.security.AuthenticationRequest;
import com.example.miniprojetasedsinpt.security.AuthenticationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/authentication")
@CrossOrigin("*")
public class AuthenticationController {
    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody PersonneDTO personneDTO) {
        AuthenticationResponse authResponse = authService.register(personneDTO);
        return ResponseEntity.ok(authResponse);
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest authenticationRequest) {
        AuthenticationResponse authResponse = authService.authenticate(authenticationRequest);
        return ResponseEntity.ok(authResponse);
    }

}
