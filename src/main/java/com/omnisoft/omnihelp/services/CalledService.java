package com.omnisoft.omnihelp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.omnisoft.omnihelp.domain.Called;
import com.omnisoft.omnihelp.repositories.CalledRespository;
import com.omnisoft.omnihelp.services.exceptions.ObjectNotFoundException;

@Service
public class CalledService {
    
    @Autowired
    private CalledRespository respository;

    // Retorna o chamado por id
    public Called findById(Integer id) {
        Optional<Called> obj = respository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! " + id));
    }

    // Retorna lista com todos os chamados
    public List<Called> findAll() {
        return respository.findAll();
    }

}
