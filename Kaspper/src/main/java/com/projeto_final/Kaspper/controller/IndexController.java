package com.projeto_final.Kaspper.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/inicio")
    public String mostrarTelaInicial() {
        return "paginaInicial"; 
    }
}
