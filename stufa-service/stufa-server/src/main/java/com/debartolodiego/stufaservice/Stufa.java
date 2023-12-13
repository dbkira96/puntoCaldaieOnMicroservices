package com.debartolodiego.stufaservice;

import jakarta.persistence.*;
import lombok.Data;


@Table
@Entity(name="STUFA")
@Data
public class Stufa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Column(name="TITOLO",columnDefinition = "varchar(255) default 'Nessun Titolo'")
    private String titolo;

    @Column(name = "ANNO_SCAD")
    private String scadanno;

    @Column(name = "IMPORTO")
    private String importo;

    @Column(name = "ANNOTAZIONE")
    private String annotazione;

    @Column(name = "SCAD_BOLLO")
    private String scadbollo;


    @Column(name= "CLIENT_ID")
    private Long clientId;


}
