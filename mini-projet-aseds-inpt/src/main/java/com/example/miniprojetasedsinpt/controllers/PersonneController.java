package com.example.miniprojetasedsinpt.controllers;

import com.example.miniprojetasedsinpt.dtos.PersonneDTO;
import com.example.miniprojetasedsinpt.exceptions.PersonneNotFoundException;
import com.example.miniprojetasedsinpt.services.PersonneService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/personne")
public class PersonneController {
    private final PersonneService personneService;

    @GetMapping
    public List<PersonneDTO> getAllPersonnes() {
        return personneService.getAllPersonnes();
    }

    @GetMapping("/{id}")
    public PersonneDTO getPersonne(@PathVariable Long id) throws PersonneNotFoundException {
        return 	personneService.getPersonne(id) ;
    }

    @PostMapping
    public PersonneDTO savePersonne(@RequestBody PersonneDTO personneDTO) {
        return personneService.savePersonne(personneDTO);
    }

}
