package com.example.miniprojetasedsinpt.mappers;

import com.example.miniprojetasedsinpt.dtos.PrelevementDTO;
import com.example.miniprojetasedsinpt.entities.Personne;
import com.example.miniprojetasedsinpt.entities.Prelevement;
import com.example.miniprojetasedsinpt.entities.Produit;
import com.example.miniprojetasedsinpt.exceptions.PersonneNotFoundException;
import com.example.miniprojetasedsinpt.exceptions.ProduitNotFoundException;
import com.example.miniprojetasedsinpt.services.PersonneService;
import com.example.miniprojetasedsinpt.services.ProduitService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PrelevementMapper {
    private final PersonneService personneService;
    private final PersonneMapper personneMapper;
    private final ProduitMapper produitMapper;
    private final ProduitService produitService;

    public PrelevementDTO fromPrelevement(Prelevement prelevement) {
        PrelevementDTO prelevementDTO = new PrelevementDTO();
        BeanUtils.copyProperties(prelevement, prelevementDTO);
        prelevementDTO.setIdPersonne(prelevement.getPersonne().getId());
        prelevementDTO.setIdProduit(prelevement.getProduit().getId());
        return prelevementDTO;
    }

    public Prelevement fromPrelevementDTO(PrelevementDTO prelevementDTO)
            throws PersonneNotFoundException, ProduitNotFoundException
    {
        Prelevement prelevement = new Prelevement();
        BeanUtils.copyProperties(prelevementDTO, prelevement);
        Personne personne = personneMapper.fromPersonneDTO(
                personneService.getPersonne(prelevementDTO.getIdPersonne()));
        prelevement.setPersonne(personne);
        Produit produit = produitMapper.fromProduitDTO(
                produitService.getProduit(prelevementDTO.getIdProduit()));
        prelevement.setProduit(produit);
        return prelevement;
    }

}
