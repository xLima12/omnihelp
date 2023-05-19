package com.omnisoft.omnihelp.omnihelp.domains;

import java.util.ArrayList;
import java.util.List;

public class Client extends Person {
    
    // Lista de chamados
    private List<Called> called = new ArrayList<>();

    // Constructors
    public Client() {
        super();
    }

    public Client(Integer id, String name, String cpf, String email, String password) {
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
