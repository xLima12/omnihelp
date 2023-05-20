package com.omnisoft.omnihelp.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
