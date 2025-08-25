package com.example.fidelidad_api.service;

import com.example.fidelidad_api.entity.Pais;
import java.util.List;

public interface PaisService {
    Pais guardar(Pais pais);
    List<Pais> listarTodos();
    Pais obtenerPorId(Long id);
    void eliminar(Long id);
}
