package com.example.miniprojetasedsinpt.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

;

@Entity
@Data
@NoArgsConstructor
public class DetailNonConformite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String dateTA;
    private String numeroTA;
    private String detail;
    @OneToOne
    private ResultatPrelevement resultatPrel;
}
