package com.example.fidelidad_api.service;

import com.example.fidelidad_api.entity.TipoIdentificacion;
import java.util.List;

public interface TipoIdentificacionService {
    List<TipoIdentificacion> getAll();
    TipoIdentificacion getById(Long id);  // <-- Falta este
    TipoIdentificacion create(TipoIdentificacion tipoIdentificacion);
    TipoIdentificacion update(TipoIdentificacion tipoIdentificacion);
    void delete(Long id);
}

