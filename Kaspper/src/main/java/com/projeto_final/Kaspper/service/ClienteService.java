package com.projeto_final.Kaspper.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projeto_final.Kaspper.model.Cliente;
import com.projeto_final.Kaspper.model.Projeto;
import com.projeto_final.Kaspper.repository.ClienteRepository;

import jakarta.transaction.Transactional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ProjetoService projetoService;

    @Transactional
    public Cliente salvar(Cliente cliente) {
        Projeto projeto = projetoService.salvar(cliente.getProjeto());
        cliente.setProjeto(projeto);
        return clienteRepository.save(cliente);
    }

    public Cliente buscarClientePorId(Integer id) {
        return clienteRepository.findById(id).orElse(null);
    }

    public List<Cliente> listarTodosClientes() {
        return clienteRepository.findAll();
    }

    @Transactional
    public void excluirDadosClienteEProjeto(Integer id) {
        clienteRepository.deleteById(id);
    }

    public List<Cliente> buscarClientesPorNomeCnpjEmail(String termo) {
        return clienteRepository.buscarPorNomeCnpjEmail(termo);
    }
}
