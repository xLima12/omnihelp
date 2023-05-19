package com.omnisoft.omnihelp.domain.enums;

public enum Status {

    // Tipos de status
    OPEN(0, "OPEN"), PROGESS(1, "PROGESS"), CLOSED(2, "CLOSED");
    
    // Variáveis de código e descrição do status do chamado.
    private Integer code;
    private String description;

    // Constructor Status
    private Status(Integer cod, String desc) {
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

    // Metodo Status
    public static Status toEnum(Integer cod) {
        // Verifica se o código está nulo
        if(cod == null) {
            return null;
        }
        
        // Percorre cada um dos status
        for(Status x: Status.values()) {
            // Verifica se o status informado é existente
            if(cod.equals(x.getCode())) {
                return x;
            }
        }

        // Mensagem de erro caso seja informado um status inválido
        throw new IllegalArgumentException("Status invalid!");

    }

}