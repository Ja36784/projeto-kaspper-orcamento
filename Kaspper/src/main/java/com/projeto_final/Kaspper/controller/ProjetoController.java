// package com.projeto_final.Kaspper.controller;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.ModelAttribute;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestParam;

// import com.projeto_final.Kaspper.model.Cliente;
// import com.projeto_final.Kaspper.model.Projeto;
// import com.projeto_final.Kaspper.service.ClienteService;
// import com.projeto_final.Kaspper.service.ProjetoService;

// @Controller
// @RequestMapping("/projetos")
// public class ProjetoController {

//     @Autowired
//     private ProjetoService projetoService;

//     @Autowired
//     private ClienteService clienteService; 

//     @GetMapping("/novo")
//     public String exibirFormularioDeCadastro(Model model) {
//         model.addAttribute("projeto", new Projeto());
//         return "projetoFormulario";
//     }

//     @PostMapping
//     public String salvarProjeto(@ModelAttribute Projeto projeto, @RequestParam String clienteId) {
        
//         Cliente cliente = clienteService.buscarPorId(Integer.valueOf(clienteId));
        
//         if (cliente != null) {
//             projeto.setCliente(cliente);  
//             projetoService.salvar(projeto); 
//         } else {
            
//             return "erroClienteNaoEncontrado"; 
//         }

//         return "redirect:/orcamentos/novo?clienteId=" + cliente.getIdCliente() + "&projetoId=" + projeto.getIdProjeto();

//     }

    
    
// }