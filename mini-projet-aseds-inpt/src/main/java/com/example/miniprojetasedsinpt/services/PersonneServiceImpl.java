package com.example.miniprojetasedsinpt.services;

import com.example.miniprojetasedsinpt.entities.Personne;
import com.example.miniprojetasedsinpt.repositories.PersonneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonneServiceImpl implements PersonneService{
    private final PersonneRepository personneRepository;


    @Override
    public Personne savePersonne(Personne p) {
        return personneRepository.save(p);
    }

    @Override
    public Personne getPersonne(Long id) {
        return personneRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Ce compte n'existe pas"));
    }

    @Override
    public List<Personne> getAllPersonnes() {
        return personneRepository.findAll();
    }
}
