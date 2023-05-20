package com.omnisoft.omnihelp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.omnisoft.omnihelp.domain.Technician;
import com.omnisoft.omnihelp.repositories.TechnicianRepository;
import com.omnisoft.omnihelp.services.exceptions.ObjectNotFoundException;

@Service
public class TechnicianService {
    @Autowired
    private TechnicianRepository repository;

    // Metodo de busca por id
    public Technician findById(Integer id) {
        Optional<Technician> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id));
    }

    // Metodo de buscar todos os Tecnicos
    public List<Technician> findAll() {
        return repository.findAll();
    }

}
