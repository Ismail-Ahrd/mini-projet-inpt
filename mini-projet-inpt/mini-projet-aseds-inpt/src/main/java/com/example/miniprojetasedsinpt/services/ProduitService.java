package com.example.miniprojetasedsinpt.services;

import java.util.List;

import com.example.miniprojetasedsinpt.entities.Produit;

public interface ProduitService {
	Produit saveProduit(Produit produit);
    Produit getProduit(Long id);
    List<Produit> getAllProduit();
}
