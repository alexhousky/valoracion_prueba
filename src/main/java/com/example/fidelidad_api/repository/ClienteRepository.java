package com.example.fidelidad_api.repository;

import com.example.fidelidad_api.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    boolean existsByEmail(String email);
    boolean existsByNumeroIdentificacion(String numeroIdentificacion);
}