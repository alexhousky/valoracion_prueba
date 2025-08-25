package com.example.fidelidad_api.service;

import com.example.fidelidad_api.entity.Ciudad;
import java.util.List;

public interface CiudadService {
    Ciudad guardar(Ciudad ciudad);
    List<Ciudad> listarTodas();
    Ciudad obtenerPorId(Long id);
    void eliminar(Long id);
}


