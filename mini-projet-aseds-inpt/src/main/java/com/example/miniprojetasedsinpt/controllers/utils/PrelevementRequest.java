package com.example.miniprojetasedsinpt.controllers.utils;

import com.example.miniprojetasedsinpt.entities.utils.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
public class PrelevementRequest {
    private Date dateProcesVerbal;
    private int numeroProcesVerbal;
    private TypePrelevement typePrelevement;
    private Cadre cadreControle;
    private Niveau niveauPrel;
    private Labo laboDestination;
    private Date dateEnvoie;
    private EtatAvancement etatAvancement;
    private Long idPersonne;
    private Long idProduit;

}
