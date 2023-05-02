package com.example.miniprojetasedsinpt.services;

import com.example.miniprojetasedsinpt.dtos.PrelevementDTO;
import com.example.miniprojetasedsinpt.dtos.PrelevementResponseDTO;
import com.example.miniprojetasedsinpt.entities.Prelevement;
import com.example.miniprojetasedsinpt.exceptions.PersonneNotFoundException;
import com.example.miniprojetasedsinpt.exceptions.PrelevementNotFoundException;
import com.example.miniprojetasedsinpt.exceptions.ProduitNotFoundException;

import java.util.List;

public interface PrelevementService {
    PrelevementDTO savePrelevement(PrelevementDTO prelevementDTO) throws PersonneNotFoundException, ProduitNotFoundException;
    PrelevementDTO getPrelevement(Long id) throws PrelevementNotFoundException;
    void deletePrelevement(long id) throws PrelevementNotFoundException;
    PrelevementResponseDTO getAllPrelevement(String kw , int page,int size);
    PrelevementResponseDTO getAllPrelevementByPersonne(Long idPersonne, int page, int size) throws PersonneNotFoundException;
}
