package com.projeto_final.Kaspper;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.projeto_final.Kaspper.model.Cliente;
import com.projeto_final.Kaspper.model.Projeto;
import com.projeto_final.Kaspper.repository.ClienteRepository;

@SpringBootTest
public class testeController {

    @Autowired
    private ClienteRepository clienteRepository;

    @Test
    public void salvarCliente() {
        Cliente cliente = new Cliente();
        cliente.setNomeCliente("Teste");
        cliente.setCpfCnpj("12345678901");
        cliente.setEmail("teste@exemplo.com");

        Projeto projeto = new Projeto();
        //projeto.setTipoProjeto("Software");
        projeto.setQuantidadeFuncionalidades(5);

        cliente.setProjeto(projeto);

        Cliente salvo = clienteRepository.save(cliente);
        assertNotNull(salvo.getIdCliente());
    }
}