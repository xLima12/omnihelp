package com.omnisoft.omnihelp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.omnisoft.omnihelp.domain.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {
    
}
