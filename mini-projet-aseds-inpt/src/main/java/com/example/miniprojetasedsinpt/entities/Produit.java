package com.example.miniprojetasedsinpt.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Produit {
    @Id
    @GeneratedValue
    @Column
    private Long idproduit;
    private String Categorie;
    private String Nom;
    @OneToMany
    private List<Prelevement> prelevement;
}
