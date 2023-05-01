package com.example.miniprojetasedsinpt.controllers;

import com.example.miniprojetasedsinpt.dtos.PrelevementDTO;
import com.example.miniprojetasedsinpt.exceptions.PersonneNotFoundException;
import com.example.miniprojetasedsinpt.exceptions.PrelevementNotFoundException;
import com.example.miniprojetasedsinpt.exceptions.ProduitNotFoundException;
import com.example.miniprojetasedsinpt.services.PersonneService;
import com.example.miniprojetasedsinpt.services.PrelevementService;
import com.example.miniprojetasedsinpt.services.ProduitService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/prelevement")
public class PrelevementController {
    private final PrelevementService prelevementSrevice;
    private final PersonneService personneService;
    private final ProduitService produitService;

    @GetMapping
    public List<PrelevementDTO> getAllPrelevement() {
        return prelevementSrevice.getAllPrelevement();
    }

    @GetMapping("/{id}")
    public PrelevementDTO getPrelevement(@PathVariable Long id)
            throws PrelevementNotFoundException {
        return prelevementSrevice.getPrelevement(id);

    }

    @PostMapping
    public PrelevementDTO savePrelevement(@RequestBody PrelevementDTO prelevementDTO)
            throws PersonneNotFoundException, ProduitNotFoundException
    {
        return prelevementSrevice.savePrelevement(prelevementDTO);
    }

    @GetMapping("/personne/{idPersonne}")
    public List<PrelevementDTO> getAllPrelevementByPersonne(@PathVariable Long idPersonne) throws
            PersonneNotFoundException
    {
        return prelevementSrevice.getAllPrelevementByPersonne(idPersonne);
    }

}
