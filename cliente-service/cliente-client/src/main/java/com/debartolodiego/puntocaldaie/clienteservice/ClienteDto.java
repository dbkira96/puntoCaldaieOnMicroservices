package com.debartolodiego.puntocaldaie.clienteservice;

import com.debartolodiego.caldaiaservice.client.CaldaiaDto;
import com.debartolodiego.stufaservice.client.StufaDto;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Data
public class ClienteDto implements Serializable {

    private long id;
    private String nominativo;
    private String luogoNascita;

    @JsonFormat(pattern="dd/MM/yyyy")
    private LocalDate dataNascita;
    private String telefono;
    private String indirizzo;
    private String cap;
    private String citta;
    private String CF;
    private String piva;
    private String cellulare;
    @JsonManagedReference
    private List<StufaDto> stufe;
    @JsonManagedReference
    private List<CaldaiaDto> caldaie;


}
