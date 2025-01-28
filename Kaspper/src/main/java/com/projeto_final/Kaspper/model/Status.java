package com.projeto_final.Kaspper.model;

public enum Status {

    CONCLUIDO("Concluído"),
    PENDENTE("Jurídica"),
    AGUARDANDO_VALIDACAO("Aguardando validação"),
    EM_ANALISE_COMERCIAL("Em Análise Comercial");

    private final String name;

    Status(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
