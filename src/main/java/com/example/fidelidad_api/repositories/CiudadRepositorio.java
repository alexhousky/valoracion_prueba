package com.example.fidelidad_api.repositories;

import com.example.fidelidad_api.models.Ciudad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CiudadRepositorio extends JpaRepository<Ciudad, Long> {

    // Spring Data JPA generará la query automáticamente
    List<Ciudad> findByDepartamentoId(Long departamentoId);
}

