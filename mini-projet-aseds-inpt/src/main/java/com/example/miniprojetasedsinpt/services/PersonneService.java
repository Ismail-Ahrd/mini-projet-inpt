package com.example.miniprojetasedsinpt.services;

import com.example.miniprojetasedsinpt.entities.Personne;

import java.util.List;

public interface PersonneService {
    void savePersonne(Personne p);
    Personne getPersonne(Long id);
    List<Personne> getAllPersonnes();
}
