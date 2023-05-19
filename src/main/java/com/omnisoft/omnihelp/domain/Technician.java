package com.omnisoft.omnihelp.domain;

import java.util.ArrayList;
import java.util.List;

import com.omnisoft.omnihelp.domain.enums.Profile;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
public class Technician extends Person {
    private static final long serialVersionUID = 1L;

    // Lista de chamados
    @OneToMany(mappedBy = "technician")
    private List<Called> called = new ArrayList<>();

    // Constructors
    public Technician(List<Called> called) {
        super();
        addProfile(Profile.TECHNICIAN);
    }

    public Technician(Integer id, String name, String cpf, String email, String password, List<Called> called) {
        super(id, name, cpf, email, password);
        addProfile(Profile.TECHNICIAN);
    }

    // Metodos acessores
    public List<Called> getCalled() {
        return called;
    }

    public void setCalled(List<Called> called) {
        this.called = called;
    }    

}
