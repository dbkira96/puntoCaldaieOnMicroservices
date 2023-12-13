package com.debartolodiego.stufaservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.service.annotation.HttpExchange;

import java.util.List;

@HttpExchange
public interface StufaClient {
    @PostMapping("/stufe")
    StufaDto addStufa(@RequestBody StufaDto stufaDto);
    @GetMapping("/stufe/{id}")
    StufaDto getStufa(@PathVariable long id) ;
    @GetMapping("/stufe")
    public List<StufaDto> getStufe();
    @PostMapping("/stufe")
    public List<StufaDto> loadStufe(@RequestBody List<StufaDto> stufeDto);
    @PutMapping("/stufe")
    public StufaDto updateStufa(@RequestBody StufaDto stufaDto);
    @GetMapping("stufe/client/{id}")
    public List<StufaDto> getStufeByclientId(@PathVariable Long id);
}