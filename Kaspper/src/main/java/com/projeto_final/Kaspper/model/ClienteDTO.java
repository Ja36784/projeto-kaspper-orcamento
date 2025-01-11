package com.projeto_final.Kaspper.model;

public class ClienteDTO {
    private String nomeCliente;
    private String tipoCliente;
    private String cpfCnpj;
    private String email;
    private String telefone;
    private String cep;
    private String tipoProjeto;
    private Integer quantidadeFuncionalidades;
    private String complexidadeProjeto;
    private String prazoProjeto;
    private Boolean vaiTerIntegracao;
    private Boolean vaiTerAutomacao;
    private Integer quantasIntegracao;
    private Integer quantasAutomacao;
    private Double custoTotal;
    public String getNomeCliente() {
        return nomeCliente;
    }
    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }
    public String getTipoCliente() {
        return tipoCliente;
    }
    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }
    public String getCpfCnpj() {
        return cpfCnpj;
    }
    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public String getCep() {
        return cep;
    }
    public void setCep(String cep) {
        this.cep = cep;
    }
    public String getTipoProjeto() {
        return tipoProjeto;
    }
    public void setTipoProjeto(String tipoProjeto) {
        this.tipoProjeto = tipoProjeto;
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
    public Double getCustoTotal() {
        return custoTotal;
    }
    public void setCustoTotal(Double custoTotal) {
        this.custoTotal = custoTotal;
    }

    
}
