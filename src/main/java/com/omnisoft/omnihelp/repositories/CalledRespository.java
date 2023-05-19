package com.omnisoft.omnihelp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.omnisoft.omnihelp.domain.Called;

public interface CalledRespository extends JpaRepository<Called, Integer> {
    
}
