package com.example.miniprojetasedsinpt.controllers;

import com.example.miniprojetasedsinpt.controllers.utils.ResultatPrelevementRequest;
import com.example.miniprojetasedsinpt.entities.ResultatPrelevement;
import com.example.miniprojetasedsinpt.services.PersonneService;
import com.example.miniprojetasedsinpt.services.PrelevementService;
import com.example.miniprojetasedsinpt.services.ResultatPrelevementService;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Service

@RequestMapping("/resultatPrelevement")
public class ResultatPrelevementController {
    private final ResultatPrelevementService resultatPrelevementService;
    private final PersonneService personneService;
    private final PrelevementService prelevementService;
@Autowired
    public ResultatPrelevementController(ResultatPrelevementService resultatPrelevementService,PersonneService personneService,PrelevementService prelevementService) {
		this.personneService=personneService;
		this.prelevementService=prelevementService;
		this.resultatPrelevementService = resultatPrelevementService;
	}

	@GetMapping
    public List<ResultatPrelevement> getAllPrelevement() {
        return resultatPrelevementService.getAllResultatPrelevement();
    }

    @GetMapping("/{id}")
    public ResultatPrelevement getPrelevement(@PathVariable Long id) {
        return 	resultatPrelevementService.getResultatPrelevement(id);

    }
    @PostMapping
    public void register( @RequestBody ResultatPrelevementRequest resultatPrelevementRequest
    ) {
        ResultatPrelevement resultatPrelevement = new ResultatPrelevement();
        resultatPrelevement.setConforme(resultatPrelevementRequest.isConforme());
        resultatPrelevement.setDateBA(resultatPrelevementRequest.getDateBA());
        resultatPrelevement.setNumeroBA(resultatPrelevementRequest.getNumeroBA());
        resultatPrelevement.setPersonne(
                personneService.getPersonne(resultatPrelevementRequest.getIdPersonne()));
        resultatPrelevement.setPrelevement(
                prelevementService.getPrelevement(resultatPrelevementRequest.getIdPrelevement()));
         resultatPrelevementService.saveResultatPrelevement(resultatPrelevement);
         
    }

    }


