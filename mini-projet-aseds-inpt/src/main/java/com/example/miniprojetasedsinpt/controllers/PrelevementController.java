package com.example.miniprojetasedsinpt.controllers;

import com.example.miniprojetasedsinpt.dtos.PrelevementDTO;
import com.example.miniprojetasedsinpt.dtos.PrelevementResponseDTO;
import com.example.miniprojetasedsinpt.entities.utils.EtatAvancement;
import com.example.miniprojetasedsinpt.exceptions.NomOrCategorieIsNullException;
import com.example.miniprojetasedsinpt.exceptions.PersonneNotFoundException;
import com.example.miniprojetasedsinpt.exceptions.PrelevementNotFoundException;
import com.example.miniprojetasedsinpt.exceptions.ProduitNotFoundException;
import com.example.miniprojetasedsinpt.services.PrelevementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/prelevement")
@CrossOrigin("*")
public class PrelevementController {
    private final PrelevementService prelevementSrevice;

    @GetMapping()
    public ResponseEntity<PrelevementResponseDTO> getAllPrelevement(
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "5") int size,
            @RequestParam(name = "keyword", defaultValue = "") String keyword,
            @RequestParam(name = "etat", defaultValue = "") EtatAvancement etatAvancement
            ) {
        PrelevementResponseDTO allPrelevement =
                prelevementSrevice.getAllPrelevement(keyword, etatAvancement, page, size);
        HttpHeaders headers = new HttpHeaders();
        headers.set("Access-Control-Allow-Origin", "http://localhost:4200");
        return new ResponseEntity<>(allPrelevement, headers, HttpStatus.OK);
    }

    /*try {
        List<Prelevement> prelevements = new ArrayList<Prelevement>();

        // TODO: Populate the list of prelevements based on the provided parameters

        HttpHeaders headers = new HttpHeaders();
        headers.set("Access-Control-Allow-Origin", "http://localhost:4200");

        return new ResponseEntity<>(prelevements, headers, HttpStatus.OK);
    } catch (Exception e) {
        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }*/

    @GetMapping("/{id}")
    public PrelevementDTO getPrelevement(@PathVariable Long id)
            throws PrelevementNotFoundException {
        return prelevementSrevice.getPrelevement(id);

    }

    @PostMapping
    public PrelevementDTO savePrelevement(@RequestBody PrelevementDTO prelevementDTO)
            throws PersonneNotFoundException, ProduitNotFoundException, NomOrCategorieIsNullException {
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
