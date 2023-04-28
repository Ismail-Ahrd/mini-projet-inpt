package com.example.miniprojetasedsinpt.services;

import com.example.miniprojetasedsinpt.entities.Personne;
import com.example.miniprojetasedsinpt.entities.Prelevement;
import com.example.miniprojetasedsinpt.entities.ResultatPrelevement;
import com.example.miniprojetasedsinpt.repositories.PersonneRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class PersonneServiceImpl implements PersonneService{
    private final PersonneRepository personneRepository;

@Autowired
    public PersonneServiceImpl(PersonneRepository personneRepository) {
		
		this.personneRepository = personneRepository;
	}

	@Override
    public void savePersonne(Personne p) {
        personneRepository.save(p);
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
