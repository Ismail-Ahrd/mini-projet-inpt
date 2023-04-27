package com.example.miniprojetasedsinpt.controllers;

import com.example.miniprojetasedsinpt.controllers.utils.ResultatPrelevementRequest;
import com.example.miniprojetasedsinpt.entities.ResultatPrelevement;
import com.example.miniprojetasedsinpt.services.PersonneService;
import com.example.miniprojetasedsinpt.services.PrelevementService;
import com.example.miniprojetasedsinpt.services.ResultatPrelevementService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/resultatPrelevement")
public class ResultatPrelevementController {
    private final ResultatPrelevementService resultatPrelevementService;
    private final PersonneService personneService;
    private final PrelevementService prelevementService;

    @GetMapping
    public List<ResultatPrelevement> getAllPrelevement() {
        return resultatPrelevementService.getAllResultatPrelevement();
    }

    @GetMapping("/{id}")
    public ResultatPrelevement getPrelevement(@PathVariable Long id) {
        return 	resultatPrelevementService.getResultatPrelevement(id);

    }

    @PostMapping
    public ResultatPrelevement saveResultatPrelevement(
            @RequestBody ResultatPrelevementRequest resultatPrelevementRequest
    ) {
        ResultatPrelevement resultatPrelevement = new ResultatPrelevement();
        resultatPrelevement.setConforme(resultatPrelevementRequest.isConforme());
        resultatPrelevement.setDateBA(resultatPrelevementRequest.getDateBA());
        resultatPrelevement.setNumeroBA(resultatPrelevementRequest.getNumeroBA());
        resultatPrelevement.setPersonne(
                personneService.getPersonne(resultatPrelevementRequest.getIdPersonne()));
        resultatPrelevement.setPrelevement(
                prelevementService.getPrelevement(resultatPrelevementRequest.getIdPrelevement()));
        return resultatPrelevementService.saveResultatPrelevement(resultatPrelevement);
    }

}
