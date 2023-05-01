package com.example.miniprojetasedsinpt.services;

import com.example.miniprojetasedsinpt.dtos.DetailNonConformiteDTO;
import com.example.miniprojetasedsinpt.entities.DetailNonConformite;
import com.example.miniprojetasedsinpt.exceptions.*;
import com.example.miniprojetasedsinpt.mappers.DetailMapper;
import com.example.miniprojetasedsinpt.repositories.DetailNonConformiteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DetailNonConformiteServiceImpl implements DetailNonConformiteService {
    private final DetailNonConformiteRepository detailNonConformiteRepository;
    private final DetailMapper detailMapper;

    @Override
    public DetailNonConformiteDTO saveDetail(DetailNonConformiteDTO detailDTO) throws ResultatNotFoundException, PersonneNotFoundException, ProduitNotFoundException, PrelevementNotFoundException {
        DetailNonConformite detail = detailMapper.fromDetailNonConformiteDTO(detailDTO);
        DetailNonConformite savedDetail = detailNonConformiteRepository.save(detail);
        return detailMapper.fromDetailNonConformite(savedDetail);
    }

    @Override
    public DetailNonConformiteDTO getDetail(Long id) throws DetailNotFoundException {
        DetailNonConformite detailNonConformite = detailNonConformiteRepository.findById(id)
                .orElseThrow(() -> new DetailNotFoundException("Ce détail n'existe pas"));

        return detailMapper.fromDetailNonConformite(detailNonConformite);
    }

    @Override
    public List<DetailNonConformiteDTO> getAllDetails() {
        List<DetailNonConformite> details = detailNonConformiteRepository.findAll();
        List<DetailNonConformiteDTO> detailNonConformiteDTOS = details.stream()
                .map(detail -> detailMapper.fromDetailNonConformite(detail))
                .collect(Collectors.toList());
        return detailNonConformiteDTOS;
    }
}
