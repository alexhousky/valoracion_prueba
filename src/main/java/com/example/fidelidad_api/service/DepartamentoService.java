package com.example.fidelidad_api.service;

import com.example.fidelidad_api.entity.Departamento;
import java.util.List;

public interface DepartamentoService {
    Departamento guardar(Departamento departamento);
    List<Departamento> listarTodos();
    Departamento obtenerPorId(Long id);
    void eliminar(Long id);
}
