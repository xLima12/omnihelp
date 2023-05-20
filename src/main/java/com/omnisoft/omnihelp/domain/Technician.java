package com.omnisoft.omnihelp.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.omnisoft.omnihelp.domain.dtos.TechnicianDTO;
import com.omnisoft.omnihelp.domain.enums.Profile;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
public class Technician extends Person {
    private static final long serialVersionUID = 1L;

    // Lista de chamados
    @JsonIgnore
    @OneToMany(mappedBy = "technician")
    private List<Called> called = new ArrayList<>();

    // Constructors
    public Technician() {
        super();
        addProfile(Profile.TECHNICIAN);
    }

    public Technician(Integer id, String name, String cpf, String email, String password) {
        super(id, name, cpf, email, password);
        addProfile(Profile.TECHNICIAN);
    }

    // Constructor TechnicianDTO
    public Technician(TechnicianDTO obj) {
        super();
        this.id = obj.getId();
        this.name = obj.getName();
        this.cpf = obj.getCpf();
        this.email = obj.getEmail();
        this.password = obj.getPassword();
        this.profiles = obj.getProfiles().stream().map(p -> p.getCode()).collect(Collectors.toSet());
        this.createDate = obj.getCreateDate();
    }

    // Metodos acessores
    public List<Called> getCalled() {
        return called;
    }

    public void setCalled(List<Called> called) {
        this.called = called;
    }    

}
