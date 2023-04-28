package com.example.miniprojetasedsinpt.controllers;

import com.example.miniprojetasedsinpt.controllers.utils.PrelevementRequest;
import com.example.miniprojetasedsinpt.entities.Prelevement;
import com.example.miniprojetasedsinpt.services.PersonneService;
import com.example.miniprojetasedsinpt.services.PrelevementService;
import com.example.miniprojetasedsinpt.services.ProduitService;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/prelevement")
public class PrelevementController {
    private final PrelevementService prelevementSrevice;
    private final PersonneService personneService;
    private final ProduitService produitService;

 @Autowired  
 public PrelevementController(PrelevementService prelevementSrevice,PersonneService personneService, ProduitService produitService) {
		this.prelevementSrevice = prelevementSrevice;
		this.personneService=personneService;
		this.produitService=produitService;
	}

	@GetMapping
    public List<Prelevement> getAllPrelevement() {
        return prelevementSrevice.getAllPrelevement();
    }

    @GetMapping("/{id}")
    public Prelevement getPrelevement(@PathVariable Long id) {
        return 	prelevementSrevice.getPrelevement(id);

    }
    @PostMapping
    public void save( 
        @RequestBody PrelevementRequest prelevementRequest) {
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

           prelevementSrevice.savePrelevement(prelevement);
 
    }
   @GetMapping("personne/{id}")
   public List<Prelevement> getPrelevementbyPersonne(@PathVariable Long id) {
       return 	prelevementSrevice.getAllprelevementBypersonne(id);

   }

}
