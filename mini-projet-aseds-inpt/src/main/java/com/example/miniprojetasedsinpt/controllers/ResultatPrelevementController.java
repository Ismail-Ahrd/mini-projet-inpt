package com.example.miniprojetasedsinpt.controllers;

import com.example.miniprojetasedsinpt.entities.ResultatPrelevement;
import com.example.miniprojetasedsinpt.services.ResultatPrelevementService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/resultatPrelevement")
public class ResultatPrelevementController {
    private final ResultatPrelevementService resultatPrelevementService;

    @GetMapping
    public List<ResultatPrelevement> getAllPrelevement() {
        return resultatPrelevementService.getAllResultatPrelevement();
    }

    @GetMapping("/{id}")
    public ResultatPrelevement getPrelevement(@PathVariable Long id) {
        return 	resultatPrelevementService.getResultatPrelevement(id);

    }
    @PostMapping
    public void register( @RequestBody ResultatPrelevement resultatPrelevement) {
        resultatPrelevementService.saveResultatPrelevement(resultatPrelevement);
    }

}
