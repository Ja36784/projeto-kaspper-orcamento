package com.projeto_final.Kaspper.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.projeto_final.Kaspper.model.Cliente;
import com.projeto_final.Kaspper.model.ClienteDTO;
import com.projeto_final.Kaspper.model.Projeto;
import com.projeto_final.Kaspper.model.ProjetoDTO;
import com.projeto_final.Kaspper.service.ClienteService;
import com.projeto_final.Kaspper.service.PDFGeneratorService;

import jakarta.validation.Valid;

@RestController
public class ClienteRestController {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private PDFGeneratorService pdfGeneratorService;

    @PostMapping("/api/clientes/novo")
    public ResponseEntity<String> salvarClienteEProjeto(@RequestBody @Valid ClienteDTO clienteDTO) {
        Cliente cliente = new Cliente();
        cliente.setIdCliente(clienteDTO.getIdCliente());
        cliente.setNomeCliente(clienteDTO.getNomeCliente());
        cliente.setCpfCnpj(clienteDTO.getCpfCnpj());
        cliente.setEmail(clienteDTO.getEmail());
        cliente.setTelefone(clienteDTO.getTelefone());
        cliente.setCep(clienteDTO.getCep());
        cliente.setEndereco(clienteDTO.getEndereco());
        cliente.setBairro(clienteDTO.getBairro());
        cliente.setComplemento(clienteDTO.getComplemento());
        cliente.setDataAlteracao(clienteDTO.getDataAlteracao());
        cliente.setResponsavelAlteracao(clienteDTO.getResponsavelAlteracao());
        cliente.setInformativo(clienteDTO.getInformativo());

        if (clienteDTO.getProjeto() != null) {
            Projeto projeto = new Projeto();
            ProjetoDTO projetoDTO = clienteDTO.getProjeto();

            projeto.setIdProjeto(projetoDTO.getIdProjeto());
            projeto.setQuantidadeFuncionalidades(projetoDTO.getQuantidadeFuncionalidades());
            projeto.setComplexidadeProjeto(projetoDTO.getComplexidadeProjeto());
            projeto.setPrazoProjeto(projetoDTO.getPrazoProjeto());
            projeto.setVaiTerIntegracao(projetoDTO.getVaiTerIntegracao());
            projeto.setVaiTerAutomacao(projetoDTO.getVaiTerAutomacao());
            projeto.setQuantasIntegracao(projetoDTO.getQuantasIntegracao());
            projeto.setQuantasAutomacao(projetoDTO.getQuantasAutomacao());
            projeto.setValorFuncionalidade(projetoDTO.getValorFuncionalidade());
            projeto.setValorAutomacao(projetoDTO.getValorAutomacao());
            projeto.setValorIntegracao(projetoDTO.getValorIntegracao());
            projeto.setValorPrazoComplexidade(projetoDTO.getValorPrazoComplexidade());
            projeto.setValorPrazoProjeto(projetoDTO.getValorPrazoProjeto());
            projeto.setPrazoEstimado(projetoDTO.getPrazoEstimado());
            projeto.setCustoTotal(projetoDTO.getCustoTotal());

            cliente.setProjeto(projeto);
        }

        Cliente clienteSalvo = clienteService.salvar(cliente);

        byte[] pdfData = pdfGeneratorService.generateOrcamentoPDFWithTemplate(clienteSalvo, clienteSalvo.getProjeto());
        pdfGeneratorService.sendEmailWithPDF(
                clienteSalvo.getEmail(),
                "Orçamento Gerado",
                "Segue em anexo o orçamento gerado.",
                pdfData,
                "orcamento.pdf"
        );

        return ResponseEntity.ok("Cliente e projeto cadastrados com sucesso.");
    }

}
