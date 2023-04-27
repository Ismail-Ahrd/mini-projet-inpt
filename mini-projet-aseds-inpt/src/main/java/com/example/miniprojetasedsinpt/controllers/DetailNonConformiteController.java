package com.example.miniprojetasedsinpt.controllers;

import com.example.miniprojetasedsinpt.entities.DetailNonConformite;
import com.example.miniprojetasedsinpt.services.DetailNonConformiteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("detailNonConformite")
public class DetailNonConformiteController {
    private final DetailNonConformiteService detailNonConformiteService;

    @GetMapping
    public List<DetailNonConformite> getAllDetails() {
        return detailNonConformiteService.getAllDetails();
    }

    @GetMapping("/{id}")
    public Object getDetail(@PathVariable Long id) {
        return 	detailNonConformiteService.getDetail(id);

    }

    @PostMapping
    public void register( @RequestBody DetailNonConformite detail ) {
        detailNonConformiteService.saveDetail(detail);
    }

}
