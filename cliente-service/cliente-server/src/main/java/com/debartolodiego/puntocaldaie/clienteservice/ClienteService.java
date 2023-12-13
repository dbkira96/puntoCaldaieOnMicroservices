package com.debartolodiego.puntocaldaie.clienteservice;


import com.debartolodiego.caldaiaservice.client.CaldaiaClient;
import com.debartolodiego.stufaservice.client.StufaClient;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
@RestController
@RequestMapping("/cliente")
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private CaldaiaClient caldaiaClient;

    @Autowired
    private StufaClient stufaClient;

    @Autowired
    private ModelMapper modelMapper;
    @PostMapping("/")
    public ClienteDto addClient(ClienteDto clientDto) {
        Cliente client= modelMapper.map(clientDto, Cliente.class);
        return modelMapper.map(clienteRepository.save(client),ClienteDto.class);
    }

    @GetMapping("/{id}")
    public ClienteDto getClient(long id) {
        Cliente client = clienteRepository.findById(id).orElseThrow(()->new RuntimeException("Cliente non trovato"));
        return modelMapper.map(client,ClienteDto.class);
    }

    @GetMapping("/{id}/full")
    public ClienteDto getClientWithExtra(long id) {
        Cliente client = clienteRepository.findById(id).orElseThrow(()->new RuntimeException("Cliente non trovato"));
        ClienteDto dto = modelMapper.map(client,ClienteDto.class);

        dto.setCaldaie(caldaiaClient.getCaldaieByCliente(dto.getId()));
        dto.setStufe(stufaClient.getStufeByclientId(dto.getId()));

        return dto;
    }

    @GetMapping("")
    public List<ClienteDto> getClients() {
        List<Cliente> clients = clienteRepository.findAll();
        return clients.stream().map(user->modelMapper.map(user,ClienteDto.class)).collect(Collectors.toList());
    }

    @PostMapping("")
    public List<ClienteDto> loadUsers(List<ClienteDto> clientsDto) {
        List<Cliente> clients= clientsDto.stream().map(clientDto -> modelMapper.map(clientDto, Cliente.class)).collect(Collectors.toList());
        clients= clienteRepository.saveAll(clients);
        return clients.stream().map(user->modelMapper.map(user,ClienteDto.class)).collect(Collectors.toList());
    }
    @PutMapping("")
    public ClienteDto updateUser(ClienteDto clientDto) {
        Cliente client = clienteRepository.findById(clientDto.getId()).orElseThrow(() -> new RuntimeException("user " + clientDto.getNominativo() + " not found"));
        return addClient(clientDto);
    }

    public List<ClienteDto> deleteAllClients() {
        clienteRepository.deleteAll();
        return  getClients();
    }

    @DeleteMapping("/{id}")
    public ClienteDto deleteClient(Long id) {
        Cliente client = clienteRepository.findById(id).orElseThrow(()->new RuntimeException("cliente non trovato"));
        clienteRepository.delete(client);
        return new ClienteDto();
    }
}
