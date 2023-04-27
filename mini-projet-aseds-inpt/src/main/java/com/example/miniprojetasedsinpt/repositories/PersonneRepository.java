package com.example.miniprojetasedsinpt.repositories;

import com.example.miniprojetasedsinpt.entities.Personne;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonneRepository extends JpaRepository<Personne, Long> {
}
