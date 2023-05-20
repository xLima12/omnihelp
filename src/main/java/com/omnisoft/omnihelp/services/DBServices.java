package com.omnisoft.omnihelp.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.omnisoft.omnihelp.domain.Called;
import com.omnisoft.omnihelp.domain.Client;
import com.omnisoft.omnihelp.domain.Technician;
import com.omnisoft.omnihelp.domain.enums.Priority;
import com.omnisoft.omnihelp.domain.enums.Profile;
import com.omnisoft.omnihelp.domain.enums.Status;
import com.omnisoft.omnihelp.repositories.CalledRespository;
import com.omnisoft.omnihelp.repositories.ClientRepository;
import com.omnisoft.omnihelp.repositories.TechnicianRepository;

@Service
public class DBServices {
    
    @Autowired
	private TechnicianRepository technicianRepository;
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private CalledRespository calledRepository;

    public void instanceDB() {
        Technician tec1 = new Technician(null, "Valdir Cezar", "164.132.860-67", "teste@teste.com", "123");
		tec1.addProfile(Profile.ADMIN);

		Client cli1 = new Client(null, "Felipe Lima", "42625330856", "felipe@felipe.com", "123");

		Called c1 = new Called(null, Priority.MEDIUM, Status.PROGESS, "Chamado 01", "Primeiro Chamado", tec1, cli1);

		technicianRepository.saveAll(Arrays.asList(tec1));
		clientRepository.saveAll(Arrays.asList(cli1));
		calledRepository.saveAll(Arrays.asList(c1));
    }

}
