package com.project.traveler.Models;

public enum Variveis {
    ATIVO("ativo"),
    INATIVO("inativo");

    private final String status;
    Variveis(String status){
        this.status = status;
    }
    public String getStatus() {
        return status;
    }
}
