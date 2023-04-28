package com.example.miniprojetasedsinpt.entities;

import com.example.miniprojetasedsinpt.entities.utils.Cadre;
import com.example.miniprojetasedsinpt.entities.utils.EtatAvancement;
import com.example.miniprojetasedsinpt.entities.utils.Labo;
import com.example.miniprojetasedsinpt.entities.utils.Niveau;
import com.example.miniprojetasedsinpt.entities.utils.TypePrelevement;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class Prelevement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dateProcesVerbal;
    private int numeroProcesVerbal;
    private TypePrelevement typePrelevement;
    private Cadre cadreControle;
    private Niveau niveauPrel;
    private Labo laboDestination;
    private Date dateEnvoie;
    private EtatAvancement etatAvancement;
    @ManyToOne
    private Produit produit;
    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Personne personne;
    @OneToOne(mappedBy="prelevement")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private ResultatPrelevement resultatPrel;
	public Prelevement(Date dateProcesVerbal, int numeroProcesVerbal, TypePrelevement typePrelevement,
			Cadre cadreControle, Niveau niveauPrel, Labo laboDestination, Date dateEnvoie, EtatAvancement etatAvancement,
			Produit produit, Personne personne, ResultatPrelevement resultatPrel) {
		this.dateProcesVerbal = dateProcesVerbal;
		this.numeroProcesVerbal = numeroProcesVerbal;
		this.typePrelevement = typePrelevement;
		this.cadreControle = cadreControle;
		this.niveauPrel = niveauPrel;
		this.laboDestination = laboDestination;
		this.dateEnvoie = dateEnvoie;
		this.etatAvancement = etatAvancement;
		this.produit = produit;
		this.personne = personne;
		this.resultatPrel = resultatPrel;
	}





}
