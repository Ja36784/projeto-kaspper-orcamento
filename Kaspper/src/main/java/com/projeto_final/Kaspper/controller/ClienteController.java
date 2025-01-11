package com.projeto_final.Kaspper.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.projeto_final.Kaspper.model.Cliente;
import com.projeto_final.Kaspper.model.Projeto;
import com.projeto_final.Kaspper.service.ClienteService;
import com.projeto_final.Kaspper.service.PDFGeneratorService;
import com.projeto_final.Kaspper.service.ProjetoService;

import jakarta.validation.Valid;

@CrossOrigin(origins = "http://localhost:4200")
@Controller
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private ProjetoService projetoService;

    @Autowired
    private PDFGeneratorService pdfGeneratorService;

    @GetMapping("/novo")
    public String exibirFormularioCadastroCliente(Model model) {
        model.addAttribute("cliente", new Cliente()); // Corrigido para 'cliente'
        return "clienteFormulario";
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<String> salvarClienteEProjeto(@RequestBody @Valid Cliente cliente) {
        Cliente clienteSalvo = clienteService.salvar(cliente);
        System.out.println("cliente" + clienteSalvo);
        byte[] pdfData = pdfGeneratorService.generateOrcamentoPDFWithTemplate(clienteSalvo, clienteSalvo.getProjeto());
        String subject = "Orçamento Gerado";
        String body = "Segue em anexo o orçamento gerado.";
        pdfGeneratorService.sendEmailWithPDF(clienteSalvo.getEmail(), subject, body, pdfData, "orcamento.pdf");

        return ResponseEntity.ok("/clientes/" + clienteSalvo.getIdCliente() + "/projeto");

    }

    @GetMapping("/{id}/projeto")
    public String exibirDadosProjeto(@PathVariable("id") Integer id, Model model) {
        Cliente cliente = clienteService.buscarClientePorId(id);
        if (cliente == null) {
            return "redirect:/inicio";
        }
        model.addAttribute("cliente", cliente);
        return "dadosProjeto";
    }
}
