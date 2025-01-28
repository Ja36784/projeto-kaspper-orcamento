package com.projeto_final.Kaspper.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCliente;

    private String nomeCliente;
    @Enumerated(EnumType.STRING)
    private TipoPessoa tipoCliente;

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
    private Status status;

    @OneToOne
    @JoinColumn(name = "id_projeto", nullable = false) // Relacionamento com a tabela Projeto
    private Projeto projeto;

    public Cliente() {
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

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

    public TipoPessoa getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(TipoPessoa tipoCliente) {
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

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
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

    public Cliente(Integer idCliente, String nomeCliente, TipoPessoa tipoCliente, String cpfCnpj, String email,
            String telefone, String cep, String endereco, String bairro, String complemento,
            LocalDateTime dataAlteracao, String responsavelAlteracao, String informativo, Status status,
            Projeto projeto) {
        this.idCliente = idCliente;
        this.nomeCliente = nomeCliente;
        this.tipoCliente = tipoCliente;
        this.cpfCnpj = cpfCnpj;
        this.email = email;
        this.telefone = telefone;
        this.cep = cep;
        this.endereco = endereco;
        this.bairro = bairro;
        this.complemento = complemento;
        this.dataAlteracao = dataAlteracao;
        this.responsavelAlteracao = responsavelAlteracao;
        this.informativo = informativo;
        this.status = status;
        this.projeto = projeto;
    }

    @Override
    public String toString() {
        return "Cliente [idCliente=" + idCliente + ", nomeCliente=" + nomeCliente + ", tipoCliente=" + tipoCliente
                + ", cpfCnpj=" + cpfCnpj + ", email=" + email + ", telefone=" + telefone + ", cep=" + cep
                + ", endereco=" + endereco + ", bairro=" + bairro + ", complemento=" + complemento + ", dataAlteracao="
                + dataAlteracao + ", responsavelAlteracao=" + responsavelAlteracao + ", informativo=" + informativo
                + ", status=" + status + ", projeto=" + projeto + "]";
    }

}
