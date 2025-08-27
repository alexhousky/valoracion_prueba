package com.example.fidelidad_api.services;

import com.example.fidelidad_api.models.Cliente;
import com.example.fidelidad_api.repositories.ClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServicio {

    @Autowired
    private ClienteRepositorio clienteRepositorio;

    // ✅ Listar todos los clientes
    public List<Cliente> obtenerTodosLosClientes() {
        return clienteRepositorio.findAll();
    }

    // Guardar cliente
    public Cliente guardarCliente(Cliente cliente) {
        return clienteRepositorio.save(cliente);
    }

    // Buscar por ID
    public Cliente obtenerClientePorId(Long id) {
        return clienteRepositorio.findById(id).orElse(null);
    }

    // Eliminar por ID
    public void eliminarCliente(Long id) {
        clienteRepositorio.deleteById(id);
    }
}


