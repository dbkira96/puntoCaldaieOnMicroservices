package com.debartolodiego.caldaiaservice;


import com.debartolodiego.caldaiaservice.client.CaldaiaDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/caldaia")
public class CaldaiaService {

    @Autowired
    CaldaiaRepository caldaiaRepository;


    @Autowired
    ModelMapper modelMapper;

    @PostMapping("")
    public CaldaiaDto addCaldaia(CaldaiaDto caldaiaDto) {
        Caldaia caldaia = modelMapper.map(caldaiaDto,Caldaia.class);
        return modelMapper.map(caldaiaRepository.save(caldaia),CaldaiaDto.class);
    }

    @GetMapping("/{id}")
    public CaldaiaDto getCaldaia(Long id) {
        Caldaia caldaia= caldaiaRepository.findById(id).orElseThrow(()->new RuntimeException("Caldaia non trovata"));
        return modelMapper.map(caldaia,CaldaiaDto.class);
    }
    @PutMapping("")
    public CaldaiaDto updateCaldaia(CaldaiaDto caldaiaDto) {
        Caldaia caldaia = modelMapper.map(caldaiaDto,Caldaia.class);
        Caldaia old= caldaiaRepository.findById(caldaiaDto.getId()).orElseThrow(()->new RuntimeException("Caldaia non trovata"));
        return modelMapper.map(caldaiaRepository.save(caldaia),CaldaiaDto.class);
    }

    @DeleteMapping("/{id}")
    public CaldaiaDto deleteCaldaia(Long id) {
        Caldaia caldaia= caldaiaRepository.findById(id).orElseThrow(()->new RuntimeException("Caldaia non trovata"));
        caldaiaRepository.delete(caldaia);
        return new CaldaiaDto();
    }
    @GetMapping("")
    public List<CaldaiaDto> getCaldaie(){
        List<Caldaia> caldaie= caldaiaRepository.findAll();
        return caldaie.stream().map(caldaia -> modelMapper.map(caldaia, CaldaiaDto.class)).collect(Collectors.toList());
    }
}
