package com.projeto_final.Kaspper.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.projeto_final.Kaspper.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

    @Query("SELECT c FROM Cliente c WHERE "
            + "LOWER(c.nomeCliente) LIKE LOWER(CONCAT('%', :termo, '%')) "
            + "OR LOWER(c.cpfCnpj) LIKE LOWER(CONCAT('%', :termo, '%')) "
            + "OR LOWER(c.email) LIKE LOWER(CONCAT('%', :termo, '%'))")
    List<Cliente> buscarPorNomeCnpjEmail(@Param("termo") String termo);
}
