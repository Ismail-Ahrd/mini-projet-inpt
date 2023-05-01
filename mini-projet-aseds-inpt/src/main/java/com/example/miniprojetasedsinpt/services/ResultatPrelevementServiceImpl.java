package com.example.miniprojetasedsinpt.services;

import com.example.miniprojetasedsinpt.dtos.ResultatPrelevementDTO;
import com.example.miniprojetasedsinpt.entities.Prelevement;
import com.example.miniprojetasedsinpt.entities.ResultatPrelevement;
import com.example.miniprojetasedsinpt.exceptions.PersonneNotFoundException;
import com.example.miniprojetasedsinpt.exceptions.PrelevementNotFoundException;
import com.example.miniprojetasedsinpt.exceptions.ProduitNotFoundException;
import com.example.miniprojetasedsinpt.exceptions.ResultatNotFoundException;
import com.example.miniprojetasedsinpt.mappers.ResultatPrelevementMapper;
import com.example.miniprojetasedsinpt.repositories.ResultatPrelevementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ResultatPrelevementServiceImpl implements ResultatPrelevementService {
    private final ResultatPrelevementRepository resultatPrelevementRepository;
    private final ResultatPrelevementMapper resultatPrelevementMapper;

    @Override
    public ResultatPrelevementDTO saveResultatPrelevement(ResultatPrelevementDTO resultatPrelevementDTO)
            throws PersonneNotFoundException, ProduitNotFoundException, PrelevementNotFoundException
    {
        ResultatPrelevement resultatPrelevement =
                resultatPrelevementMapper.fromResultatPrelevementDTO(resultatPrelevementDTO);
        ResultatPrelevement savedResultat = resultatPrelevementRepository.save(resultatPrelevement);
        return resultatPrelevementMapper.fromResultatPrelevement(savedResultat);
    }

    @Override
    public ResultatPrelevementDTO getResultatPrelevement(Long id)
            throws ResultatNotFoundException
    {
        ResultatPrelevement resultatPrelevement =
                resultatPrelevementRepository.findById(id).orElseThrow(() ->
                new ResultatNotFoundException("Ce resultat de prelevement n'existe pas"));
        return resultatPrelevementMapper.fromResultatPrelevement(resultatPrelevement);
    }

    @Override
    public void deleteResultatPrelevement(long id) throws ResultatNotFoundException {
        resultatPrelevementRepository.findById(id).orElseThrow(() ->
            new ResultatNotFoundException("Ce resultat de  prelevement n'existe pas")
        );
        resultatPrelevementRepository.deleteById(id);
    }

    @Override
    public List<ResultatPrelevementDTO> getAllResultatPrelevement() {
        List<ResultatPrelevement> resultats = resultatPrelevementRepository.findAll();
        List<ResultatPrelevementDTO> resultatPrelevementDTOS = resultats.stream()
                .map(resultat -> resultatPrelevementMapper.fromResultatPrelevement(resultat))
                .collect(Collectors.toList());
        return resultatPrelevementDTOS;
    }
}
