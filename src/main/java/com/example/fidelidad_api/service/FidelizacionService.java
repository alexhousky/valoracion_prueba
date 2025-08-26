package com.example.fidelidad_api.service;

import com.example.fidelidad_api.entity.Fidelizacion;
import java.util.List;
import java.util.Optional;

public interface FidelizacionService {
    List<Fidelizacion> findAll();
    Optional<Fidelizacion> findById(Long id);
    Fidelizacion save(Fidelizacion fidelizacion);
    void deleteById(Long id);
}


