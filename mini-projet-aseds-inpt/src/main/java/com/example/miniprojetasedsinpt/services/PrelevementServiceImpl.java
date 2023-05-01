package com.example.miniprojetasedsinpt.services;

import com.example.miniprojetasedsinpt.dtos.PersonneDTO;
import com.example.miniprojetasedsinpt.dtos.PrelevementDTO;
import com.example.miniprojetasedsinpt.entities.Personne;
import com.example.miniprojetasedsinpt.entities.Prelevement;
import com.example.miniprojetasedsinpt.exceptions.PersonneNotFoundException;
import com.example.miniprojetasedsinpt.exceptions.PrelevementNotFoundException;
import com.example.miniprojetasedsinpt.exceptions.ProduitNotFoundException;
import com.example.miniprojetasedsinpt.mappers.PersonneMapper;
import com.example.miniprojetasedsinpt.mappers.PrelevementMapper;
import com.example.miniprojetasedsinpt.repositories.PersonneRepository;
import com.example.miniprojetasedsinpt.repositories.PrelevementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PrelevementServiceImpl implements PrelevementService {
    private final PrelevementRepository prelevementrepository;
    private final PrelevementMapper prelevementMapper;
    private final PersonneService personneService;
    private final PersonneMapper personneMapper;
    private final PersonneRepository personneRepository;

    @Override
    public PrelevementDTO savePrelevement(PrelevementDTO prelevementDTO) throws PersonneNotFoundException, ProduitNotFoundException {
        Prelevement prelevement = prelevementMapper.fromPrelevementDTO(prelevementDTO);
        /*PersonneDTO personneDTO = personneService.getPersonne(prelevementDTO.getIdPersonne());
        Personne personne = personneMapper.fromPersonneDTO(personneDTO);
        personne.getPrelevements().add(prelevement);
        personneRepository.save(personne);*/
        Prelevement savedPrelevement = prelevementrepository.save(prelevement);
        return prelevementMapper.fromPrelevement(savedPrelevement);
    }

    @Override
    public PrelevementDTO getPrelevement(Long id) throws PrelevementNotFoundException {
        Prelevement prelevement = prelevementrepository.findById(id)
                .orElseThrow(() -> new PrelevementNotFoundException("Ce prelevement n'existe pas"));
        return prelevementMapper.fromPrelevement(prelevement);
    }

    @Override
    public void deletePrelevement(long id) throws PrelevementNotFoundException {
        prelevementrepository.findById(id).orElseThrow(() ->
                new PrelevementNotFoundException("Ce prelevement n'existe pas"));
        prelevementrepository.deleteById(id);
    }

    @Override
    public List<PrelevementDTO> getAllPrelevement() {
        List<Prelevement> prelevements = prelevementrepository.findAll();
        List<PrelevementDTO> prelevementDTOS = prelevements.stream()
                .map(prelevement -> prelevementMapper.fromPrelevement(prelevement))
                .collect(Collectors.toList());
        return prelevementDTOS;
    }

    @Override
    public List<PrelevementDTO> getAllPrelevementByPersonne(Long idPersonne)
            throws PersonneNotFoundException {
        PersonneDTO personneDTO = personneService.getPersonne(idPersonne);
        Personne personne = personneMapper.fromPersonneDTO(personneDTO);
        /*List<PrelevementDTO> prelevementDTOS = personne.getPrelevements().stream()
                .map(prelevement -> prelevementMapper.fromPrelevement(prelevement))
                .collect(Collectors.toList());*/
        List<Prelevement> prelevements = prelevementrepository.findByPersonne(personne);
        List<PrelevementDTO> prelevementDTOS = prelevements.stream()
                .map(prelevement -> prelevementMapper.fromPrelevement(prelevement))
                .collect(Collectors.toList());
        return prelevementDTOS;
    }
}
