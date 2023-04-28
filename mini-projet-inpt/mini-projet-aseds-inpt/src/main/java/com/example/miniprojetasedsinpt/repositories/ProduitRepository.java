package com.example.miniprojetasedsinpt.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.miniprojetasedsinpt.entities.Produit;

public interface ProduitRepository extends JpaRepository<Produit, Long> {

}
