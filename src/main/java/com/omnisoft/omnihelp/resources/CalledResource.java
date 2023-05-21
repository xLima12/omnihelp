package com.omnisoft.omnihelp.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.omnisoft.omnihelp.domain.Called;
import com.omnisoft.omnihelp.domain.dtos.CalledDTO;
import com.omnisoft.omnihelp.services.CalledService;

@RestController
@RequestMapping(value = "/called")
public class CalledResource {
    
    @Autowired
    private CalledService service;

    // Metodo get para busca de chamados por id
    @GetMapping(value = "/{id}")
    public ResponseEntity<CalledDTO> findById(@PathVariable Integer id) {
        Called obj = service.findById(id);
        return ResponseEntity.ok().body(new CalledDTO(obj));
    }

    // Metodo get para buscar todos os chamados
    @GetMapping
    public ResponseEntity<List<CalledDTO>> findAll() {
        List<Called> list = service.findAll();
        List<CalledDTO> listDTO = list.stream().map(obj -> new CalledDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

}
