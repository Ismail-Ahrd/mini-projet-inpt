package com.example.miniprojetasedsinpt.services;

import com.example.miniprojetasedsinpt.entities.Personne;
import com.example.miniprojetasedsinpt.entities.Prelevement;
import com.example.miniprojetasedsinpt.entities.ResultatPrelevement;
import com.example.miniprojetasedsinpt.repositories.PrelevementRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Service
public class PrelevementServiceImpl implements PrelevementService {
    private final PrelevementRepository prelevementrepository;
    private final PersonneService personneservice;
     public PrelevementServiceImpl(PrelevementRepository prelevementrepository,PersonneService personneservice) {
		
		this.prelevementrepository = prelevementrepository;
		this.personneservice=personneservice;
	}

	@Override
    public void savePrelevement(Prelevement prelevement) {
        if(prelevementrepository.findById(prelevement.getId())!=null) {
            throw new IllegalArgumentException("Ce prelevement est déjà enregistré");
        }
        else {
            prelevementrepository.save(prelevement);
        }
    }

    @Override
    public Prelevement getPrelevement(Long id) {
        return prelevementrepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Ce prelevement n'existe pas"));
    }

    @Override
    public void deletePrelevement(long id) {
        if(prelevementrepository.findById(id)==null) {
            throw new IllegalArgumentException("Ce prelevement n'existe pas");

        }
        else {
            prelevementrepository.deleteById(id);;
        }
    }

    @Override
    public List<Prelevement> getAllPrelevement() {
        return prelevementrepository.findAll();
    }
    public List<Prelevement> getAllprelevementBypersonne(Long idpersonne){
    	Personne p=personneservice.getPersonne(idpersonne);
    	return p.getPrelevements();
    	
    	
    }
}
