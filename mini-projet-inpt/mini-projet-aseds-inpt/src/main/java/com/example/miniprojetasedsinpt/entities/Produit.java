package com.example.miniprojetasedsinpt.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

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
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<Prelevement> prelevement;
	public Produit(String categorie, String nom, List<Prelevement> prelevement) {
		super();
		Categorie = categorie;
		Nom = nom;
		this.prelevement = prelevement;
	}




}
