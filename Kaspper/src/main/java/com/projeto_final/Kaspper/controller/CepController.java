package com.projeto_final.Kaspper.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto_final.Kaspper.service.CepService;

@RestController
@RequestMapping("/api/cep")
public class CepController {

    @Autowired
    private CepService cepService;

    @GetMapping("/{cep}")
    public Map<String, Object> buscarCep(@PathVariable String cep) {
        return cepService.buscarCep(cep);
    }
}
