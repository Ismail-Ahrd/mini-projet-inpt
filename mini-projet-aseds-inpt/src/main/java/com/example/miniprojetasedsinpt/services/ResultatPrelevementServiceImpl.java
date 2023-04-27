package com.example.miniprojetasedsinpt.services;

import com.example.miniprojetasedsinpt.entities.ResultatPrelevement;
import com.example.miniprojetasedsinpt.repositories.ResultatPrelevementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Service
@RequiredArgsConstructor
@RequestMapping("/resultatPrelevement")
public class ResultatPrelevementServiceImpl implements ResultatPrelevementService {
    private final ResultatPrelevementRepository resultatPrelevementRepository;

    @Override
    public void saveResultatPrelevement(ResultatPrelevement resultatPrelevement) {
        resultatPrelevementRepository.save(resultatPrelevement);
    }

    @Override
    public ResultatPrelevement getResultatPrelevement(Long id) {
        return resultatPrelevementRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Ce resultat de prelevement n'existe pas"));
    }

    @Override
    public void deleteResultatPrelevement(long id) {
        if(resultatPrelevementRepository.findById(id)==null) {
            throw new IllegalArgumentException("Ce resultat de  prelevement n'existe pas");

        }
        else {
            resultatPrelevementRepository.deleteById(id);;
        }
    }

    @Override
    public List<ResultatPrelevement> getAllResultatPrelevement() {
        return resultatPrelevementRepository.findAll();
    }
}
