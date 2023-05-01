package com.example.miniprojetasedsinpt.controllers;

import com.example.miniprojetasedsinpt.dtos.ResultatPrelevementDTO;
import com.example.miniprojetasedsinpt.exceptions.PersonneNotFoundException;
import com.example.miniprojetasedsinpt.exceptions.PrelevementNotFoundException;
import com.example.miniprojetasedsinpt.exceptions.ProduitNotFoundException;
import com.example.miniprojetasedsinpt.exceptions.ResultatNotFoundException;
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
    public List<ResultatPrelevementDTO> getAllPrelevement() {
        return resultatPrelevementService.getAllResultatPrelevement();
    }

    @GetMapping("/{id}")
    public ResultatPrelevementDTO getPrelevement(@PathVariable Long id)
            throws ResultatNotFoundException
    {
        return 	resultatPrelevementService.getResultatPrelevement(id);
    }

    @PostMapping
    public ResultatPrelevementDTO saveResultatPrelevement(
            @RequestBody ResultatPrelevementDTO resultatPrelevementDTO
    ) throws PersonneNotFoundException, ProduitNotFoundException, PrelevementNotFoundException
    {
        return resultatPrelevementService.saveResultatPrelevement(resultatPrelevementDTO);
    }

}
