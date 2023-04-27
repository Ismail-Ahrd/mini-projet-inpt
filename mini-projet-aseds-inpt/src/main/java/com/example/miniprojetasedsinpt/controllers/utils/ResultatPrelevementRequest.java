package com.example.miniprojetasedsinpt.controllers.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
public class ResultatPrelevementRequest {
    private Date dateBA;
    private int numeroBA;
    private boolean conforme;
    private Long idPersonne;
    private Long idPrelevement;

}
