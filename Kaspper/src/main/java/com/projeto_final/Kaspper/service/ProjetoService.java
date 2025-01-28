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
        if (complexidade == null || complexidade.isEmpty()) {
            complexidade = "baixa";  // Definir um valor padrão para complexidade
        }
        switch (complexidade.toLowerCase()) {
            case "baixa":
                return 2500.0;
            case "media":
                return 3000.0;
            case "alta":
                return 5000.0;
            default:
                return 0.0;
        }
    }

    private double calcularValorPrazo(String prazo) {
        if (prazo == null) {
            return 0.0; // Ou outro valor padrão se prazo for null
        }

        switch (prazo.toLowerCase()) {
            case "flexivel":
                return 3000.0;
            case "moderado":
                return 4000.0;
            case "urgente":
                return 5000.0;
            default:
                return 0.0;
        }
    }

    private double calcularCustoFuncionalidade(Integer quantidadeFuncionalidades) {
        double valorHoraFuncionalidade = 85.0;
        return quantidadeFuncionalidades * 42 * valorHoraFuncionalidade;
    }

    private double calcularCustoAutomacao(Boolean vaiTerAutomacao, Integer quantasAutomacao) {
        if (vaiTerAutomacao == null || quantasAutomacao == null) {
            return 0.0; // Retorna 0 caso não tenha automação ou quantasAutomacao seja null
        }
        double valorHoraAutomacao = 89.0;
        return quantasAutomacao * 53 * valorHoraAutomacao;
    }

    private double calcularCustoIntegracao(Boolean vaiTerIntegracao, Integer quantasIntegracao) {
        if (vaiTerIntegracao == null || quantasIntegracao == null) {
            return 0.0; // Retorna 0 caso não tenha integração ou quantasIntegracao seja null
        }
        double valorHoraIntegracao = 90.0;
        return quantasIntegracao * 55 * valorHoraIntegracao;
    }

    private int calcularPrazoTotal(Projeto projeto) {
        int horasFuncionalidade = projeto.getQuantidadeFuncionalidades() * 45;

        // Verificar se quantasAutomacao não é null, caso contrário, atribuir 0
        int horasAutomacao = (projeto.getQuantasAutomacao() != null ? projeto.getQuantasAutomacao() : 0) * 52;

        // Verificar se quantasIntegracao não é null, caso contrário, atribuir 0
        int horasIntegracao = (projeto.getQuantasIntegracao() != null ? projeto.getQuantasIntegracao() : 0) * 51;

        return horasFuncionalidade + horasAutomacao + horasIntegracao;
    }
}
