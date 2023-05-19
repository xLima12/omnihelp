package com.omnisoft.omnihelp.omnihelp.domains;

import java.time.LocalDate;

import com.omnisoft.omnihelp.omnihelp.domains.enums.Priority;
import com.omnisoft.omnihelp.omnihelp.domains.enums.Status;

public class Called {
    
    // Atributos classe chamado
    private Integer id;
    private LocalDate openingDate = LocalDate.now();
    private LocalDate closingDate;
    private Priority priority;
    private Status status;
    private String title;
    private String comments;

    // Atributo classe técnico
    private Technician technician;
    // Atributo classe cliente
    private Client client;
    
    // Constructors
    public Called() {
        super();
    }

    public Called(Integer id, Priority priority, Status status, String title, String comments, Technician technician,
            Client client) {
        this.id = id;
        this.priority = priority;
        this.status = status;
        this.title = title;
        this.comments = comments;
        this.technician = technician;
        this.client = client;
    }

    // Metodos acessores
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(LocalDate openingDate) {
        this.openingDate = openingDate;
    }

    public LocalDate getClosingDate() {
        return closingDate;
    }

    public void setClosingDate(LocalDate closingDate) {
        this.closingDate = closingDate;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Technician getTechnician() {
        return technician;
    }

    public void setTechnician(Technician technician) {
        this.technician = technician;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    // Compara os objetos pelo valor do atributo id e não pelo valor em memória
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Called other = (Called) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}
