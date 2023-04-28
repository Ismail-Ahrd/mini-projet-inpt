package com.example.miniprojetasedsinpt.services;

import com.example.miniprojetasedsinpt.entities.DetailNonConformite;

import java.util.List;

public interface DetailNonConformiteService {
    void saveDetail(DetailNonConformite detail);
    DetailNonConformite getDetail(Long id);
    List<DetailNonConformite> getAllDetails();
}
