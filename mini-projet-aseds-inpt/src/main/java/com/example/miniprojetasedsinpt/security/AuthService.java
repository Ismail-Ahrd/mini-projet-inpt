package com.example.miniprojetasedsinpt.security;

import com.example.miniprojetasedsinpt.dtos.PersonneDTO;
import com.example.miniprojetasedsinpt.entities.Personne;
import com.example.miniprojetasedsinpt.mappers.PersonneMapper;
import com.example.miniprojetasedsinpt.repositories.PersonneRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthService {
    private final PersonneMapper personneMapper;
    private final PersonneRepository personneRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(PersonneDTO personneDTO) {
        Personne personne = personneMapper.fromPersonneDTO(personneDTO);
        Personne savedPersonne = personneRepository.save(personne);
        UserDetails userDetails = new UserRegistrationDetails(savedPersonne);
        Map<String, Object> extraClaims = new HashMap<>();
        extraClaims.put("idPersonne", savedPersonne.getId());
        extraClaims.put("type", savedPersonne.getType());
        String jwtToken = jwtService.generateToken(extraClaims,userDetails);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        Personne personne = personneRepository.findByEmail(request.getEmail()).orElseThrow();
        Map<String, Object> extraClaims = new HashMap<>();
        extraClaims.put("idPersonne", personne.getId());
        extraClaims.put("type", personne.getType());
        UserDetails userDetails = new UserRegistrationDetails(personne);
        String jwtToken = jwtService.generateToken(extraClaims, userDetails);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

}