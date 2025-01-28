package com.projeto_final.Kaspper.model;

public class ProjetoDTO {

    private Integer idProjeto;
    private Integer quantidadeFuncionalidades;
    private String complexidadeProjeto;
    private String prazoProjeto;
    private Boolean vaiTerIntegracao;
    private Boolean vaiTerAutomacao;
    private Integer quantasIntegracao;
    private Integer quantasAutomacao;
    private Double valorFuncionalidade;
    private Double valorAutomacao;
    private Double valorIntegracao;
    private Double valorPrazoComplexidade;
    private Double valorPrazoProjeto;
    private Integer prazoEstimado;
    private Double custoTotal;

    public ProjetoDTO() {
    }

    public ProjetoDTO(Projeto projeto) {
        this.idProjeto = projeto.getIdProjeto();
        this.quantidadeFuncionalidades = projeto.getQuantidadeFuncionalidades();
        this.complexidadeProjeto = projeto.getComplexidadeProjeto();
        this.prazoProjeto = projeto.getPrazoProjeto();
        this.vaiTerIntegracao = projeto.getVaiTerIntegracao();
        this.vaiTerAutomacao = projeto.getVaiTerAutomacao();
        this.quantasIntegracao = projeto.getQuantasIntegracao();
        this.quantasAutomacao = projeto.getQuantasAutomacao();
        this.valorFuncionalidade = projeto.getValorFuncionalidade();
        this.valorAutomacao = projeto.getValorAutomacao();
        this.valorIntegracao = projeto.getValorIntegracao();
        this.valorPrazoComplexidade = projeto.getValorPrazoComplexidade();
        this.valorPrazoProjeto = projeto.getValorPrazoProjeto();
        this.prazoEstimado = projeto.getPrazoEstimado();
        this.custoTotal = projeto.getCustoTotal();
    }

    // Getters e Setters
    public Integer getIdProjeto() {
        return idProjeto;
    }

    public void setIdProjeto(Integer idProjeto) {
        this.idProjeto = idProjeto;
    }

    public Integer getQuantidadeFuncionalidades() {
        return quantidadeFuncionalidades;
    }

    public void setQuantidadeFuncionalidades(Integer quantidadeFuncionalidades) {
        this.quantidadeFuncionalidades = quantidadeFuncionalidades;
    }

    public String getComplexidadeProjeto() {
        return complexidadeProjeto;
    }

    public void setComplexidadeProjeto(String complexidadeProjeto) {
        this.complexidadeProjeto = complexidadeProjeto;
    }

    public String getPrazoProjeto() {
        return prazoProjeto;
    }

    public void setPrazoProjeto(String prazoProjeto) {
        this.prazoProjeto = prazoProjeto;
    }

    public Boolean getVaiTerIntegracao() {
        return vaiTerIntegracao;
    }

    public void setVaiTerIntegracao(Boolean vaiTerIntegracao) {
        this.vaiTerIntegracao = vaiTerIntegracao;
    }

    public Boolean getVaiTerAutomacao() {
        return vaiTerAutomacao;
    }

    public void setVaiTerAutomacao(Boolean vaiTerAutomacao) {
        this.vaiTerAutomacao = vaiTerAutomacao;
    }

    public Integer getQuantasIntegracao() {
        return quantasIntegracao;
    }

    public void setQuantasIntegracao(Integer quantasIntegracao) {
        this.quantasIntegracao = quantasIntegracao;
    }

    public Integer getQuantasAutomacao() {
        return quantasAutomacao;
    }

    public void setQuantasAutomacao(Integer quantasAutomacao) {
        this.quantasAutomacao = quantasAutomacao;
    }

    public Double getValorFuncionalidade() {
        return valorFuncionalidade;
    }

    public void setValorFuncionalidade(Double valorFuncionalidade) {
        this.valorFuncionalidade = valorFuncionalidade;
    }

    public Double getValorAutomacao() {
        return valorAutomacao;
    }

    public void setValorAutomacao(Double valorAutomacao) {
        this.valorAutomacao = valorAutomacao;
    }

    public Double getValorIntegracao() {
        return valorIntegracao;
    }

    public void setValorIntegracao(Double valorIntegracao) {
        this.valorIntegracao = valorIntegracao;
    }

    public Double getValorPrazoComplexidade() {
        return valorPrazoComplexidade;
    }

    public void setValorPrazoComplexidade(Double valorPrazoComplexidade) {
        this.valorPrazoComplexidade = valorPrazoComplexidade;
    }

    public Double getValorPrazoProjeto() {
        return valorPrazoProjeto;
    }

    public void setValorPrazoProjeto(Double valorPrazoProjeto) {
        this.valorPrazoProjeto = valorPrazoProjeto;
    }

    public Integer getPrazoEstimado() {
        return prazoEstimado;
    }

    public void setPrazoEstimado(Integer prazoEstimado) {
        this.prazoEstimado = prazoEstimado;
    }

    public Double getCustoTotal() {
        return custoTotal;
    }

    public void setCustoTotal(Double custoTotal) {
        this.custoTotal = custoTotal;
    }
}
