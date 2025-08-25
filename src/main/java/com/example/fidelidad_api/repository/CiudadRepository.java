package com.example.fidelidad_api.repository;

import com.example.fidelidad_api.entity.Ciudad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CiudadRepository extends JpaRepository<Ciudad, Long> {
    boolean existsByNombre(String nombre);
}
