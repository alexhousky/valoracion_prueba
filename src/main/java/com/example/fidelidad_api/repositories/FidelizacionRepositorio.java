package com.example.fidelidad_api.repositories;

import com.example.fidelidad_api.models.Fidelizacion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FidelizacionRepositorio extends JpaRepository<Fidelizacion, Integer> {
    boolean existsByClienteIdAndMarcaId(Integer clienteId, Integer marcaId);
    Optional<Fidelizacion> findByClienteIdAndMarcaId(Integer clienteId, Integer marcaId);
    List<Fidelizacion> findByClienteId(Integer clienteId);
    List<Fidelizacion> findByMarcaId(Integer marcaId);
}
