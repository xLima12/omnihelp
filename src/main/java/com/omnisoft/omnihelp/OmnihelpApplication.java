package com.omnisoft.omnihelp;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.omnisoft.omnihelp.domain.Called;
import com.omnisoft.omnihelp.domain.Client;
import com.omnisoft.omnihelp.domain.Technician;
import com.omnisoft.omnihelp.domain.enums.Priority;
import com.omnisoft.omnihelp.domain.enums.Profile;
import com.omnisoft.omnihelp.domain.enums.Status;
import com.omnisoft.omnihelp.repositories.CalledRespository;
import com.omnisoft.omnihelp.repositories.ClientRepository;
import com.omnisoft.omnihelp.repositories.TechnicianRepository;

@SpringBootApplication
public class OmnihelpApplication implements CommandLineRunner {

	@Autowired
	private TechnicianRepository technicianRepository;
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private CalledRespository calledRepository;

	public static void main(String[] args) {
		SpringApplication.run(OmnihelpApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Technician tec1 = new Technician(null, "Valdir Cezar", "42238858861", "teste@teste.com", "123");
		tec1.addProfile(Profile.ADMIN);

		Client cli1 = new Client(null, "Felipe Lima", "42625330856", "felipe@felipe.com", "123");

		Called c1 = new Called(null, Priority.MEDIUM, Status.PROGESS, "Chamado 01", "Primeiro Chamado", tec1, cli1);

		technicianRepository.saveAll(Arrays.asList(tec1));
		clientRepository.saveAll(Arrays.asList(cli1));
		calledRepository.saveAll(Arrays.asList(c1));

	}

}
