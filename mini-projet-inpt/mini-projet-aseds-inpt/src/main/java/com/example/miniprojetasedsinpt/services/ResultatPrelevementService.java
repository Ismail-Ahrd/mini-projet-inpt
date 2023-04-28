package com.example.miniprojetasedsinpt.services;

import com.example.miniprojetasedsinpt.entities.ResultatPrelevement;

import java.util.List;

public interface ResultatPrelevementService {

    void saveResultatPrelevement(ResultatPrelevement resultatPrelevement);
    ResultatPrelevement getResultatPrelevement(Long id);
    void deleteResultatPrelevement(long id);
    List<ResultatPrelevement> getAllResultatPrelevement();
}
