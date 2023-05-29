package com.omnisoft.omnihelp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.omnisoft.omnihelp.services.DBServices;

@Configuration
@Profile("prod")
public class ProdConfig {
    
    @Autowired
    private DBServices dbServices;

    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String value;

    @Bean
    public boolean instanceDB() {
        if(value.equals("create")) {
            this.dbServices.instanceDB();
        }
        return false;
    }

}
