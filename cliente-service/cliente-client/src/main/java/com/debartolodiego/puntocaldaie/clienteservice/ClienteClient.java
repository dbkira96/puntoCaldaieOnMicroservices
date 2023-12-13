package com.debartolodiego.puntocaldaie.clienteservice;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.annotation.HttpExchange;

import java.util.List;


@HttpExchange
public interface ClienteClient {
    @PostMapping("/clienti")
    ClienteDto addCliente(@RequestBody ClienteDto stufaDto);
    @GetMapping("/clienti/{id}")
    ClienteDto getCliente(@PathVariable long id) ;
    @GetMapping("/clienti")
    public List<ClienteDto> getStufe();
    @PostMapping("/stufe")
    public List<ClienteDto> loadStufe(@RequestBody List<ClienteDto> stufeDto);
    @PutMapping("/stufe")
    public ClienteDto updateCliente(@RequestBody ClienteDto stufaDto);
    @GetMapping("stufe/client/{id}")
    public List<ClienteDto> getStufeByclientId(@PathVariable Long id);
}