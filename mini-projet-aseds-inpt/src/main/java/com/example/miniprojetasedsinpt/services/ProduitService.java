package com.example.miniprojetasedsinpt.services;

import com.example.miniprojetasedsinpt.entities.Produit;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProduitService {

    Produit saveProduit(Produit produit);
    Produit getProduit(Long id);
    List<Produit> getAllProduit();
}
