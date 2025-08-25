package com.example.fidelidad_api.service;

import com.example.fidelidad_api.entity.Cliente;
import java.util.List;

public interface ClienteService {
    Cliente guardar(Cliente cliente);
    List<Cliente> listarTodos();
    Cliente obtenerPorId(Long id);
    void eliminar(Long id);
}

