package com.example.miniprojetasedsinpt.controllers.utils;

import lombok.Data;

@Data
public class DetailNonConformiteRequest {
	private String dateTA;
    private String numeroTA;
    private String detail;
    private Long idResultat;
}
