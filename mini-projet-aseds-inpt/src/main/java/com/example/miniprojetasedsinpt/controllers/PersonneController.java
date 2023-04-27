package com.example.miniprojetasedsinpt.controllers;

import com.example.miniprojetasedsinpt.entities.Personne;
import com.example.miniprojetasedsinpt.services.PersonneService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/personnes")
public class PersonneController {
    private final PersonneService personneService;

    @GetMapping
    public List<Personne> getAllPersonnes() {
        return personneService.getAllPersonnes();
    }
    @GetMapping("/{id}")
    public Object getPersonne(@PathVariable Long id) {
        return 	personneService.getPersonne(id) ;
    }
    @PostMapping
    public void register( @RequestBody Personne p) {
        personneService.savePersonne(p);
    }
}
