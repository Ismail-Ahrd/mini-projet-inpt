package com.example.miniprojetasedsinpt.controllers;

import com.example.miniprojetasedsinpt.controllers.utils.PersonneRequest;
import com.example.miniprojetasedsinpt.entities.Personne;
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
    public List<Personne> getAllPersonnes() {
        return personneService.getAllPersonnes();
    }
    @GetMapping("/{id}")
    public Personne getPersonne(@PathVariable Long id) {
        return 	personneService.getPersonne(id) ;
    }

    @PostMapping
    public Personne register( @RequestBody PersonneRequest personneRequest) {
        Personne personne = new Personne();
        personne.setNom(personneRequest.getNom());
        personne.setPrenom(personneRequest.getPrenom());
        personne.setType(personneRequest.getType());
        personne.setEmail(personneRequest.getEmail());
        personne.setMdp(personneRequest.getMdp());

        return personneService.savePersonne(personne);
    }
}
