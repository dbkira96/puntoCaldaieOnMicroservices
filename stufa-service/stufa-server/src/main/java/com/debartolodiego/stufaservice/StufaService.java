package com.debartolodiego.stufaservice;



import com.debartolodiego.stufaservice.client.StufaDto;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/stufa")
public class StufaService   {

    private static final Logger LOGGER = LoggerFactory.getLogger(StufaService.class);


    private  final StufaRepository stufaRepository;
    private final ModelMapper modelMapper;


    public StufaService(StufaRepository stufaRepository, ModelMapper modelMapper) {
        this.stufaRepository = stufaRepository;
        this.modelMapper = modelMapper;
    }

    @PostMapping("")
    public StufaDto addStufa(@RequestBody StufaDto stufaDto) {
        Stufa stufa = modelMapper.map(stufaDto,Stufa.class);
        return modelMapper.map(stufaRepository.save(stufa),StufaDto.class);
    }


    @GetMapping("/{id}")
    public StufaDto getStufa(@PathVariable long id) {
        LOGGER.info("getting stufa with id: {}",id);
        Stufa stufa = stufaRepository.findById(id).orElseThrow(()->new RuntimeException("Stufa non trovata"));
        return modelMapper.map(stufa,StufaDto.class);
    }

    @GetMapping("")
    public List<StufaDto> getStufe() {
        LOGGER.info("getting all stufe");

        List<Stufa> stufe = stufaRepository.findAll();
        return stufe.stream().map(stufa ->
             modelMapper.map(stufa,StufaDto.class)
        ).collect(Collectors.toList());
    }

    @PostMapping("")
    public List<StufaDto> loadStufe(@RequestBody List<StufaDto> stufeDto) {
        LOGGER.info("adding {} stufe: ",stufeDto.size());
        List<Stufa> stufe = stufeDto.stream().map(stufaDto -> modelMapper.map(stufaDto,Stufa.class)).collect(Collectors.toList());
        return stufaRepository.saveAll(stufe).stream().map(stufa -> modelMapper.map(stufa,StufaDto.class)).collect(Collectors.toList());
    }

    @PutMapping("")
    public StufaDto updateStufa(@RequestBody StufaDto stufaDto) {
        LOGGER.info("updating stufa with id: {}",stufaDto.getId());
        Stufa stufa=modelMapper.map(stufaDto,Stufa.class);
        return modelMapper.map(stufaRepository.save(stufa),StufaDto.class);
    }

    @DeleteMapping("/{id}")
    public StufaDto deleteStufa(@PathVariable Long id) {
        LOGGER.info("delete stufa with id: {}",id);

        Stufa stufa = stufaRepository.findById(id).orElseThrow(() -> new RuntimeException("Stufa non trovata"));
        stufaRepository.delete(stufa);
        return new StufaDto();
    }
    @GetMapping("/cliente/{id}")
    public List<StufaDto> getStufeByclientId(@PathVariable Long id){
        LOGGER.info("getStufe for client id: {}",id);
        return stufaRepository.findAllByClientid(id).stream().map(s->modelMapper.map(s,StufaDto.class)).collect(Collectors.toList());
    }

}
