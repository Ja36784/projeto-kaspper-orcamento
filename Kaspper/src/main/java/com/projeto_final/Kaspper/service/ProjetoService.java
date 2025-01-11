package com.projeto_final.Kaspper.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto_final.Kaspper.model.Projeto;
import com.projeto_final.Kaspper.repository.ProjetoRepository;

@Service
public class ProjetoService {

    @Autowired
    private ProjetoRepository projetoRepository;

    public Projeto salvar(Projeto projeto) {
        calcularDetalhesProjeto(projeto);
        return projetoRepository.save(projeto);
    }
    private void calcularDetalhesProjeto(Projeto projeto) {
        projeto.setValorFuncionalidade(calcularCustoFuncionalidade(projeto.getQuantidadeFuncionalidades()));
        projeto.setValorAutomacao(calcularCustoAutomacao(projeto.getVaiTerAutomacao(), projeto.getQuantasAutomacao()));
        projeto.setValorIntegracao(calcularCustoIntegracao(projeto.getVaiTerIntegracao(), projeto.getQuantasIntegracao()));

        // Cálculos de complexidade e prazo
        projeto.setValorPrazoComplexidade(calcularValorComplexidade(projeto.getComplexidadeProjeto()));
        projeto.setValorPrazoProjeto(calcularValorPrazo(projeto.getPrazoProjeto()));

        double custoTotal = projeto.getValorFuncionalidade()
                + projeto.getValorAutomacao()
                + projeto.getValorIntegracao()
                + projeto.getValorPrazoComplexidade()
                + projeto.getValorPrazoProjeto();
        projeto.setCustoTotal(custoTotal);

        projeto.setPrazoEstimado(calcularPrazoTotal(projeto));
    }

    private double calcularValorComplexidade(String complexidade) {
        switch (complexidade.toLowerCase()) {
            case "baixa":
                return 1000.0; 
            case "media":
                return 2000.0;
            case "alta":
                return 3000.0; 
            default:
                return 0.0;
        }
    }

    private double calcularValorPrazo(String prazo) {
        switch (prazo.toLowerCase()) {
            case "flexivel":
                return 2000.0; 
            case "moderado":
                return 3000.0; 
            case "urgente":
                return 5000.0; 
            default:
                return 0.0;
        }
    }

    private double calcularCustoFuncionalidade(Integer quantidadeFuncionalidades) {
        double valorHoraFuncionalidade = 100.0;
        return quantidadeFuncionalidades * 45 * valorHoraFuncionalidade;
    }

    private double calcularCustoAutomacao(Boolean vaiTerAutomacao, Integer quantasAutomacao) {
        double valorHoraAutomacao = 120.0;
        return quantasAutomacao * 55 * valorHoraAutomacao;
    }

    private double calcularCustoIntegracao(Boolean vaiTerIntegracao, Integer quantasIntegracao) {
        double valorHoraAutomacao = 120.0;
        return quantasIntegracao * 55 * valorHoraAutomacao;
    }

    private int calcularPrazoTotal(Projeto projeto) {
        int horasFuncionalidade = projeto.getQuantidadeFuncionalidades() * 45;
        int horasAutomacao = projeto.getQuantasAutomacao() * 55;
        int horasIntegracao = projeto.getQuantasIntegracao() * 55;

        return horasFuncionalidade + horasAutomacao + horasIntegracao;
    }
}
