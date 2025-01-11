package com.projeto_final.Kaspper.model;

public enum TipoPessoa {

    FISICA("Física"),
    JURIDICA("Jurídica");

    private final String name;

    TipoPessoa(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
