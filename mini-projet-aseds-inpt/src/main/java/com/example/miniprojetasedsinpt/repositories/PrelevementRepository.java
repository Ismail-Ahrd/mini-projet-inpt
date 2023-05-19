package com.example.miniprojetasedsinpt.repositories;

import com.example.miniprojetasedsinpt.entities.Personne;
import com.example.miniprojetasedsinpt.entities.Prelevement;
import com.example.miniprojetasedsinpt.entities.utils.EtatAvancement;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PrelevementRepository extends JpaRepository<Prelevement, Long> {
    Page<Prelevement> findByPersonne(Personne personne, Pageable pageable);
    Page<Prelevement> findByProduitNomContains(String keyword, Pageable pageable);
    Page<Prelevement> findByEtatAvancement(EtatAvancement etatAvancement, Pageable pageable);
    Page<Prelevement> findByProduitNomContainsAndEtatAvancement(String keyword, EtatAvancement etatAvancement, Pageable pageable);
    Page<Prelevement> findByPersonneAndProduitNomContainsAndEtatAvancement(
            Personne personne, String kw, EtatAvancement etatAvancement, Pageable pageable);
    Page<Prelevement> findByPersonneAndProduitNomContains(Personne personne, String kw, Pageable pageable);
}
