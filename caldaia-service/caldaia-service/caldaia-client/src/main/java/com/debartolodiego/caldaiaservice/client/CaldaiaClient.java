package com.debartolodiego.caldaiaservice.client;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.service.annotation.HttpExchange;

import java.util.List;

@HttpExchange
public interface CaldaiaClient {


    @PostMapping("/caldaia")
    CaldaiaDto addCaldaia(CaldaiaDto caldaiaDto);

    @GetMapping("/caldaia/{id}")
    CaldaiaDto getCaldaia(Long id);

    @PutMapping("/caldaia")
    CaldaiaDto updateCaldaia(CaldaiaDto caldaiaDto);

    @GetMapping("/caldaia/user/{id}")
    List<CaldaiaDto> getCaldaieByCliente(Long id);

    @DeleteMapping("/caldaia/{id}")
    CaldaiaDto deleteCaldaia(Long id);
}

