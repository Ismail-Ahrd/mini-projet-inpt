package com.example.miniprojetasedsinpt.services;

import com.example.miniprojetasedsinpt.entities.Prelevement;
import com.example.miniprojetasedsinpt.repositories.PrelevementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PrelevementServiceImpl implements PrelevementService {
    private final PrelevementRepository prelevementrepository;

    @Override
    public Prelevement savePrelevement(Prelevement prelevement) {
        return prelevementrepository.save(prelevement);
    }

    @Override
    public Prelevement getPrelevement(Long id) {
        return prelevementrepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Ce prelevement n'existe pas"));
    }

    @Override
    public void deletePrelevement(long id) {
        if(prelevementrepository.findById(id)==null) {
            throw new IllegalArgumentException("Ce prelevement n'existe pas");

        }
        else {
            prelevementrepository.deleteById(id);;
        }
    }

    @Override
    public List<Prelevement> getAllPrelevement() {
        return prelevementrepository.findAll();
    }
}
