package com.example.miniprojetasedsinpt.controllers;

import com.example.miniprojetasedsinpt.dtos.PrelevementDTO;
import com.example.miniprojetasedsinpt.dtos.PrelevementResponseDTO;
import com.example.miniprojetasedsinpt.exceptions.PersonneNotFoundException;
import com.example.miniprojetasedsinpt.exceptions.PrelevementNotFoundException;
import com.example.miniprojetasedsinpt.exceptions.ProduitNotFoundException;
import com.example.miniprojetasedsinpt.services.PrelevementService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/prelevement")
@CrossOrigin("*")
public class PrelevementController {
    private final PrelevementService prelevementSrevice;

    @GetMapping()
    public PrelevementResponseDTO getAllPrelevement(
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "5") int size,
            @RequestParam(name = "keyword", defaultValue = "") String keyword
    ) {
        return prelevementSrevice.getAllPrelevement(keyword, page, size);
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
    public PrelevementResponseDTO getAllPrelevementByPersonne(
            @PathVariable Long idPersonne,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "5") int size) throws PersonneNotFoundException
    {
        return prelevementSrevice.getAllPrelevementByPersonne(idPersonne, page, size);
    }

    @DeleteMapping("{id}")
    public void deletePrelevement(@PathVariable int id) throws PrelevementNotFoundException {
        prelevementSrevice.deletePrelevement(id);
    }


}
