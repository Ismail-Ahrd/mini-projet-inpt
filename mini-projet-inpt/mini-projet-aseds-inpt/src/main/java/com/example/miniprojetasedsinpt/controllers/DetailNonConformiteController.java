package com.example.miniprojetasedsinpt.controllers;

import com.example.miniprojetasedsinpt.controllers.utils.DetailNonConformiteRequest;
import com.example.miniprojetasedsinpt.entities.DetailNonConformite;
import com.example.miniprojetasedsinpt.services.DetailNonConformiteService;
import com.example.miniprojetasedsinpt.services.ResultatPrelevementService;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service

@RequestMapping("/detailNonConformite")
public class DetailNonConformiteController {
    private final DetailNonConformiteService detailNonConformiteService;
    private final ResultatPrelevementService resultatPrelevementService;

    public DetailNonConformiteController(DetailNonConformiteService detailNonConformiteService,ResultatPrelevementService resultatPrelevementService) {
		this.detailNonConformiteService = detailNonConformiteService;
		this.resultatPrelevementService=resultatPrelevementService;
		
	}

	@GetMapping
    public List<DetailNonConformite> getAllDetails() {
        return detailNonConformiteService.getAllDetails();
    }

    @GetMapping("/{id}")
    public Object getDetail(@PathVariable Long id) {
        return 	detailNonConformiteService.getDetail(id);

    }

    @PostMapping
    public void register( @RequestBody DetailNonConformiteRequest detailRequest ) {
        DetailNonConformite detailNonConformite = new DetailNonConformite();
        detailNonConformite.setDetail(detailRequest.getDetail());
        detailNonConformite.setDateTA(detailRequest.getDateTA());
        detailNonConformite.setNumeroTA(detailRequest.getNumeroTA());
        detailNonConformite.setResultatPrel(
                resultatPrelevementService.getResultatPrelevement(detailRequest.getIdResultat()));

         detailNonConformiteService.saveDetail(detailNonConformite);
    }

}
