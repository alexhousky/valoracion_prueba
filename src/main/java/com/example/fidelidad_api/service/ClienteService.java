package com.example.fidelidad_api.service;

import com.example.fidelidad_api.entity.Cliente;
import java.util.List;

public interface ClienteService {
    Cliente guardarCliente(Cliente cliente);
    List<Cliente> listarClientes();
}

