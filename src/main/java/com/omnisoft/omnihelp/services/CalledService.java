package com.omnisoft.omnihelp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.omnisoft.omnihelp.domain.Called;
import com.omnisoft.omnihelp.domain.Client;
import com.omnisoft.omnihelp.domain.Technician;
import com.omnisoft.omnihelp.domain.dtos.CalledDTO;
import com.omnisoft.omnihelp.domain.enums.Priority;
import com.omnisoft.omnihelp.domain.enums.Status;
import com.omnisoft.omnihelp.repositories.CalledRespository;
import com.omnisoft.omnihelp.services.exceptions.ObjectNotFoundException;

import jakarta.validation.Valid;

@Service
public class CalledService {
    
    @Autowired
    private CalledRespository respository;
    @Autowired
    private TechnicianService technicianService;
    @Autowired
    private ClientService clientService;

    // Retorna o chamado por id
    public Called findById(Integer id) {
        Optional<Called> obj = respository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! " + id));
    }

    // Retorna lista com todos os chamados
    public List<Called> findAll() {
        return respository.findAll();
    }

    // Metodo que chama a criação de um novo chamado
    public Called create(@Valid CalledDTO objDTO) {
        /*
            Recebe o objDTO e manda para a criação do novo chamado, 
            quando é retornado o novo chamado criado, ele salva e já retorna o novo chamado.
        */
        return respository.save(newCalled(objDTO));
    }

    // Metodo de criação ou atualização de um novo chamado
    private Called newCalled(CalledDTO obj) {
        Technician technician = technicianService.findById(obj.getTechnician());
        Client client= clientService.findById(obj.getClient());

        Called called = new Called();
        
        // Verifica se é um novo chamado ou uma atualização de um chamado
        if(obj.getId() != null) {
            // Se possuir um id atualiza o chamado
            called.setId(obj.getId());
        }

        // Se não possuir id cria um novo chamado
        called.setTechnician(technician);
        called.setClient(client);
        /* 
            Recebe o codigo da prioridade e passa o codigo da prioridade para a classe toEnum, 
            que converte para o nome da prioridade. O mesmo é feito com Status.
        */
        called.setPriority(Priority.toEnum(obj.getPriority()));
        called.setStatus(Status.toEnum(obj.getStatus()));
        called.setTitle(obj.getTitle());
        called.setComments(obj.getComments());
        
        return called;
    }

}
