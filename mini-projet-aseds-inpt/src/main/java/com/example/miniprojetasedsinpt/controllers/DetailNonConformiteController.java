package com.example.miniprojetasedsinpt.controllers;

import com.example.miniprojetasedsinpt.controllers.utils.DetailNonConformiteRequest;
import com.example.miniprojetasedsinpt.entities.DetailNonConformite;
import com.example.miniprojetasedsinpt.services.DetailNonConformiteService;
import com.example.miniprojetasedsinpt.services.ResultatPrelevementService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("detailNonConformite")
public class DetailNonConformiteController {
    private final DetailNonConformiteService detailNonConformiteService;
    private final ResultatPrelevementService resultatPrelevementService;

    @GetMapping
    public List<DetailNonConformite> getAllDetails() {
        return detailNonConformiteService.getAllDetails();
    }

    @GetMapping("/{id}")
    public DetailNonConformite getDetail(@PathVariable Long id) {
        return 	detailNonConformiteService.getDetail(id);
    }

    @PostMapping
    public DetailNonConformite saeDetail( @RequestBody DetailNonConformiteRequest detailRequest ) {
        DetailNonConformite detailNonConformite = new DetailNonConformite();
        detailNonConformite.setDetail(detailRequest.getDetail());
        detailNonConformite.setDateTA(detailRequest.getDateTA());
        detailNonConformite.setNumeroTA(detailRequest.getNumeroTA());
        detailNonConformite.setResultatPrel(
                resultatPrelevementService.getResultatPrelevement(detailRequest.getIdResultat()));

        return detailNonConformiteService.saveDetail(detailNonConformite);
    }

}
