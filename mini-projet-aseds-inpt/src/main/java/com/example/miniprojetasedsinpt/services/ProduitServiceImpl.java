package com.example.miniprojetasedsinpt.services;

import com.example.miniprojetasedsinpt.entities.Produit;
import com.example.miniprojetasedsinpt.repositories.ProduitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProduitServiceImpl implements ProduitService {
    private final ProduitRepository produitRepository;

    @Override
    public Produit saveProduit(Produit produit) {
        return produitRepository.save(produit);
    }

    @Override
    public Produit getProduit(Long id) {
        return produitRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Ce produit n'existe pas"));
    }

    @Override
    public List<Produit> getAllProduit() {
        return produitRepository.findAll();
    }
}
