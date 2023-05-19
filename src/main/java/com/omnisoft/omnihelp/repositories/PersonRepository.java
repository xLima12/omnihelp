package com.omnisoft.omnihelp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.omnisoft.omnihelp.domain.Person;

public interface PersonRepository extends JpaRepository<Person, Integer> {
    
}
