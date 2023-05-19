package com.omnisoft.omnihelp.domain.enums;

public enum Profile {

    // Tipos de perfis
    ADMIN(0, "ROLE_ADMIN"), CLIENT(1, "ROLE_CLIENT"), TECHNICIAN(2, "ROLE_TECHNICIAN");
    
    // Variáveis de código e descrição do perfil de usuário.
    private Integer code;
    private String description;

    // Constructor profile
    private Profile(Integer cod, String desc) {
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

    // Metodo do perfil
    public static Profile toEnum(Integer cod) {
        // Verifica se o código está nulo
        if(cod == null) {
            return null;
        }
        
        // Percorre cada um dos perfis
        for(Profile x: Profile.values()) {
            // Verifica se o perfil informado é existente
            if(cod.equals(x.getCode())) {
                return x;
            }
        }

        // Mensagem de erro caso seja informado um perfil inválido
        throw new IllegalArgumentException("Profile invalid!");

    }

}