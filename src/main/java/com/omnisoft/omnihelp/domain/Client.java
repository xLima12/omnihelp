package com.omnisoft.omnihelp.domain;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.omnisoft.omnihelp.domain.enums.Profile;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
public class Client extends Person {
    private static final long serialVersionUID = 1L;
    
    // Lista de chamados
    @JsonIgnore
    @OneToMany(mappedBy = "client")
    private List<Called> called = new ArrayList<>();

    // Constructors
    public Client() {
        super();
        addProfile(Profile.CLIENT);
    }

    public Client(Integer id, String name, String cpf, String email, String password) {
        super(id, name, cpf, email, password);
        addProfile(Profile.CLIENT);
    }

    // Metodos acessores
    public List<Called> getCalled() {
        return called;
    }

    public void setCalled(List<Called> called) {
        this.called = called;
    }

    

}
