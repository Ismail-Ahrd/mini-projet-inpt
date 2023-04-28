package com.example.miniprojetasedsinpt.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.miniprojetasedsinpt.entities.Produit;
import com.example.miniprojetasedsinpt.repositories.ProduitRepository;
@Service
public class ProduitServiceImpl implements ProduitService {
    private final ProduitRepository produitRepository;
public  ProduitServiceImpl(ProduitRepository produitRepository) {
	this.produitRepository=produitRepository;
}

    public Produit saveProduit(Produit produit) {
        return produitRepository.save(produit);
    }

    
    public Produit getProduit(Long id) {
        return produitRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Ce produit n'existe pas"));
    }

    public List<Produit> getAllProduit() {
        return produitRepository.findAll();
    }

}
