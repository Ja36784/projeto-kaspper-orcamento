package com.projeto_final.Kaspper.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

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

    @ManyToOne
    @JoinColumn(name = "id_projeto", nullable = false) // Relacionamento com a tabela Projeto
    private Projeto projeto;

    public Cliente() {
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

    public Cliente(Integer idCliente, String nomeCliente, TipoPessoa tipoCliente,
            @NotBlank(message = "O CPF não pode estar em branco") String cpfCnpj, String email, String telefone,
            String cep, String endereco, String bairro, String complemento, Projeto projeto) {
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
        this.projeto = projeto;
    }

    @Override
    public String toString() {
        return "Cliente [idCliente=" + idCliente + ", nomeCliente=" + nomeCliente + ", tipoCliente=" + tipoCliente
                + ", cpfCnpj=" + cpfCnpj + ", email=" + email + ", telefone=" + telefone + ", cep=" + cep
                + ", endereco=" + endereco + ", bairro=" + bairro + ", complemento=" + complemento + ", projeto="
                + projeto + "]";
    }
}
