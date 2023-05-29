package com.omnisoft.omnihelp.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.omnisoft.omnihelp.domain.Technician;
import com.omnisoft.omnihelp.domain.enums.Profile;
import com.omnisoft.omnihelp.repositories.TechnicianRepository;

@Service
public class DBServices {
    
    @Autowired
	private TechnicianRepository technicianRepository;
	@Autowired
	private BCryptPasswordEncoder encoder;

    public void instanceDB() {
        Technician tec1 = new Technician(null, "Felipe Lima", "42625330856", "felipe@omnihelp.com", encoder.encode("123"));
		tec1.addProfile(Profile.ADMIN);

		technicianRepository.saveAll(Arrays.asList(tec1));
		
    }

}
