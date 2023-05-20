package com.omnisoft.omnihelp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.omnisoft.omnihelp.domain.Person;
import com.omnisoft.omnihelp.domain.Technician;
import com.omnisoft.omnihelp.domain.dtos.TechnicianDTO;
import com.omnisoft.omnihelp.repositories.PersonRepository;
import com.omnisoft.omnihelp.repositories.TechnicianRepository;
import com.omnisoft.omnihelp.services.exceptions.DataIntegrityViolationException;
import com.omnisoft.omnihelp.services.exceptions.ObjectNotFoundException;

import jakarta.validation.Valid;

@Service
public class TechnicianService {
    @Autowired
    private TechnicianRepository repository;
    @Autowired
    private PersonRepository personRepository;

    // Metodo de busca por id
    public Technician findById(Integer id) {
        Optional<Technician> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id));
    }

    // Metodo de buscar todos os Tecnicos
    public List<Technician> findAll() {
        return repository.findAll();
    }

    // Metodo para criação de um novo técnico
    public Technician create(TechnicianDTO objDTO) {
        objDTO.setId(null);
        validCpfAndEmail(objDTO);
        Technician newObj = new Technician(objDTO);
        return repository.save(newObj);
    }

    // Metodo para atualizção de um técnico
    public Technician update(Integer id, @Valid TechnicianDTO objDTO) {
        objDTO.setId(id);
        Technician oldObj = findById(id);
        validCpfAndEmail(objDTO);
        oldObj = new Technician(objDTO);
        return repository.save(oldObj);
    }

    // Metodo de deletar técnico
    public void delete(Integer id) {
        Technician obj = findById(id);
        if(obj.getCalled().size() > 0) {
            throw new DataIntegrityViolationException("Técnico possui ordens de serviço e não pode ser deletado!");
        }
        repository.deleteById(id);
    }

    // Metodo para verificação de email e cpf existente
    private void validCpfAndEmail(TechnicianDTO objDTO) {
        Optional<Person> obj = personRepository.findByCpf(objDTO.getCpf());
        // Verifica se o cpf está no obj e se o id do obj é diferente do id passado para cadastro
        if(obj.isPresent() && obj.get().getId() != objDTO.getId()) {
            throw new DataIntegrityViolationException("CPF já cadastrado no sistema!");
        }
        // Verifica se o cpf está no obj e se o id do obj é diferente do id passado para cadastro
        obj = personRepository.findByEmail(objDTO.getEmail());
        if(obj.isPresent() && obj.get().getId() != objDTO.getId()) {
            throw new DataIntegrityViolationException("E-mail já cadastrado no sistema!");
        }
    }

}
