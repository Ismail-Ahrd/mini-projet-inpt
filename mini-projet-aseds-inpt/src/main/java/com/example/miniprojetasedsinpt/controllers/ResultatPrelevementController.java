package com.example.miniprojetasedsinpt.controllers;

import com.example.miniprojetasedsinpt.dtos.ResultatPrelevementDTO;
import com.example.miniprojetasedsinpt.dtos.ResultatPrelevementResponseDTO;
import com.example.miniprojetasedsinpt.exceptions.PersonneNotFoundException;
import com.example.miniprojetasedsinpt.exceptions.PrelevementNotFoundException;
import com.example.miniprojetasedsinpt.exceptions.ProduitNotFoundException;
import com.example.miniprojetasedsinpt.exceptions.ResultatNotFoundException;
import com.example.miniprojetasedsinpt.services.PersonneService;
import com.example.miniprojetasedsinpt.services.PrelevementService;
import com.example.miniprojetasedsinpt.services.ResultatPrelevementService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/resultatPrelevement")
@CrossOrigin("*")
public class ResultatPrelevementController {
    private final ResultatPrelevementService resultatPrelevementService;
    private final PersonneService personneService;
    private final PrelevementService prelevementService;

    @GetMapping
    public ResultatPrelevementResponseDTO getAllPrelevement(
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "5") int size
    ) {
        return resultatPrelevementService.getAllResultatPrelevement(page, size);
    }

    @GetMapping("/personne/{idPersonne}")
    public ResultatPrelevementResponseDTO getAllPrelevementByPersonne(
            @PathVariable Long idPersonne,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "5") int size) throws PersonneNotFoundException
    {
        return resultatPrelevementService.getAllResultatPrelevementByPersonne(idPersonne, page, size);
    }

    @GetMapping("/{id}")
    public ResultatPrelevementDTO getResultatPrelevement(@PathVariable Long id)
            throws ResultatNotFoundException
    {
        return resultatPrelevementService.getResultatPrelevement(id);
    }

    @PostMapping
    public ResultatPrelevementDTO saveResultatPrelevement(
            @RequestBody ResultatPrelevementDTO resultatPrelevementDTO
    ) throws PersonneNotFoundException, ProduitNotFoundException, PrelevementNotFoundException
    {
        return resultatPrelevementService.saveResultatPrelevement(resultatPrelevementDTO);
    }

    @DeleteMapping("{id}")
    public void deleteResultatPrelevement(@PathVariable Long id) throws ResultatNotFoundException {
        resultatPrelevementService.deleteResultatPrelevement(id);
    }

}
