package com.omnisoft.omnihelp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.omnisoft.omnihelp.domain.Person;
import com.omnisoft.omnihelp.domain.Client;
import com.omnisoft.omnihelp.domain.dtos.ClientDTO;
import com.omnisoft.omnihelp.repositories.PersonRepository;
import com.omnisoft.omnihelp.repositories.ClientRepository;
import com.omnisoft.omnihelp.services.exceptions.DataIntegrityViolationException;
import com.omnisoft.omnihelp.services.exceptions.ObjectNotFoundException;

import javax.validation.Valid;

@Service
public class ClientService {
    @Autowired
    private ClientRepository repository;
    @Autowired
    private PersonRepository personRepository;
    @Autowired
	private BCryptPasswordEncoder encoder;

    // Metodo de busca cliente por id
    public Client findById(Integer id) {
        Optional<Client> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id));
    }

    // Metodo de buscar todos os clietes
    public List<Client> findAll() {
        return repository.findAll();
    }

    // Metodo para criação de um novo cliente
    public Client create(ClientDTO objDTO) {
        objDTO.setId(null);
        objDTO.setPassword(encoder.encode(objDTO.getPassword()));
        validCpfAndEmail(objDTO);
        Client newObj = new Client(objDTO);
        return repository.save(newObj);
    }

    // Metodo para atualizção de um cliente
    public Client update(Integer id, @Valid ClientDTO objDTO) {
        objDTO.setId(id);
        Client oldObj = findById(id);
        validCpfAndEmail(objDTO);
        oldObj = new Client(objDTO);
        return repository.save(oldObj);
    }

    // Metodo de deletar cliente
    public void delete(Integer id) {
        Client obj = findById(id);
        if(obj.getCalled().size() > 0) {
            throw new DataIntegrityViolationException("Cliente possui ordens de serviço e não pode ser deletado!");
        }
        repository.deleteById(id);
    }

    // Metodo para verificação de email e cpf existente
    private void validCpfAndEmail(ClientDTO objDTO) {
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
