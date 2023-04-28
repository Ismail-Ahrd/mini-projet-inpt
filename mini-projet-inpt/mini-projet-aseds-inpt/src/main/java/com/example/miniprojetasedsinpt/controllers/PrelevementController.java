package com.example.miniprojetasedsinpt.controllers;

import com.example.miniprojetasedsinpt.controllers.utils.PrelevementRequest;
import com.example.miniprojetasedsinpt.entities.Prelevement;
import com.example.miniprojetasedsinpt.entities.utils.Cadre;
import com.example.miniprojetasedsinpt.entities.utils.EtatAvancement;
import com.example.miniprojetasedsinpt.entities.utils.Labo;
import com.example.miniprojetasedsinpt.entities.utils.Niveau;
import com.example.miniprojetasedsinpt.entities.utils.TypePrelevement;
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

 
    @PostMapping
    public Prelevement save( @RequestBody PrelevementRequest prelevementRequest) {
            Prelevement prelevement = new Prelevement();
            prelevement.setTypePrelevement(TypePrelevement.valueOf(prelevementRequest.getTypePrelevement()));
            prelevement.setCadreControle( Cadre.valueOf(prelevementRequest.getCadreControle()) );
            prelevement.setDateEnvoie(prelevementRequest.getDateEnvoie());
            prelevement.setDateProcesVerbal(prelevementRequest.getDateProcesVerbal());
            prelevement.setNumeroProcesVerbal(prelevementRequest.getNumeroProcesVerbal());
            prelevement.setEtatAvancement(  EtatAvancement.valueOf(prelevementRequest.getEtatAvancement()) );
            prelevement.setLaboDestination(Labo.valueOf(prelevementRequest.getLaboDestination()) );
            prelevement.setNiveauPrel(Niveau.valueOf(prelevementRequest.getNiveauPrel()) );
            prelevement.setPersonne(
                    personneService.getPersonne(prelevementRequest.getIdPersonne()));
            prelevement.setProduit(
                    produitService.getProduit(prelevementRequest.getIdProduit()));

          return prelevementSrevice.savePrelevement(prelevement);
 
    }
   @GetMapping("/{id}")
   public List<Prelevement> getPrelevementbyPersonne(@PathVariable Long id) {
       return 	prelevementSrevice.getAllprelevementBypersonne(id);

   }
   @DeleteMapping("/{id}")
   public void delete(@PathVariable Long id) {
	   prelevementSrevice.deletePrelevement(id);
   }
}
