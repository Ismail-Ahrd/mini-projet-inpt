package com.example.miniprojetasedsinpt.controllers.utils;

import java.sql.Date;

import lombok.Data;
@Data
public class ResultatPrelevementRequest {
	 private Date dateBA;
	    private int numeroBA;
	    private boolean conforme;
	    private Long idPersonne;
	    private Long idPrelevement;
}
