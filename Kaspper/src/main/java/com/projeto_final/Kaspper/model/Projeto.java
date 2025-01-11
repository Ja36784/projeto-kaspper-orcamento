package com.projeto_final.Kaspper.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_projeto")
public class Projeto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public Projeto() {
    }

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

    public Projeto(Integer idProjeto, Integer quantidadeFuncionalidades, String complexidadeProjeto,
            String prazoProjeto, Boolean vaiTerIntegracao, Boolean vaiTerAutomacao, Integer quantasIntegracao,
            Integer quantasAutomacao, Double valorFuncionalidade, Double valorAutomacao, Double valorIntegracao,
            Double valorPrazoComplexidade, Double valorPrazoProjeto, Integer prazoEstimado, Double custoTotal) {
        this.idProjeto = idProjeto;
        this.quantidadeFuncionalidades = quantidadeFuncionalidades;
        this.complexidadeProjeto = complexidadeProjeto;
        this.prazoProjeto = prazoProjeto;
        this.vaiTerIntegracao = vaiTerIntegracao;
        this.vaiTerAutomacao = vaiTerAutomacao;
        this.quantasIntegracao = quantasIntegracao;
        this.quantasAutomacao = quantasAutomacao;
        this.valorFuncionalidade = valorFuncionalidade;
        this.valorAutomacao = valorAutomacao;
        this.valorIntegracao = valorIntegracao;
        this.valorPrazoComplexidade = valorPrazoComplexidade;
        this.valorPrazoProjeto = valorPrazoProjeto;
        this.prazoEstimado = prazoEstimado;
        this.custoTotal = custoTotal;
    }

    public String calcularComplexidade(Integer quantidadeFuncionalidades) {
        if (quantidadeFuncionalidades >= 1 && quantidadeFuncionalidades <= 10) {
            return "Baixa";
        } else if (quantidadeFuncionalidades > 10 && quantidadeFuncionalidades <= 20) {
            return "Média";
        } else {
            return "Alta";
        }
    }

}
