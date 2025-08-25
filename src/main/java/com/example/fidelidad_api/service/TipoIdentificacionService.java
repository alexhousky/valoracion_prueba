package com.example.fidelidad_api.service;

import com.example.fidelidad_api.entity.TipoIdentificacion;

import java.util.List;
import java.util.Optional;

public interface TipoIdentificacionService {

    List<TipoIdentificacion> findAll();

    Optional<TipoIdentificacion> findById(Long id);

    TipoIdentificacion save(TipoIdentificacion tipoIdentificacion);

    void deleteById(Long id);
}
