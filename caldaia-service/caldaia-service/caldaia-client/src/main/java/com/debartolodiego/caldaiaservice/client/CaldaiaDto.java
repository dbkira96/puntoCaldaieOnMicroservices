package com.debartolodiego.caldaiaservice.client;

import lombok.Data;

@Data
public class CaldaiaDto {

    private long id;
    private String titolo;
    private String scadenza;



    private String scadanno;
    private String importo;
    private String annotazione;
    private String scadbollo;


    private Long clientId;


}
