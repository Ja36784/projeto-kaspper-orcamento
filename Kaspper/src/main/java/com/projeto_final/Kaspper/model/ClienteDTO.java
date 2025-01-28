package com.projeto_final.Kaspper.model;

import java.time.LocalDateTime;

public class ClienteDTO {

    private Integer idCliente;
    private String nomeCliente;
    private String cpfCnpj;
    private String email;
    private String telefone;
    private String cep;
    private String endereco;
    private String bairro;
    private String complemento;
    private LocalDateTime dataAlteracao;
    private String responsavelAlteracao;
    private String informativo;

    // Dados do projeto
    private ProjetoDTO projeto;

    public ClienteDTO() {
    }

    public ClienteDTO(Cliente cliente) {
        this.idCliente = cliente.getIdCliente();
        this.nomeCliente = cliente.getNomeCliente();
        this.cpfCnpj = cliente.getCpfCnpj();
        this.email = cliente.getEmail();
        this.telefone = cliente.getTelefone();
        this.cep = cliente.getCep();
        this.endereco = cliente.getEndereco();
        this.bairro = cliente.getBairro();
        this.complemento = cliente.getComplemento();
        this.dataAlteracao = cliente.getDataAlteracao();
        this.responsavelAlteracao = cliente.getResponsavelAlteracao();
        this.informativo = cliente.getInformativo();

        // Mapeia o projeto associado
        if (cliente.getProjeto() != null) {
            this.projeto = new ProjetoDTO(cliente.getProjeto());
        }
    }

    // Getters e Setters
    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public LocalDateTime getDataAlteracao() {
        return dataAlteracao;
    }

    public void setDataAlteracao(LocalDateTime dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }

    public String getResponsavelAlteracao() {
        return responsavelAlteracao;
    }

    public void setResponsavelAlteracao(String responsavelAlteracao) {
        this.responsavelAlteracao = responsavelAlteracao;
    }

    public String getInformativo() {
        return informativo;
    }

    public void setInformativo(String informativo) {
        this.informativo = informativo;
    }

    public ProjetoDTO getProjeto() {
        return projeto;
    }

    public void setProjeto(ProjetoDTO projeto) {
        this.projeto = projeto;
    }
}
