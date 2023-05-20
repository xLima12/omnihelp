package com.omnisoft.omnihelp.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.omnisoft.omnihelp.domain.Technician;
import com.omnisoft.omnihelp.domain.dtos.TechnicianDTO;
import com.omnisoft.omnihelp.services.TechnicianService;

// EndPoint para técnicos
@RestController
@RequestMapping(value = "/technician")
public class TechnicianResource {
    @Autowired
    private TechnicianService service;

    // Metodo Get para trazer o técnico por id
    @GetMapping(value = "/{id}")
    public ResponseEntity<TechnicianDTO> findById(@PathVariable Integer id) {
        Technician obj = service.findById(id);
        return ResponseEntity.ok().body(new TechnicianDTO(obj));
    }

    // Metodo Get para trazer todos os técnicos
    @GetMapping
    public ResponseEntity<List<TechnicianDTO>> findAll() {
        // Cria lista de técnicos
        List<Technician> list = service.findAll();
        // Converte a lista de técnicos em listaDTO
        List<TechnicianDTO> listDTO = list.stream().map(obj -> new TechnicianDTO(obj)).collect(Collectors.toList());
        // Retorna listaDTO
        return ResponseEntity.ok().body(listDTO);
    }

    // Metodo Post para criar um novo técnico
    @PostMapping
    public ResponseEntity<TechnicianDTO> create(@RequestBody TechnicianDTO objDTO) {
        Technician newObj = service.create(objDTO);
        // Pega a uri com o novo id do novo técnico
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

}
