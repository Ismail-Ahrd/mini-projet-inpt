package com.example.miniprojetasedsinpt.services;

import com.example.miniprojetasedsinpt.entities.Prelevement;

import java.util.List;

public interface PrelevementService {
    void savePrelevement(Prelevement prelevement);
    Prelevement getPrelevement(Long id);
    void deletePrelevement(long id);
    List<Prelevement> getAllPrelevement();
}
