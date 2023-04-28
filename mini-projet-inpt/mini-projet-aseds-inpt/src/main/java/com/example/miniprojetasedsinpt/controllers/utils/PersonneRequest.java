package com.example.miniprojetasedsinpt.controllers.utils;

import com.example.miniprojetasedsinpt.entities.utils.TypePersonne;

import lombok.Data;
@Data
public class PersonneRequest {
	  private String nom;
	    private String prenom;
	    private String email;
	    private String mdp;
	    private TypePersonne type;
}
