package com.omnisoft.omnihelp.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.omnisoft.omnihelp.domain.Client;
import com.omnisoft.omnihelp.domain.dtos.ClientDTO;
import com.omnisoft.omnihelp.services.ClientService;

import jakarta.validation.Valid;

// EndPoint para técnicos
@RestController
@RequestMapping(value = "/client")
public class ClientResource {
    @Autowired
    private ClientService service;

    // Metodo Get para trazer o cliente por id
    @GetMapping(value = "/{id}")
    public ResponseEntity<ClientDTO> findById(@PathVariable Integer id) {
        Client obj = service.findById(id);
        return ResponseEntity.ok().body(new ClientDTO(obj));
    }

    // Metodo Get para trazer todos os cliente
    @GetMapping
    public ResponseEntity<List<ClientDTO>> findAll() {
        // Cria lista de técnicos
        List<Client> list = service.findAll();
        // Converte a lista de técnicos em listaDTO
        List<ClientDTO> listDTO = list.stream().map(obj -> new ClientDTO(obj)).collect(Collectors.toList());
        // Retorna listaDTO
        return ResponseEntity.ok().body(listDTO);
    }

    // Metodo Post para criar um novo cliente
    @PostMapping
    public ResponseEntity<ClientDTO> create(@Valid @RequestBody ClientDTO objDTO) {
        Client newObj = service.create(objDTO);
        // Pega a uri com o novo id do novo cliente
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    // Metodo de atualização do cliente
    @PutMapping(value = "/{id}")
    public ResponseEntity<ClientDTO> update(@PathVariable Integer id, @Valid @RequestBody ClientDTO objDTO) {
        Client obj = service.update(id, objDTO);
        return ResponseEntity.ok().body(new ClientDTO(obj));
    }

    // Metodo de delete
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<ClientDTO> delete(@PathVariable Integer id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

}
