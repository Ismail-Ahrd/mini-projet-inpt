package com.example.miniprojetasedsinpt.controllers;

import com.example.miniprojetasedsinpt.dtos.DetailNonConformiteDTO;
import com.example.miniprojetasedsinpt.exceptions.*;
import com.example.miniprojetasedsinpt.services.DetailNonConformiteService;
import com.example.miniprojetasedsinpt.services.ResultatPrelevementService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("detailNonConformite")
@CrossOrigin("*")
@SecurityRequirement(name = "api")
public class DetailNonConformiteController {
    private final DetailNonConformiteService detailNonConformiteService;
    private final ResultatPrelevementService resultatPrelevementService;
    @GetMapping
    public List<DetailNonConformiteDTO> getAllDetails() {
        return detailNonConformiteService.getAllDetails();
    }

    @GetMapping("/{id}")
    public DetailNonConformiteDTO getDetail(@PathVariable Long id) throws DetailNotFoundException {
        return 	detailNonConformiteService.getDetail(id);
    }

    @GetMapping("/resultat/{idResultat}")
    public DetailNonConformiteDTO getDetailByResultat(@PathVariable Long idResultat)
            throws ResultatNotFoundException, PersonneNotFoundException,
            ProduitNotFoundException, PrelevementNotFoundException
    {
        return detailNonConformiteService.getDetailByIdResultat(idResultat);
    }

    @PostMapping
    public DetailNonConformiteDTO saveDetail(@RequestBody DetailNonConformiteDTO detailNonConformiteDTO)
            throws ResultatNotFoundException, PersonneNotFoundException,
            ProduitNotFoundException, PrelevementNotFoundException
    {
        return detailNonConformiteService.saveDetail(detailNonConformiteDTO);
    }

}
