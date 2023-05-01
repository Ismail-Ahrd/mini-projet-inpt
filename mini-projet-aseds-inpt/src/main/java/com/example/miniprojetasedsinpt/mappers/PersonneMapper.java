package com.example.miniprojetasedsinpt.mappers;

import com.example.miniprojetasedsinpt.dtos.PersonneDTO;
import com.example.miniprojetasedsinpt.entities.Personne;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class PersonneMapper {

    public PersonneDTO fromPersonne(Personne personne) {
        PersonneDTO personneDTO = new PersonneDTO();
        BeanUtils.copyProperties(personne,personneDTO);
        return personneDTO;
    }

    public Personne fromPersonneDTO(PersonneDTO personneDTO) {
        Personne personne= new Personne();
        BeanUtils.copyProperties(personneDTO,personne);
        return personne;
    }

}
