package com.example.miniprojetasedsinpt.repositories;

import com.example.miniprojetasedsinpt.entities.Personne;
import com.example.miniprojetasedsinpt.entities.Prelevement;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PrelevementRepository extends JpaRepository<Prelevement, Long> {
    Page<Prelevement> findByPersonne(Personne personne, Pageable pageable);
    Page<Prelevement> findByProduitNomContains(String keyword, Pageable pageable);
}
