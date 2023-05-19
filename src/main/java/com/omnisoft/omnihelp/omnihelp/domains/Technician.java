package com.omnisoft.omnihelp.omnihelp.domains;

import java.util.ArrayList;
import java.util.List;

public class Technician extends Person {
    
    // Lista de chamados
    private List<Called> called = new ArrayList<>();

    // Constructors
    public Technician(List<Called> called) {
        super();
    }

    public Technician(Integer id, String name, String cpf, String email, String password, List<Called> called) {
        super(id, name, cpf, email, password);
    }

    // Metodos acessores
    public List<Called> getCalled() {
        return called;
    }

    public void setCalled(List<Called> called) {
        this.called = called;
    }    

}
