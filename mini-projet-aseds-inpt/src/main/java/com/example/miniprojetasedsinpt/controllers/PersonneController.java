package com.example.miniprojetasedsinpt.controllers;

import com.example.miniprojetasedsinpt.dtos.PersonneDTO;
import com.example.miniprojetasedsinpt.entities.Personne;
import com.example.miniprojetasedsinpt.exceptions.PersonneNotFoundException;
import com.example.miniprojetasedsinpt.repositories.PersonneRepository;
import com.example.miniprojetasedsinpt.security.AuthenticationRequest;
import com.example.miniprojetasedsinpt.services.PersonneService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/personne")
@CrossOrigin("*")
@Slf4j
public class PersonneController {
    private final PersonneService personneService;
    private final PersonneRepository personneRepository;

    @GetMapping
    public List<PersonneDTO> getAllPersonnes() {
        return personneService.getAllPersonnes();
    }

    @GetMapping("/{id}")
    public PersonneDTO getPersonne(@PathVariable Long id) throws PersonneNotFoundException {
        return personneService.getPersonne(id) ;
    }

    @PostMapping
    public PersonneDTO savePersonne(@RequestBody PersonneDTO personneDTO) {
        return personneService.savePersonne(personneDTO);
    }

}
