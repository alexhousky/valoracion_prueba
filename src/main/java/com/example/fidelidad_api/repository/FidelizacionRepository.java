package com.example.fidelidad_api.repository;

import com.example.fidelidad_api.entity.Fidelizacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FidelizacionRepository extends JpaRepository<Fidelizacion, Long> {
}

