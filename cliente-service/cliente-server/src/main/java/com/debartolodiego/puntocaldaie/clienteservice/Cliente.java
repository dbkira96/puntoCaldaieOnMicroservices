package com.debartolodiego.puntocaldaie.clienteservice;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "CLIENTI")
@Data
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Basic(optional = false)
    @Column(name="NOMINATIVO")
    private String nominativo;

    @Column(name = "LUOGO_NASCITA")
    private String luogoNascita;

    @Column(name = "DATA_NASCITA")
    @JsonFormat(pattern="dd/MM/yyyy")
    private LocalDate dataNascita;

    @Column(name = "TELEFONO")
    private String telefono;

    @Column(name = "INDIRIZZO")
    private String indirizzo;

    @Column(name = "CAP")
    private String cap;

    @Column(name = "CITTA")
    private String citta;

    @Column(name = "CF")
    private String CF;

    @Column(name = "PIVA")
    private String piva;

    @Column(name = "CELLULARE")
    private String cellulare;




}
