package com.example.fidelidad_api.services;

import com.example.fidelidad_api.models.Cliente;
import com.example.fidelidad_api.repositories.ClienteRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServicio {
    private final ClienteRepositorio clienteRepositorio;

    public ClienteServicio(ClienteRepositorio clienteRepositorio) {
        this.clienteRepositorio = clienteRepositorio;
    }

    public Cliente guardar(Cliente cliente) {
        return clienteRepositorio.save(cliente);
    }

    public List<Cliente> listarClientes() {
        return clienteRepositorio.findAll();
    }

    public Cliente buscarPorId(Integer id) {
        return clienteRepositorio.findById(id).orElse(null);
    }
}

