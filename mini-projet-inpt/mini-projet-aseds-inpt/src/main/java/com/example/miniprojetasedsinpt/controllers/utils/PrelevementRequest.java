package com.example.miniprojetasedsinpt.controllers.utils;

import java.sql.Date;

import com.example.miniprojetasedsinpt.entities.utils.Cadre;
import com.example.miniprojetasedsinpt.entities.utils.EtatAvancement;
import com.example.miniprojetasedsinpt.entities.utils.Labo;
import com.example.miniprojetasedsinpt.entities.utils.Niveau;
import com.example.miniprojetasedsinpt.entities.utils.TypePrelevement;

import lombok.Data;
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
