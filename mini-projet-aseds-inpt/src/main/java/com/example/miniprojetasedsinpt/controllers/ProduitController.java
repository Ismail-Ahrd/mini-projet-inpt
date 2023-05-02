package com.example.miniprojetasedsinpt.controllers;

import com.example.miniprojetasedsinpt.dtos.ProduitDTO;
import com.example.miniprojetasedsinpt.exceptions.ProduitNotFoundException;
import com.example.miniprojetasedsinpt.services.ProduitService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/produit")
@CrossOrigin("*")
public class ProduitController {
    private final ProduitService produitService;


    @GetMapping
    public List<ProduitDTO> getAllProduit() {
        return produitService.getAllProduit();
    }

    @GetMapping("/{id}")
    public ProduitDTO getPrelevement(@PathVariable Long id) throws ProduitNotFoundException {
        return 	produitService.getProduit(id);
    }

    @PostMapping
    public ProduitDTO saveProduit(@RequestBody ProduitDTO produitDTO) {
        return produitService.saveProduit(produitDTO);
    }

}
