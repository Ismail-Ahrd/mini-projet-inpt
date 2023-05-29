package com.example.miniprojetasedsinpt.services;

import com.example.miniprojetasedsinpt.dtos.PrelevementDTO;
import com.example.miniprojetasedsinpt.dtos.ResultatPrelevementDTO;
import com.example.miniprojetasedsinpt.dtos.ResultatPrelevementResponseDTO;
import com.example.miniprojetasedsinpt.entities.Personne;
import com.example.miniprojetasedsinpt.entities.Prelevement;
import com.example.miniprojetasedsinpt.entities.ResultatPrelevement;
import com.example.miniprojetasedsinpt.entities.utils.EtatAvancement;
import com.example.miniprojetasedsinpt.exceptions.*;
import com.example.miniprojetasedsinpt.mappers.PersonneMapper;
import com.example.miniprojetasedsinpt.mappers.ResultatPrelevementMapper;
import com.example.miniprojetasedsinpt.repositories.ResultatPrelevementRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ResultatPrelevementServiceImpl implements ResultatPrelevementService {
    private final ResultatPrelevementRepository resultatPrelevementRepository;
    private final ResultatPrelevementMapper resultatPrelevementMapper;
    private final PersonneService personneService;
    private final PersonneMapper personneMapper;
    private final PrelevementService prelevementService;

    @Override
    public ResultatPrelevementDTO saveResultatPrelevement(ResultatPrelevementDTO resultatPrelevementDTO)
            throws PersonneNotFoundException, ProduitNotFoundException, PrelevementNotFoundException, NomOrCategorieIsNullException {
        PrelevementDTO prelevement = prelevementService.getPrelevement(resultatPrelevementDTO.getIdPrelevement());
        prelevement.setEtatAvancement(EtatAvancement.TERMINEE);
        prelevementService.savePrelevement(prelevement);
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
    public ResultatPrelevementResponseDTO getAllResultatPrelevement(int page, int size) {
        Page<ResultatPrelevement> resultatPages =
                resultatPrelevementRepository.findAll(PageRequest.of(page, size));
        List<ResultatPrelevementDTO> resultatPrelevementDTOS = resultatPages.stream()
                .map(resultat -> resultatPrelevementMapper.fromResultatPrelevement(resultat))
                .collect(Collectors.toList());
        ResultatPrelevementResponseDTO resultatPrelevementResponseDTO = new ResultatPrelevementResponseDTO();
        resultatPrelevementResponseDTO.setResultatPrelevementDTOS(resultatPrelevementDTOS);
        resultatPrelevementResponseDTO.setCurrentPage(page);
        resultatPrelevementResponseDTO.setTotalPages(resultatPages.getTotalPages());
        resultatPrelevementResponseDTO.setPageSize(size);

        return resultatPrelevementResponseDTO;
    }

    @Override
    public ResultatPrelevementResponseDTO getAllResultatPrelevementByPersonne(
            Long idPersonne, int page, int size) throws PersonneNotFoundException {
        Personne personne = personneMapper.fromPersonneDTO(personneService.getPersonne(idPersonne));
        Page<ResultatPrelevement> resultatPages =
                resultatPrelevementRepository.findByPersonne(personne, PageRequest.of(page, size));

        List<ResultatPrelevementDTO> resultatPrelevementDTOS = resultatPages.stream()
                .map(resultat -> {
                    ResultatPrelevementDTO resultatPrelevement =
                            resultatPrelevementMapper.fromResultatPrelevement(resultat);
                    PrelevementDTO prelevement = null;
                    try {
                        prelevement = prelevementService.getPrelevement(resultatPrelevement.getIdPrelevement());
                    } catch (PrelevementNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                    resultatPrelevement.setNomProduit(prelevement.getProduitDTO().getNom());
                    return resultatPrelevement;
                })
                .collect(Collectors.toList());

        ResultatPrelevementResponseDTO resultatPrelevementResponseDTO = new ResultatPrelevementResponseDTO();
        resultatPrelevementResponseDTO.setResultatPrelevementDTOS(resultatPrelevementDTOS);
        resultatPrelevementResponseDTO.setCurrentPage(page);
        resultatPrelevementResponseDTO.setTotalPages(resultatPages.getTotalPages());
        resultatPrelevementResponseDTO.setPageSize(size);

        return resultatPrelevementResponseDTO;
    }
}
