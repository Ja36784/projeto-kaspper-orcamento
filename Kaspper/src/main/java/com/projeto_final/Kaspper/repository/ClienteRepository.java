package com.projeto_final.Kaspper.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projeto_final.Kaspper.model.Cliente;

@Repository
public interface ClienteRepository  extends JpaRepository<Cliente, Integer> {
}
