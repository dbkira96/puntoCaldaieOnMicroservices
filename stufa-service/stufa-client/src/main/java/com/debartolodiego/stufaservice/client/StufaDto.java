package com.debartolodiego.stufaservice.client;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StufaDto {
    private long id;
    private String titolo;
    private String scadanno;
    private String importo;
    private String annotazione;
    private String scadbollo;
    private Long clientId;


}
