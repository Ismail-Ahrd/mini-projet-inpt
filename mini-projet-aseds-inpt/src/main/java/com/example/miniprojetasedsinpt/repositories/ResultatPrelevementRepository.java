package com.example.miniprojetasedsinpt.repositories;

import com.example.miniprojetasedsinpt.entities.Personne;
import com.example.miniprojetasedsinpt.entities.Prelevement;
import com.example.miniprojetasedsinpt.entities.ResultatPrelevement;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResultatPrelevementRepository extends JpaRepository<ResultatPrelevement, Long> {
    Page<ResultatPrelevement> findByPersonne(Personne personne, Pageable pageable);
    ResultatPrelevement findByPrelevement(Prelevement prelevement);
}
