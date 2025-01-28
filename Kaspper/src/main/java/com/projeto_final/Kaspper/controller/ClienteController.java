package com.projeto_final.Kaspper.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.projeto_final.Kaspper.model.Cliente;
import com.projeto_final.Kaspper.model.Status;
import com.projeto_final.Kaspper.service.ClienteService;
import com.projeto_final.Kaspper.service.PDFGeneratorService;
import com.projeto_final.Kaspper.service.ProjetoService;

import jakarta.validation.Valid;

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
        model.addAttribute("cliente", new Cliente());
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

    @GetMapping
    public String listarClientes(Model model) {
        model.addAttribute("clientes", clienteService.listarTodosClientes());
        return "clienteLista";
    }

    @GetMapping("/{id}/excluir")
    public String excluirCliente(@PathVariable("id") Integer id, RedirectAttributes redirectAttributes) {
        Cliente cliente = clienteService.buscarClientePorId(id);
        if (cliente != null) {
            clienteService.excluirDadosClienteEProjeto(id);
            redirectAttributes.addFlashAttribute("mensagem", "Deleção do cliente " + cliente.getNomeCliente() + " realizada com sucesso.");
        } else {
            redirectAttributes.addFlashAttribute("mensagem", "Cliente não encontrado.");
        }
        return "redirect:/clientes";
    }

    @GetMapping("/buscar")
    public String buscarClientes(@RequestParam("termo") String termo, Model model) {
        model.addAttribute("clientes", clienteService.buscarClientesPorNomeCnpjEmail(termo));
        return "clienteLista";
    }

    @PostMapping("/clientes")
    public String adicionarInformacao(
            @RequestParam("idCliente") Integer idCliente,
            @RequestParam("dataAlteracao") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dataAlteracao,
            @RequestParam("responsavelAlteracao") String responsavelAlteracao,
            @RequestParam("informativo") String informativo,
            @RequestParam("status") Status status,
            Model model) {

        Cliente cliente = clienteService.buscarClientePorId(idCliente);

        if (cliente != null) {
            cliente.setIdCliente(idCliente);
            cliente.setDataAlteracao(dataAlteracao);
            cliente.setResponsavelAlteracao(responsavelAlteracao);
            cliente.setInformativo(informativo);
            cliente.setStatus(status);
            clienteService.salvar(cliente);

            model.addAttribute("mensagem", "Informações adicionadas com sucesso.");
        } else {
            model.addAttribute("mensagem", "Cliente não encontrado.");
        }

        return "redirect:/clientes";
    }


}
