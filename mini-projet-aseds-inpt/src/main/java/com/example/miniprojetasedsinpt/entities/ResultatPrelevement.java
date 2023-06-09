package com.example.miniprojetasedsinpt.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class ResultatPrelevement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dateBA;
    private int numeroBA;
    private Boolean conforme;
    @ManyToOne
    private Personne personne;
    @OneToOne(mappedBy = "resultatPrel")
    private Prelevement prelevement;
    @OneToOne(mappedBy = "resultatPrel")
    private DetailNonConformite detailNonConformite;

}
