package com.example.miniprojetasedsinpt.controllers;

import com.example.miniprojetasedsinpt.controllers.utils.ProduitRequest;
import com.example.miniprojetasedsinpt.entities.Prelevement;
import com.example.miniprojetasedsinpt.entities.Produit;
import com.example.miniprojetasedsinpt.services.ProduitService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/produit")
public class ProduitController {
    private ProduitService produitService;

    @GetMapping
    public List<Produit> getAllProduit() {
        return produitService.getAllProduit();
    }

    @GetMapping("/{id}")
    public Produit getPrelevement(@PathVariable Long id) {
        return 	produitService.getProduit(id);
    }

    @PostMapping
    public Produit saveProduit(@RequestBody ProduitRequest produitRequest){
        Produit produit = new Produit();
        produit.setNom(produitRequest.getNom());
        produit.setCategorie(produitRequest.getCategorie());
        return produitService.saveProduit(produit);
    }
}
