package com.omnisoft.omnihelp.domain.dtos;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.omnisoft.omnihelp.domain.Technician;
import com.omnisoft.omnihelp.domain.enums.Profile;

import jakarta.validation.constraints.NotNull;

public class TechnicianDTO implements Serializable {
    
    private static final long serialVersionUID = 1L;
    // Atributos classe pessoa
    protected Integer id;
    @NotNull(message = "O campo NOME é obrigatório!")
    protected String name;
    @NotNull(message = "O campo CPF é obrigatório!")
    protected String cpf;
    @NotNull(message = "O campo E-MAIL é obrigatório!")
    protected String email;
    @NotNull(message = "O campo Senha é obrigatório!")
    protected String password;
    protected Set<Integer> profiles = new HashSet<>();
    @JsonFormat(pattern = "dd/MM/yyyy")
    protected LocalDate createDate = LocalDate.now();
    
    // Constructors
    public TechnicianDTO() {
        super();
        addProfile(Profile.TECHNICIAN);
    }

    public TechnicianDTO(Technician obj) {
        this.id = obj.getId();
        this.name = obj.getName();
        this.cpf = obj.getCpf();
        this.email = obj.getEmail();
        this.password = obj.getPassword();
        this.profiles = obj.getProfiles().stream().map(p -> p.getCode()).collect(Collectors.toSet());
        this.createDate = obj.getCreateDate();
        addProfile(Profile.TECHNICIAN);
    }

    // Metodos acessores
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Profile> getProfiles() {
        return profiles.stream().map(p -> Profile.toEnum(p)).collect(Collectors.toSet());
    }

    public void addProfile(Profile profile) {
        this.profiles.add(profile.getCode());
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }



}
