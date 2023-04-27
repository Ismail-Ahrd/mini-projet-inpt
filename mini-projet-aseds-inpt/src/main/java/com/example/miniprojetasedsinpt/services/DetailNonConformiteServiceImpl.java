package com.example.miniprojetasedsinpt.services;

import com.example.miniprojetasedsinpt.entities.DetailNonConformite;
import com.example.miniprojetasedsinpt.repositories.DetailNonConformiteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DetailNonConformiteServiceImpl implements DetailNonConformiteService {
    private final DetailNonConformiteRepository detailNonConformiteRepository;

    @Override
    public void saveDetail(DetailNonConformite detail) {
        if(detailNonConformiteRepository.findById(detail.getId())!=null) {
            throw new IllegalArgumentException("Ce detail est déjà enregistré");
        }
        else {
            detailNonConformiteRepository.save(detail);
        }
    }

    @Override
    public DetailNonConformite getDetail(Long id) {
        return detailNonConformiteRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Ce détail n'existe pas"));
    }

    @Override
    public List<DetailNonConformite> getAllDetails() {
        return detailNonConformiteRepository.findAll();
    }
}
