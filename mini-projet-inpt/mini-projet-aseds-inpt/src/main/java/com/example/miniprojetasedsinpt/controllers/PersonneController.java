package com.example.miniprojetasedsinpt.controllers;

import com.example.miniprojetasedsinpt.controllers.utils.PersonneRequest;
import com.example.miniprojetasedsinpt.entities.Personne;
import com.example.miniprojetasedsinpt.services.PersonneService;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200/")
@RestController

@RequestMapping("/personnes")
public class PersonneController {
    private final PersonneService personneService;
@Autowired
    public PersonneController(PersonneService personneService) {
		this.personneService = personneService;
	}
	@GetMapping
    public List<Personne> getAllPersonnes() {
        return personneService.getAllPersonnes();
    }
    @GetMapping("/{id}")
    public Object getPersonne(@PathVariable Long id) {
        return 	personneService.getPersonne(id) ;
    }
    @PostMapping
    public void save( @RequestBody PersonneRequest personneRequest) {
        Personne personne=new Personne();
        personne.setNom(personneRequest.getNom());
        personne.setPrenom(personneRequest.getPrenom());
        personne.setType(personneRequest.getType());
        personne.setEmail(personneRequest.getEmail());
        personne.setMdp(personneRequest.getMdp());
    	personneService.savePersonne(personne);
    	
    }
}
