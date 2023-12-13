package com.debartolodiego.caldaiaservice;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="CALDAIA")
@Data
public class Caldaia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="TITOLO")
    private  String titolo;

    @Column(name="SCAD_ANNO")
    private  String scadanno;

    @Column(name="IMPORTO")
    private String importo;

    @Column(name="ANNOTAZIONE")
    private String annotazione;

    @Column(name="SCAD_BOLLO")
    private String scadbollo;

    @Column(name="SCADENZA")
    private String scadenza;

    @Column(name= "CLIENT_ID")
    private Long clientId;

}
