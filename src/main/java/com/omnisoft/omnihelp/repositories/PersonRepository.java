package com.omnisoft.omnihelp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.omnisoft.omnihelp.domain.Person;
import java.util.Optional;


public interface PersonRepository extends JpaRepository<Person, Integer> {
    Optional<Person> findByCpf(String cpf);
    Optional<Person> findByEmail(String email);
}
