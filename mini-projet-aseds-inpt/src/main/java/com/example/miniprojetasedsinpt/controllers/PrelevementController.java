package com.example.miniprojetasedsinpt.controllers;

import com.example.miniprojetasedsinpt.controllers.utils.PrelevementRequest;
import com.example.miniprojetasedsinpt.entities.Prelevement;
import com.example.miniprojetasedsinpt.services.PersonneService;
import com.example.miniprojetasedsinpt.services.PrelevementService;
import com.example.miniprojetasedsinpt.services.ProduitService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/prelevement")
public class PrelevementController {
    private final PrelevementService prelevementSrevice;
    private final PersonneService personneService;
    private final ProduitService produitService;

    @GetMapping
    public List<Prelevement> getAllPrelevement() {
        return prelevementSrevice.getAllPrelevement();
    }

    @GetMapping("/{id}")
    public Prelevement getPrelevement(@PathVariable Long id) {
        return 	prelevementSrevice.getPrelevement(id);

    }
    @PostMapping
    public Prelevement savePrelevement( @RequestBody PrelevementRequest prelevementRequest) {
        Prelevement prelevement = new Prelevement();
        prelevement.setTypePrelevement(prelevementRequest.getTypePrelevement());
        prelevement.setCadreControle(prelevementRequest.getCadreControle());
        prelevement.setDateEnvoie(prelevementRequest.getDateEnvoie());
        prelevement.setDateProcesVerbal(prelevementRequest.getDateProcesVerbal());
        prelevement.setNumeroProcesVerbal(prelevementRequest.getNumeroProcesVerbal());
        prelevement.setEtatAvancement(prelevementRequest.getEtatAvancement());
        prelevement.setLaboDestination(prelevementRequest.getLaboDestination());
        prelevement.setNiveauPrel(prelevementRequest.getNiveauPrel());
        prelevement.setPersonne(
                personneService.getPersonne(prelevementRequest.getIdPersonne()));
        prelevement.setProduit(
                produitService.getProduit(prelevementRequest.getIdProduit()));

        return prelevementSrevice.savePrelevement(prelevement);
    }

}
