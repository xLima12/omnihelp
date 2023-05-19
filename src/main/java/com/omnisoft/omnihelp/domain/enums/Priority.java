package com.omnisoft.omnihelp.domain.enums;

public enum Priority {

    // Tipos de prioridade
    LOW(0, "LOW"), MEDIUM(1, "MEDIUM"), HIGH(2, "HIGH");
    
    // Variáveis de código e descrição da prioridade do chamado.
    private Integer code;
    private String description;

    // Constructor Priority
    private Priority(Integer cod, String desc) {
        this.code = cod;
        this.description = desc;
    }

    // Metodos de acesso Getters e Setters
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Metodo Priority
    public static Priority toEnum(Integer cod) {
        // Verifica se o código está nulo
        if(cod == null) {
            return null;
        }
        
        // Percorre cada um dos status
        for(Priority x: Priority.values()) {
            // Verifica se a prioridade informada é existente
            if(cod.equals(x.getCode())) {
                return x;
            }
        }

        // Mensagem de erro caso seja informado uma prioridade inválida
        throw new IllegalArgumentException("Priority invalid!");

    }

}