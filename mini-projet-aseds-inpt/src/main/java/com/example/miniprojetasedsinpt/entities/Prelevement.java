package com.example.miniprojetasedsinpt.entities;

import com.example.miniprojetasedsinpt.entities.utils.*;
import jakarta.persistence.*;
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
    private Personne personne;
    @OneToOne(mappedBy = "prelevement")
    private ResultatPrelevement resultatPrel;

    public Prelevement(Date dateProcesVerbal, int numeroProcesVerbal,
                       TypePrelevement typePrelevement, Cadre cadreControle,
                       Niveau niveauPrel, Labo laboDestination,
                       Date dateEnvoie, EtatAvancement etatAvancement
    ) {
        this.dateProcesVerbal = dateProcesVerbal;
        this.numeroProcesVerbal = numeroProcesVerbal;
        this.typePrelevement = typePrelevement;
        this.cadreControle = cadreControle;
        this.niveauPrel = niveauPrel;
        this.laboDestination = laboDestination;
        this.dateEnvoie = dateEnvoie;
        this.etatAvancement = etatAvancement;
    }
}
