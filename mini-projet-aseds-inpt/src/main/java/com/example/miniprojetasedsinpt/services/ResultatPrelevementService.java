package com.example.miniprojetasedsinpt.services;

import com.example.miniprojetasedsinpt.dtos.ResultatPrelevementDTO;
import com.example.miniprojetasedsinpt.entities.ResultatPrelevement;
import com.example.miniprojetasedsinpt.exceptions.PersonneNotFoundException;
import com.example.miniprojetasedsinpt.exceptions.PrelevementNotFoundException;
import com.example.miniprojetasedsinpt.exceptions.ProduitNotFoundException;
import com.example.miniprojetasedsinpt.exceptions.ResultatNotFoundException;

import java.util.List;

public interface ResultatPrelevementService {

    ResultatPrelevementDTO saveResultatPrelevement(ResultatPrelevementDTO resultatPrelevement) throws PersonneNotFoundException, ProduitNotFoundException, PrelevementNotFoundException;
    ResultatPrelevementDTO getResultatPrelevement(Long id) throws ResultatNotFoundException;
    void deleteResultatPrelevement(long id) throws ResultatNotFoundException;
    List<ResultatPrelevementDTO> getAllResultatPrelevement();
}
